// --== CS400 File Header Information ==--
// Name: Qosai
// Email: Kadadha@wisc.edu
// Team: NE
// TA: Daniel Finer
// Lecturer: Florian Heimerl 
// Notes to Grader: <optional extra notes>
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Commands {

  //prints all game data for a user
  public static void printAll(GameStorageHashTable table, String user) {
     System.out.println(Arrays.toString(table.getGameStats(user)));
  }
  //takes user inputed time and changes time played for game specified
  public static void changeTime(GameStorageHashTable table, double newTime, String user, String game) {
    table.getGame(user, game).setTimePlayed(newTime);
  }
  //takes user inputed percentage of game completed and updates it for time specified
  public static void changePercentage(GameStorageHashTable table, double newCompletion, String user, String game) {
    if (newCompletion < 0.00 || newCompletion > 100.00) throw new IndexOutOfBoundsException();
    table.getGame(user, game).setCompletion(newCompletion);
   }
   //takes user inputed game score and changes it in database for game specified
  public static void changeScore(GameStorageHashTable table, double newScore, String user, String game) {
     if (newScore < 0.0 || newScore > 5.0) throw new IndexOutOfBoundsException();
     table.getGame(user, game).setPersonalRating(newScore);
   }
  
  
  public static void main(String[] args) {
    GameStorageHashTable table = new GameStorageHashTable(10);
    Scanner scnr = new Scanner(System.in);
    boolean run = true;
    DataCollector d = null;
    try {
      d = new DataCollector("Input.txt"); //adds text file to game array 
      d.updateInput();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    //adds users to array
    for (int i = 0; i < d.getUsers().length; i++) {
      table.add(d.getUsers()[i]);
    }
    Game[] emptyGameList = d.emptyStorage();
    System.out.println("Welcome to the Video Game Database, please enter a username");
    User user1 = new User(scnr.nextLine(), emptyGameList);//change later
    table.add(user1);
    while(run) { //while loop that keeps program continuously running until user inputs end command
   
    System.out.println("Thanks " + user1.getUsername() + ", please input a command"); //prints instructions for users
    System.out.println("Enter p to view all game data \nEnter t to change time played in a game \n"
        + "Enter c to change completion percentage \nEnter s to change personal rating \nEnter u to switch users"
        + "\nEnter r to remove a user \nEnter x to end program");
    switch(scnr.next()){        //switch statement runs through all possible commands 
      case "p": printAll(table, user1.getUsername()); 
        break;
      case "t": System.out.println("Enter the new amount of time played");
      double newTime = scnr.nextDouble();
        System.out.println("Enter the name of the game you'd like to change");
        String game = scnr.next();
        changeTime(table, newTime, user1.getUsername(),game);
        break;
      case "c": System.out.println("Enter the new amount of percentage completed");
        double newPercent = scnr.nextDouble();
        System.out.println("Enter the name of the game you'd like to change");
        String game2 = scnr.next();
        changePercentage(table, newPercent, user1.getUsername(),game2);
        break;
      case "s": System.out.println("Enter the new personal score");
        double newScore = scnr.nextDouble();
        System.out.println("Enter the name of the game you'd like to change");
        String game3 = scnr.next();
        changeScore(table, newScore, user1.getUsername(),game3);
        break;
      case "u":
        System.out.println("Enter the username");
        String username = scnr.next();
        user1 = table.lookup(username);
        break;
      case "r": System.out.println("Enter which user you'd like to remove");
        String removeUser = scnr.next();
        table.remove(removeUser);
        break;
      case "x": run = false;
      break;
      default: System.out.println("Please enter a valid command");
    }
   }
    System.out.println("Thank you for using the video game database");
    scnr.close();
  }

}
