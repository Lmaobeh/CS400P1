import java.util.Arrays;
import java.util.Scanner; 
public class Commands {

  
  public static void printAll(GameStorageHashTable table, String key) {
     System.out.println(Arrays.toString(table.getGameStats(key)));
  }
  public static void changeTime(GameStorageHashTable table, double newTime,String game) {
    
  }
  
  public static void changePercentage(double newCompletion, String game) {
    if (newCompletion < 0.00 || newCompletion > 100.00) throw new IndexOutOfBoundsException();
   }

  public static void changeScore(double newScore, String game) {
     if (newScore < 0.0 || newScore > 5.0) throw new IndexOutOfBoundsException();
   }
  
  public static void main(String[] args) {
    GameStorageHashTable table = new GameStorageHashTable(10);
    Scanner scnr = new Scanner(System.in);
    boolean run = true;
    while(run) {
    System.out.println("Welcome to the Video Game Database, please enter a username");
    User user1 = new User(scnr.nextLine());
    table.addUser(user1);
    System.out.println("Thanks " + user1.getUsername() + ", please input a command");
    System.out.println("Enter p to view all game data \nEnter t to change time played in a game \n"
        + "Enter c to change completion percentage \nEnter s to change personal rating \nEnter u to switch users"
        + "\nEnter r to remove a user \nEnter x to end program");
    switch(scnr.next()){
      case "p": printAll(table, user1.getUsername());;
      case "t": System.out.println("Enter the new amount of time played");
      int newTime = scnr.nextInt();
        System.out.println("Enter the name of the game you'd like to change");
        String game = scnr.next();
        changeTime(table, newTime,game);
      case "c": System.out.println("Enter the new amount of percentage completed");
        int newPercent = scnr.nextInt();
        System.out.println("Enter the name of the game you'd like to change");
        String game2 = scnr.next();
        changePercentage(newPercent,game2);
      case "s": System.out.println("Enter the new personal score");
        int newScore = scnr.nextInt();
        System.out.println("Enter the name of the game you'd like to change");
        String game3 = scnr.next();
        changeScore(newScore, game3);
      case "u": break;
      case "r": System.out.println("Enter which user you'd like to remove");
        String removeUser = scnr.next();
        table.remove(removeUser);
      case "x": run = false;
      break;
    }
   }
    System.out.println("Thank you for using  the video game database");
    scnr.close();
  }

}
