/** 
 * The <code>SongNode</code> implements a represesntation of a 
 * node containing a <code>Song</code> for a linked list
 * 
 * @author Brian Chau
 *    email brian.chau@stonybrook.edu
 *    Stony Brook ID: brchau  
 *    Recitation: 02
**/

public class SongNode {
    private SongNode prev;
    private SongNode next;
    private Song song;

    public SongNode()
    {
        
    }

    public SongNode(Song song){
        this.song = song;
    }
}
