/** 
 * The <code>SongList</code> implements a represesntation of a 
 * linked list containing <code>SongNodes</code>
 * 
 * @author Brian Chau
 *    email brian.chau@stonybrook.edu
 *    Stony Brook ID: brchau  
 *    Recitation: 02
**/

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
        size = 1;
    }
}
