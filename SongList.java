/** 
 * The <code>SongList</code> implements a represesntation of a 
 * linked list containing <code>SongNodes</code>
 * 
 * @author Brian Chau
 *    email brian.chau@stonybrook.edu
 *    Stony Brook ID: brchau  
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

    public SongList()
    {

    }

    public SongList(SongNode inital)
    {
        //Creates a song list with an initial node given
        head = inital;
        tail = inital;
        cursor = inital;
        size = 1;
    }

    public void play(String name) throws IllegalArgumentException{
        //Play the audio file based on name in cursor song node
        try {
            File audioFile = new File(name + ".wav");
            AudioInputStream audio = AudioSystem.getAudioInputStream(audioFile);
            Clip c = AudioSystem.getClip();
            c.open(audio);
            c.start();
        }
        catch (Exception ex)
        {
            System.out.println("Could not play music");
        }
    }

    public void cursorFowards(){
        if(cursor != tail)
        {
            cursor = cursor.getNext();
        }
    }

    public void cursorBackwards(){
        if(cursor != head)
        {
            cursor = cursor.getPrev();
        }
    }

    public Song removeCursor() throws IllegalArgumentException{
        Song removedSong = cursor.getSong();
        removeSong(cursor);
        return removedSong;
    }

    public int getSize(){
        return size;
    }

    public void insertAfterCursor(Song newSong){
        SongNode newNode = new SongNode(newSong);
        insertNode(newNode);
    }

    public Song random(){

        return randomChooser().getSong();
    }

    public void shuffle(){
        SongList newList = new SongList();
        while(size > 0){
            SongNode randomNode = removeSong(randomChooser());
            newList.insertNode(randomNode);
        }
        head = newList.head;
        tail = newList.tail;
        cursor = newList.cursor;
        size = newList.size;
    }

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

    public void deleteAll(){
        head = null;
        tail = null;
        cursor = null;
        size = 0;
    }

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

    private SongNode removeSong(SongNode node){
        if(node == null)
        {
            throw new IllegalArgumentException("The playlist is empty");
        }
        else if(node == head)
        {
            head = node.getNext();
        }
        else
        {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }

        if(node.getNext() == null)
        {
            node = node.getPrev();
        }
        else
        {
            node = node.getNext();
        }
        size--;
        return node;
    }

    private void insertNode(SongNode newNode){
        if(head == null)
        {
            head = newNode;
            tail = head;
            cursor = head;
        }
        else if(cursor == tail){
            tail.setNext(newNode);
            tail = newNode;
            cursor = tail;
        }
        else
        {
            newNode.setNext(cursor.getNext());
            newNode.setPrev(cursor);
            cursor.getNext().setPrev(newNode);
            cursor.setNext(newNode);
        }
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
