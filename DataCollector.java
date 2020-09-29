import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Michael B
 * Provides input from a file for use in a game storage hash table 
 */
public class DataCollector {
private static Scanner in;
private File input;
private Game[][] gameStats;
private User[] users;

  /**
   * Creates a DataCollector object that reads in data from input and creates the following Game and User objects to be stored in an Array
   * @param input - file location of input data
   * @throws FileNotFoundException
   */
  public DataCollector(String input) throws FileNotFoundException {
    this.input = new File(input);
    this.updateInput();
  }
  
  /** Changes the file of the input data to read from
   * @param input - file location of input data
   */
  public void setFile(String input) {
    this.input = new File(input);
  }

  /** Returns a 2D array of gameStats
   * @return gameStats - 2D array of gameStats info according to order in Users
   */
  public Game[][] getGameStats(){
    return gameStats;
  }
  
  /** Returns array of Users
   * @return users - array of users created by info in data file
   */
  public User[] getUsers() {
    return users;
  }
  
  /** Instantiates important DataCollection fields and processes data in data file.
   * @throws FileNotFoundException
   */
  public void updateInput() throws FileNotFoundException{
   //Creates a fresh Scanner
   this.in = new Scanner(this.input);
   //Skips the comment line
   in.nextLine();
   //Calculates number of games and users
   String temp = in.nextLine();
   temp = temp.replace(" ", "");
   temp = temp.replace("Numberofgames:", "");
   int numberOfGames = Integer.parseInt(temp);
   temp = in.nextLine();
   temp = temp.replace(" ", "");
   temp = temp.replace("NumberofUsers:", "");
   int numberOfUsers = Integer.parseInt(temp);
   //Adds all games to the array for later use
   String[] gameNames = new String[numberOfGames];
   for(int i = 0; i < numberOfGames; i++) {
     if(in.hasNext()) {
       temp = in.next();
       if(temp.contains("_")) {
         temp = temp.replace("_", " ");
       }
       gameNames[i] = temp;
     }
   }
   // Prepare for data extraction
   double timePlayed;
   double completion;
   double personalRating;
   Game[] gameCollection = new Game[numberOfGames];
   users = new User[numberOfUsers];
   gameStats = new Game[numberOfGames][1];
   //Read all users
   for(int h =0; h < numberOfUsers; h++) {
     //Get the name of the user
     in.next();
     String userName = in.next();
   for(int i = 0; i < numberOfGames; i++) {
     //Skip the junk
     in.next();
     in.next();
     if(i != 0) {
       in.next();
     }
     //Get the info needed for the Game object
     timePlayed = in.nextDouble();
     in.next();
     completion = in.nextDouble();
     in.next();
     personalRating = in.nextDouble();
     //Make the game object
     Game toAdd = new Game(gameNames[i],timePlayed,completion,personalRating);
     //Save it for later
     gameCollection[i] = toAdd;
   }
   //Store game stats collected from file
   gameStats[h] = gameCollection;
   //Create user 
   User finalAdd = new User(userName,gameCollection);
   //Store user
   users[h] = finalAdd; 
   }
   //Never forget to close the scanner
   in.close();
  }
  
  
//  public static void main(String[] args) {
//    try {
//    DataCollector d = new DataCollector("Input.txt");
//    d.updateInput();
//    }
//    catch(Exception e) {
//      System.out.println("Exception was thrown");
//     e.printStackTrace();
//    }
//  }
}
