/** 
 * The <code>SongList</code> implements a represesntation of a 
 * linked list containing <code>SongNodes</code>
 * 
 * @author Brian Chau
 *    email brian.chau@stonybrook.edu
 *    Stony Brook ID: brchau  
 *    Recitation: 02
**/
a
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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

    public void Play(String name) throws IllegalArgumentException{
        //Play the audio file based on name in cursor song node
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

        if(cursor == null)
        {
            throw new IllegalArgumentException("The playlist is empty");
        }

        cursor.getPrev().setNext(cursor.getNext());
        cursor.getNext().setPrev(cursor.getPrev());

        if(cursor.getNext() == null)
        {
            cursor = cursor.getPrev();
        } 
        else
        {
            cursor = cursor.getNext();
        }

        return removedSong;
    }

    public void insertAfterCursor(Song newSong){
        SongNode newNode = new SongNode(newSong);
        newNode.setNext(cursor.getNext());
        newNode.setPrev(cursor);
        cursor.getNext().setPrev(newNode);
        cursor.setNext(newNode);
    }

    public Song random(){
        return randomChooser().getSong();
    }

    public SongNode randomChooser(){
        int randPos = (int) (Math.random() * size);
        SongNode pointer = head;
        while(randPos > 0 && pointer != null){
            pointer = pointer.getNext();
            randPos--; //Removes one from randPos to prevent use of another variable
        }
        return pointer;
    }

    public void deleteAll(){
        head = null;
        tail = null;
        cursor = null;
        size = 0;
    }

    public String toString(){
        String format = "%-26s%-27s%-27s%-12u\n";
        String heading = String.format(format, "Song", "| Artist", "| Album", "| Length (s)");
        String seperator = "_".repeat(91) + "\n";
        String fullTable = heading + seperator;
        SongNode pointer = head;
        while(pointer != null){
            fullTable += pointer.getSong().toString();
        }
        return fullTable;
    }
}
