import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Commands {

  
  public static void printAll(GameStorageHashTable table, String user) {
     System.out.println(Arrays.toString(table.getGameStats(user)));
  }
  public static void changeTime(GameStorageHashTable table, double newTime, String user, String game) {
    table.getGame(user, game).setTimePlayed(newTime);
  }
  
  public static void changePercentage(GameStorageHashTable table, double newCompletion, String user, String game) {
    if (newCompletion < 0.00 || newCompletion > 100.00) throw new IndexOutOfBoundsException();
    table.getGame(user, game).setCompletion(newCompletion);
   }

  public static void changeScore(GameStorageHashTable table, double newScore, String user, String game) {
     if (newScore < 0.0 || newScore > 5.0) throw new IndexOutOfBoundsException();
     table.getGame(user, game).setPersonalRating(newScore);
   }
  
  
  public static void main(String[] args) {
    GameStorageHashTable table = new GameStorageHashTable(10);
    Scanner scnr = new Scanner(System.in);
    boolean run = true;
    Game[] gameList = new Game[10];
    Scanner fileread = null;
    try {
      File f = new File("GameList.txt");
      fileread = new Scanner(f);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    int i = 0;
    while(fileread.hasNextLine()) {
      gameList[i] = new Game(fileread.nextLine());
      i++;
    }
    System.out.println(Arrays.toString(gameList));
    while(run) {
    System.out.println("Welcome to the Video Game Database, please enter a username");
    User user1 = new User(scnr.nextLine(), gameList);
    table.add(user1);
    System.out.println("Thanks " + user1.getUsername() + ", please input a command");
    System.out.println("Enter p to view all game data \nEnter t to change time played in a game \n"
        + "Enter c to change completion percentage \nEnter s to change personal rating \nEnter u to switch users"
        + "\nEnter r to remove a user \nEnter x to end program");
    switch(scnr.next()){
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
      case "u": break;
      case "r": System.out.println("Enter which user you'd like to remove");
        String removeUser = scnr.next();
        table.remove(removeUser);
        break;
      case "x": run = false;
      break;
    }
   }
    System.out.println("Thank you for using  the video game database");
    scnr.close();
  }

}
