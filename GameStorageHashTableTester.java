// --== CS400 File Header Information ==--
// Name: Pieran Robert
// Email: probert@wisc.edu
// Team: NE
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
public class GameStorageHashTableTester extends Commands {

  public static void main(String[] args) {
    System.out.println("test1: " + test1());
    System.out.println("test2: " + test2());
    System.out.println("test3: " + test3());
    System.out.println("test4: " + test4());
    System.out.println("test5: " + test5());
    System.out.println("test6: " + test6());
  }

  /**
   * Tests if empty game objects return any stats or a relevant message
   */
  public static boolean test1() {
    GameStorageHashTable table1 = new GameStorageHashTable(6);
    table1.add(new User("user1", new Game[10]));
    if (table1.size() != 1)
      return false;
    try {
      System.out.println(table1.getGameStats("user1", "Skyrim"));
    } catch (Exception E) {
      return true;
    }
    return false;
  }

  /**
   * Tests creation of a small hash Table tests lookup, addUser, game creation methods
   */
  public static boolean test2() {
    GameStorageHashTable table2 = new GameStorageHashTable(6);
    table2.add(new User("user2", new Game[10]));
    Game game1 = new Game("game1", 0, 0, 0);
    table2.lookup("user2").getGameList()[0] = game1;
    try {
      System.out.println(table2.getGameStats("user1", "Skyrim"));
    } catch (Exception E) {
      return true;
    }
    return false;
  }

  /**
   * Tests to see if collisions are handled appropriately
   */
  public static boolean test3() {
    int hash1 = "user1".hashCode() & 0x7fffffff % 10;
    int hash2 = "user14".hashCode() & 0x7fffffff % 10;
    if (hash1 != hash2)
      return false;
    GameStorageHashTable table3 = new GameStorageHashTable(10);
    table3.add(new User("user1", new Game[10]));
    table3.add(new User("user14", new Game[10]));
    if (table3.size() != 2)
      return false;
    Game game1 = new Game("game1", 1, 2, 3);
    table3.lookup("user14").getGameList()[0] = game1;
    if (table3.lookup("user14").getGameList()[0].getTimePlayed() != 1)
      return false;
    return true;
  }

  /**
   * tests the addUser method with the a duplicate key
   */
  public static boolean test4() {
    GameStorageHashTable table4 = new GameStorageHashTable(10);
    table4.add(new User("user1", new Game[10]));
    try {
      table4.add(new User("user1", new Game[10]));
    } catch (Exception E) {
      return true;
    }
    if (table4.size() == 1)
      return true;

    return false;
  }

  /**
   * tests remove method and removing a key that does not exist
   */
  public static boolean test5() {
    GameStorageHashTable table5 = new GameStorageHashTable(10);
    table5.add(new User("user1", new Game[10]));
    table5.remove("user1");
    if (table5.size() != 0)
      return false;
    try {
      table5.remove("user1");
    } catch (Exception E) {
      return true;
    }
    if (table5.size() == 0)
      return true;

    return false;
  }

  /**
   * Tests general game management methods tests to see if game objects are realistic
   */
  public static boolean test6() {
    GameStorageHashTable table6 = new GameStorageHashTable(10);
    table6.add(new User("user1", new Game[10]));
    Game game1 = new Game("game1", 0, 0, 0);
    table6.lookup("user1").getGameList()[0] = game1;
    try {
      game1.setCompletion(200);
      System.out.println("1");
      return false;
    } catch (IndexOutOfBoundsException e) {

    }
    try {
      game1.setPersonalRating(200);
      System.out.println("2");
      return false;
    } catch (IndexOutOfBoundsException e) {

    }
    // game1.setTimePlayed(2147483647);
    Game game2 = new Game("game2", 0, 0, 0);
    table6.lookup("user1").getGameList()[1] = game2;
    try {
      game2.setCompletion(-1);
      System.out.println("3");
      return false;
    } catch (IndexOutOfBoundsException e) {
    }
    try {
      game2.setPersonalRating(-1);
      System.out.println("4");
      return false;
    } catch (IndexOutOfBoundsException e) {
    }
    try {
      game2.setTimePlayed(-1);
      System.out.println("5");
      return false;
    } catch (IndexOutOfBoundsException e) {
    }

    return true;


  }

}
