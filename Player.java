/** 
 * The <code>Player</code> provides a user interface to
 * interact with the SongList.
 * 
 * @author Brian Chau
 *    email brian.chau@stonybrook.edu
 *    Stony Brook ID: brchau  
 *    Recitation: 02
**/
import java.util.Scanner;

public class Player {
    /**
     * The main method runs a menu driven application that first
     * creates an empty <code>HiringTable</code> object.
     * The program then prompts the user for a command in order to execute an operation.
     * Once a command has been chosen, the program may ask the user for additional
     * information if necessary to perform the operation.
     *
     * All operations:
     * (A) Add Applicant <Company> <Applicant Name> <GPA> <College> <Skills>
     *     Adds a new applicant onto the end of the list
     * (R) Remove Applicant <Applicant Name>
     *     Removes the applicant based on name
     * (G) Get applicant <Name>
     *     Displays the information of the applicant based on the name entered
     * (P) Print List
     *     Prints all the applicants in the list
     * (RS) Refine Search <Company> <Skill> <College> <GPA>
     *     Returns a list of applicants that have met the search criteria
     * (S) Size
     *     Displays the number of applicants in the list
     * (B) Backup
     *     Creates a backup of the list in memory
     * (CB) Compare Backup
     *     Checks if the current list and the backup are the same
     * (RB) Revert Backup
     *     Reverts to the previously backed-up list
     * (Q) Quit
     *     Terminates the program
     */

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean running = true;
        SongList songList = new SongList();
        printPrompt();
        while(running){
            System.out.print("Please enter a command: ");
            String option = input.nextLine();
            option = option.toUpperCase().strip();
            if(option.equals("A")){
                addApplicantUI(input, songList);
            }
            else if(option.equals("F")){
                try{
                    songList.cursorFowards();
                }
                catch(NullCursor exception){
                    System.out.println(exception.getMessage());
                }
            }
            else if(option.equals("B")){
                try{
                    songList.cursorBackwards();
                }
                catch(NullCursor exception){
                    System.out.println(exception.getMessage());
                }
            }
            else if(option.equals("R")){
                try{
                    songList.removeCursor();
                }
                catch(NullCursor exception){
                    System.out.println(exception.getMessage());
                }
            }
            else if(option.equals("L")){
                songList.play(songList.getCursor().getSong().getName());
            }
            else if(option.equals("C")){
                songList.deleteAll();
            }
            else if(option.equals("S")){
                songList.shuffle();
            }
            else if(option.equals("Z")){
                songList.random();
            }
            else if(option.equals("P")){
                songList.printPlayerList();
            }
            else if(option.equals("T")){
                System.out.println(songList.getSize());
            }
            else if(option.equals("Q")){
                running = false;
            }
        }
        input.close();
    }

    private static void printPrompt(){
        System.out.println("(A)  Add Song");
        System.out.println("(F)  Go to Next Song");
        System.out.println("(B)  Go to Previous Song");
        System.out.println("(R)  Remove Song from Playlist");
        System.out.println("(L)  Play a Song");
        System.out.println("(C)  Clear the Playlist");
        System.out.println("(S)  Shuffle Playlist");
        System.out.println("(Z)  Random Song");
        System.out.println("(P)  Print Playlist");
        System.out.println("(T)  Get the total amount of songs in the playlist");
        System.out.println("(Q)  Exit the playlist");

    }

    /**
     * Gives the user a prompt to give info about the song to
     * add to the <code>SongList</code>.
     *
     * @param prompt
     *     The scanner used to take in user input
     * @param list
     *     THe <code>SongList</code> that the method will work with
     */
    private static void addApplicantUI(Scanner prompt, SongList list){
        String songName = null;
        String artistName = null;
        String albumName = null;
        int length = 0;
        songName = getString(prompt, "Enter Song Name: ");
        artistName = getString(prompt, "Enter Artist Name: ");
        albumName = getString(prompt, "Enter Album Name: ");
        length = getInt(prompt, "Enter Song Length: ");
        Song nextSong = new Song(songName, artistName, albumName, length);
        list.insertAfterCursor(nextSong);
    }

    /**
     * Will prompt the user for a string and will only exit once a non-empty string is given
     *
     * @param prompt
     *     The scanner used to take in user input
     * @param userPrompt
     *     The prompt that will be given to the user to indicate that they can give a response
     * @return
     *    Returns the string that was given by the user
     */
    private static int getInt(Scanner prompt, String userPrompt)
    {
        int field = 0;
        String answer = prompter(prompt, userPrompt);
        try
        {
            field = Integer.parseInt(answer);
        }
        catch(Exception e)
        {
            System.out.println("The response given is not a valid number");
            field = getInt(prompt, userPrompt);
        }
        return field;
    }

    /**
     * Will prompt the user for a string and will only exit once a non-empty string is given
     *
     * @param prompt
     *     The scanner used to take in user input
     * @param userPrompt
     *     The prompt that will given to the user to indicate that they can give a response
     * @return
     *    Returns the string that was given by the user
     */
    private static String getString(Scanner prompt, String userPrompt){
        boolean filled = false;
        String field = null;
        while(!filled)
        {
            field = prompter(prompt, userPrompt);
            if(field != "")
            {
                filled = true;
            }
        }
        return field;
    }

    private static String prompter(Scanner prompt, String userPrompt){
        String answer = null;
        System.out.print(userPrompt);
        answer = prompt.nextLine().strip();
        return answer;
    }
}
