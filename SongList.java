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

    public void Play(String name){
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
}
