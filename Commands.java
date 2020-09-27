import java.util.Scanner; 
public class Commands {

  
  public static void printAll() {
    
  }
  public static void changeTime(int newTime,String game) {
    
   }
  public static void changePercentage(int newCompletion, String game) {
    
   }

  public static void changeScore(int newScore, String game) {
    
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
    System.out.println("Enter p to view all game data /n Enter t to change time played in a game /n"
        + "Enter c to change completion percentage /n Enter s to change personal rating /n Enter u to switch users"
        + "/n Enter r to remove a user /n Enter x to end program");
    switch(scnr.next()){
      case "p": printAll();
      case "t": System.out.println("Enter the new amount of time played");
      int newTime = scnr.nextInt();
        System.out.println("Enter the name of the game you'd like to change");
        String game = scnr.next();
        changeTime(newTime,game);
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
