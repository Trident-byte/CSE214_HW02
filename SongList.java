/** 
 * The <code>SongList</code> implements a represesntation of a 
 * linked list containing <code>SongNodes</code>
 * 
 * @author Brian Chau
 *    email brian.chau@stonybrook.edu
 *    Stony Brook ID: 116125954  
 *    Recitation: 02
**/

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SongList {
    private SongNode head;
    private SongNode tail;
    private SongNode cursor;
    private int size;

    /**
     * Creates an empty <code>SongList</code> object
     */
    public SongList()
    {

    }

    /**
     * Creates a <code>SongList</code> object with an initial node
     * 
     * @param inital
     *    The first node of the linked list
     */
    public SongList(SongNode inital)
    {
        //Creates a song list with an initial node given
        head = inital;
        tail = inital;
        cursor = inital;
        size = 1;
    }

    /**
     * Plays the song indicated by name. 
     * The song must be present in your current 
     * working directory to play
     * 
     * <dt>Precondition
     *    <dd>The name must match an actual song name in the playlist and there must be a file associated with it.
     * 
     * <dt>Postcondition
     *    <dd>The song is now playing.
     * 
     * @param name
     *    The name of song to be played
     * @throws IllegalArgumentException
     *    Indicates that the provided name does not correspond 
     *    to a song in the playlist, or that the wav file could not be found.
     */
    public void play(String name) throws IllegalArgumentException{
        //Play the audio file based on name in cursor song node
        SongNode pointer = head;
        while(pointer != null && !pointer.getSong().getName().equals(name)){
            pointer = pointer.getNext();
        }
        if(pointer == null){
            throw new IllegalArgumentException();
        }
        try {
            File audioFile = new File(name + ".wav");
            AudioInputStream audio = AudioSystem.getAudioInputStream(audioFile);
            Clip c = AudioSystem.getClip();
            System.out.printf("'%s' by %s is now playing.", pointer.getSong().getName(), pointer.getSong().getArtist());
            c.open(audio);
            c.start();
        }
        catch (Exception ex)
        {
            System.out.println("Could not play music");
        }
    }

    /**
     * Moves the cursor to point at the next SongNode. 
     * This and the cursorBackwards() method are the user's main way of moving around the Linked List.
     * 
     * <dt>Precondition
     *   <dd>The list is not empty(cursor is not null)
     * 
     * <dt>Postcondition
     *    <dd>The cursor has been advanced to the next SongNode, or has remained at the tail of the list.
     * 
     * @throws NullCursor
     *    Indicates that the list is empty
     */
    public void cursorFowards() throws NullCursor{
        if(cursor == null)
        {
            throw new NullCursor();
        }
        if(cursor != tail)
        {
            cursor = cursor.getNext();
            System.out.println("Cursor moved to the next song.");
        }
        else
        {
            System.out.println("Already at the end of the playlist.");
        }
    }

    /**
     * Moves the cursor to point at the next SongNode. 
     * This and the cursorFowards() method are the user's main way of moving around the Linked List.
     * 
     * <dt>Precondition
     *   <dd>The list is not empty(cursor is not null)
     * 
     * <dt>Postcondition
     *    <dd>The cursor has been moved back to the previous SongNode, or has remained at the head of the list.
     * 
     * @throws NullCursor
     *    Indicates that the list is empty
     */
    public void cursorBackwards() throws NullCursor{
        if(cursor == null)
        {
            throw new NullCursor();
        }
        if(cursor != head)
        {
            cursor = cursor.getPrev();
            System.out.println("Cursor moved to the previous song.");
        }
        else
        {
            System.out.println("Already at the beginning of the playlist.");
        }
    }

    /**
     * Removes the SongNode referenced by the cursor and returns the Song contained within the node.
     * 
     * <dt>Precondition
     *   <dd>The cursor is not null.
     * 
     * <dt>Postcondition
     *    <dd>The SongNode referenced by the cursor has been removed from the playlist.
     *    <dd>The cursor now references the next node, or the previous node if no next node exists.
     * 
     * @return
     *    The Song contained within the removed SongNode.
     * @throws NullCursor
     *    Indicates that the list is empty
     */
    public Song removeCursor() throws NullCursor{
        Song removedSong = cursor.getSong();
        try{
            removeSong(cursor);
        }
        catch(Exception e){
            throw new NullCursor();
        }
        return removedSong;
    }

    /**
     * Returns the size of the linked list using the number in the size field
     * 
     * @return
     *    The value in the size field
     */
    public int getSize(){
        return size;
    }

    /**
     * Inserts a song into the playlist after the cursor position. 
     * The user will have to move the cursor using the cursor methods 
     * above to add a song after a specific song if they want.
     * 
     * @param newSong
     *    The <code>Song</code> to be inserted into the playlist.
     * 
     * <dt>Postcondition
     *    <dd>The new Song is inserted into the playlist after the position of the cursor.
     *    <dd>All Song objects previously in the playlist are still in the playlist, and 
     *        the order of the playlist is preserved.  
     *    <dd>The cursor now points to the inserted node.
     * 
     * @throws IllegalArgumentException
     *    Indicates that the <code>newSong</code> is null
     */
    public void insertAfterCursor(Song newSong) throws IllegalArgumentException{
        if(newSong == null){
            throw new IllegalArgumentException("Song is not valid");
        }
        SongNode newNode = new SongNode(newSong);
        insertNode(newNode);
    }

    /**
     * Select one of the songs in the playlist and play it at random.
     * 
     * <dt>Postcondition
     *    <dd>The song will now be playing
     * 
     * @return
     *    The <code>Song</code> that was randomly selected
     */
    public Song random(){
        System.out.println("Playing a random song...");
        Song randomSong = randomChooser().getSong();
        play(randomSong.getName());
        return randomSong;
    }

    /**
     * Randomly shuffles the order of the songs contained within the playlist.
     * 
     * <dt>Postcondition
     *    <dd>The playlist is randomly reordered.
     *    <dd><code>Cursor</code> references the <code>SongNode</code> which contains the same <code>Song</code> as when this method was entered.
     */
    public void shuffle(){
        SongList newList = new SongList();
        SongNode orignalCursor = cursor;
        while(size > 0){
            try{
                SongNode randomNode = removeSong(randomChooser());
                randomNode.setNext(null);
                randomNode.setPrev(null);
                newList.insertNode(randomNode);
            }
            catch(IllegalArgumentException e){
                break;
            }
        }
        head = newList.head;
        tail = newList.tail;
        cursor = orignalCursor;
        size = newList.size;
    }

    /**
     * Prints the playlist in a neatly-formatted table.
     * 
     */
    public void printPlayerList(){
        System.out.print(formHeading());
        SongNode pointer = head;
        while(pointer != null){
            System.out.print(pointer.getSong().toString());
            if(pointer == cursor){
                System.out.print(" <-");
            }
            System.out.println();
            pointer = pointer.getNext();
        }
    }

    /**
     * This will simply delete all of the songs from the playlist.
     * 
     * <dt>Postcondition
     *    <dd>All songs have been removed.
     */
    public void deleteAll(){
        head = null;
        tail = null;
        cursor = null;
        size = 0;
    }

    /**
     * Returns a neatly formatted String representation of the playlist. See the Sample I/O for layout.
     * 
     * @return
     *    A neatly formatted String representing the playlist in tabular form.
     */
    public String toString(){
        String fullTable = formHeading();
        SongNode pointer = head;
        while(pointer != null){
            fullTable += pointer.getSong().toString() + "\n";
        }
        return fullTable;
    }

    /**
     * Sets the value of the field <code>head</code> to the <code>newHead</code>
     *
     * @param newHead
     *    SongNode that represents the new head
     **/
    public void setHead(SongNode newHead){

        head = newHead;
    }

    /**
     * Sets the value of the field <code>tail</code>
     *
     * @param tail
     *    SongNode that represents the new tail
     **/
    public void setTail(SongNode tail) {
        this.tail = tail;
    }

    /**
     * Sets the value of the field <code>cursor</code>
     *
     * @param cursor
     *    SongNode that represents the new cursor
     **/
    public void setCursor(SongNode cursor) {
        this.cursor = cursor;
    }

    /**
     * Returns the value of the <code>head</code> field
     *
     *
     * @return
     *     The SongNode in the <code>head</code> field
     **/
    public SongNode getHead() {
        return head;
    }

    /**
     * Returns the value of the <code>tail</code> field
     *
     *
     * @return
     *     The SongNode in the <code>tail</code> field
     **/
    public SongNode getTail() {
        return tail;
    }

    /**
     * Returns the value of the <code>cursor</code> field
     *
     *
     * @return
     *     The SongNode in the <code>cursor</code> field
     **/
    public SongNode getCursor() {
        return cursor;
    }

    private String formHeading(){
        String format = "%-26s%-27s%-27s%-12s\n";
        String heading = String.format(format, "Song", "| Artist", "| Album", "| Length (s)");
        String seperator = "_".repeat(91) + "\n";
        String header = heading + seperator;
        return header;
    }

    private SongNode removeSong(SongNode node) throws IllegalArgumentException{
        System.out.println(node.getSong().getName());
        size--;
        if(node == null)
        {
            throw new IllegalArgumentException();
        }
        else if(node == head)
        {
            head = node.getNext();
            if(head != null){
                head.setPrev(null);
            }
            else
            {
                deleteAll();
            }
            return node;
        }
        else if(node == tail) {
            tail = node.getPrev();
            if(tail != null){
                tail.setNext(null);
            }
            else
            {
                deleteAll();
            }
            return node;
        }
        else
        {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }

        if(size != 0 && node.getNext() == null)
        {
            node = node.getPrev();
        }
        else
        {
            node = node.getNext();
        }
        return node;
    }

    private void insertNode(SongNode newNode){
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else if(cursor == tail){
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        else if(cursor == head){
            head.setPrev(newNode);
            newNode.setNext(head);
        }
        else
        {
            newNode.setNext(cursor.getNext());
            newNode.setPrev(cursor);
            cursor.getNext().setPrev(newNode);
            cursor.setNext(newNode);
        }
        cursor = newNode;
        size++;
    }

    private SongNode randomChooser(){
        int randPos = (int) (Math.random() * size);
        SongNode pointer = head;
        while(randPos > 0 && pointer != null){
            pointer = pointer.getNext();
            randPos--; //Removes one from randPos to prevent use of another variable
        }
        return pointer;
    }
}
