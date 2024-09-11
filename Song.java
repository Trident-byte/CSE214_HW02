/** 
 * The <code>Song</code> implements a represesntation of a song
 * 
 * @author Brian Chau
 *    email brian.chau@stonybrook.edu
 *    Stony Brook ID: brchau  
 *    Recitation: 02
**/

public class Song{
    private String name;
    private String artist;
    private String albumString;
    private int length;
    
    public Song()
    {
        name = "";
        artist = "";
        albumString = "";
    }

    public Song(String name, String artist, String albumLength, int length){
        this.name = name;
        this.artist = artist;
    }

    /**
     * Sets the value of the field <code>name</code> to the <code>name</code>
     * 
     * @param newName
     *    String that represents the new value of the name field
     **/
    public void setName(String newName){
        name = newName;
    }

    /**
     * Sets the value of the field <code>artist</code> to the <code>artist</code>
     * 
     * @param newArtist
     *    String that represents the new value of the artist field
     **/
    public void setArtist(String newArtist){
        artist = newArtist;
    }

    /**
     * Sets the value of the field <code>albumString</code> to the <code>albumString</code>
     * 
     * @param newAlbumString
     *    String that represents the new value of the albumString field
     **/
    public void setAlbumString(String newAlbumString){
        albumString = newAlbumString;
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

    
    
}