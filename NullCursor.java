import java.lang.Exception;
/**
 * The <code>NullCursor</code> implements an exception that indicates that
 * the <code>SongList</code> is empty because the cursor is null
 *
 * @author Brian Chau
 *    email brian.chau@stonybrook.edu
 *    Stony Brook ID: 116125954
 *    Recitation: 02
 **/
public class NullCursor extends Exception{
    /**
     * Creates a new <code>NullCursor</code> exception 
     */
    public NullCursor(){
        super("Your playlist is empty");
    }
}
