/** 
 * The <code>Song</code> implements a represesntation of a song
 * 
 * @author Brian Chau
 *    email brian.chau@stonybrook.edu
 *    Stony Brook ID: 116125954  
 *    Recitation: 02
**/

public class Song{
    private String name;
    private String artist;
    private String albumString;
    private int length;
    
    /**
     * Creates an empty <code>Song</code> object
     * 
     * 
     */
    public Song()
    {
        name = "";
        artist = "";
        albumString = "";
    }

    /**
     * Creates a <code>Song</code> object with given values
     * 
     * @param name
     *   The String to be put in the name field
     * @param artist
     *   The String to be put in the artist field
     * @param albumLength
     *   The String to be put in the albumLength field
     * @param length
     *   The integer to be put in the length field
     */
    public Song(String name, String artist, String albumLength, int length){
        this.name = name;
        this.artist = artist;
        this.albumString = albumLength;
        this.length = length;
    }

    /**
     * Sets the value of the field <code>name</code> to the <code>newName</code>
     * 
     * @param newName
     *    String that represents the new value of the name field
     **/
    public void setName(String newName){
        name = newName;
    }

    /**
     * Sets the value of the field <code>artist</code> to the <code>newAtist</code>
     * 
     * @param newArtist
     *    String that represents the new value of the artist field
     **/
    public void setArtist(String newArtist){
        artist = newArtist;
    }

    /**
     * Sets the value of the field <code>albumString</code> to the <code>newAlbumString</code>
     * 
     * @param newAlbumString
     *    String that represents the new value of the albumString field
     **/
    public void setAlbumString(String newAlbumString){
        albumString = newAlbumString;
    }

    /**
     * Sets the value of the field <code>length</code> to the <code>newLength</code>
     * 
     * @param newLength
     *    int that represents the new value of the length field
     **/
    public void setLength(int newLength){
        length = newLength;
    }


    /**
     * Returns the value of the <code>name</code> field
     * 
     * 
     * @return
     *     The String in the <code>name</code> field
     **/

    public String getName(){
        return name;
    }

    /**
     * Returns the value of the <code>albumString</code> field
     * 
     * 
     * @return
     *     The String in the <code>albumString</code> field
     **/

     public String getAlbumString(){
        return albumString;
    }

    /**
     * Returns the value of the <code>artist</code> field
     * 
     * 
     * @return
     *     The String in the <code>artist</code> field
     **/

     public String getArtist(){
        return artist;
    }

    /**
     * Returns the value of the <code>length</code> field
     * 
     * 
     * @return
     *     The int in the <code>length</code> field
     **/

     public int getLength(){
        return length;
    }

    public String toString(){
        String format = "%-26s%-27s%-27s%-12d";
        return String.format(format, name, artist, albumString, length);
    }
}