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

    /**
     * Returns the value of the <code>prev</code> field
     * 
     * 
     * @return
     *     The SongNode in the <code>prev</code> field
     **/

     public SongNode getPrev(){
        return prev;
    }

    /**
     * Returns the value of the <code>next</code> field
     * 
     * 
     * @return
     *     The SongNode in the <code>next</code> field
     **/

     public SongNode getNext(){
        return next;
    }

    /**
     * Returns the value of the <code>song</code> field
     * 
     * 
     * @return
     *     The Song in the <code>song</code> field
     **/

     public Song getSong(){
        return song;
    }

    /**
     * Sets the value of the field <code>prev</code> to the <code>newPrev</code>
     * 
     * @param newPrev
     *    SongNode that represents the new value of the prev field
     **/
    public void setPrev(SongNode newPrev){
        prev = newPrev;
    }

    /**
     * Sets the value of the field <code>next</code> to the <code>newNext</code>
     * 
     * @param newNext
     *    SongNode that represents the new value of the next field
     **/
    public void setNext(SongNode newNext){
        next = newNext;
    }

    /**
     * Sets the value of the field <code>song</code> to the <code>newSong</code>
     * 
     * @param newSong
     *    Song that represents the new value of the song field
     **/
    public void setSong(Song newSong){
        song = newSong;
    }
}
