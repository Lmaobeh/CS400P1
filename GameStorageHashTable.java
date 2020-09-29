// --== CS400 File Header Information ==--
// Name: Lucas Nguyen
// Email:lfnguyen@wisc.edu
// Team: NE
// TA: Daniel
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
//

import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Lucas A class to store the users of the game storage aplications
 *
 */
public class GameStorageHashTable implements GameStorageADT<String, User> {
  private HashTableMap<String, User> hashTable;

  
  private final static int GAME_NUMBER = 10;

  /**
   * Initalizes hash table with a specified capacity
   * 
   * @param capacity the capacity
   */
  public GameStorageHashTable(int capacity) {
    hashTable = new HashTableMap<String, User>(capacity);
  }

  /**
   * Initalizes with a default 10
   */
  public GameStorageHashTable() {
    hashTable = new HashTableMap<String, User>();
  }// with default capacity = 10


  /**
   * @param user Takes a user object to add to this table
   * @return true if the user was successfully added, false if the user already existed
   */
  @Override
  public boolean add(User value) { 
    return hashTable.put(value.getUsername(), value);
  }

  /**
   * looks up a user in the hash table based on their key
   * 
   * @param key the key of the user to look up
   * @return The user with the give key
   * @throws NoSuchElementException if the user is no there
   */
  @Override
  public User lookup(String key) throws NoSuchElementException {
   return hashTable.get(key);
  }

  /**
   * @returns the size
   */
  @Override
  public int size() {
    return hashTable.size();
  }

  /**
   * Looks to see if the corresponding user is in the hash table
   * 
   * @param String key key of user to check
   * @return true if they are, false if otherwise
   */
  @Override
  public boolean containsKey(String key) {
    return hashTable.containsKey(key);
  }

  /**
   * Removes a key value pair from the following hash table
   * 
   * @param Strin key the key of the user to remove
   * @return the user or null if the user wasnt there
   */
  @Override
  public User remove(String key) {
    return hashTable.remove(key);
  }

  /**
   * Clears the hash table
   */
  @Override
  public void clear() {
    hashTable.clear();
  }

  /**
   * @param username Users game stats to get
   * @return a string of game stats for a user
   * @throws NoSuchElementException if the user doenst exist
   */
  public String[] getGameStats(String username) throws NoSuchElementException {
    Game[] gamelist = this.lookup(username).getGameList();
    String[] str = new String[gamelist.length];
    for (int i = 0; i < gamelist.length; i++) {
      if (gamelist[i] == null)
        continue;
      str[i] = gamelist[i].toString();
    }

    return str;
  }

  /**
   * Gets the stats for a specific users game
   * 
   * @param username the name of the user
   * @param gameName the name of the games states to get
   * @return a string of the game object chosen
   * @throws NoSuchElementException if the user doesnt exist
   */
  public String getGameStats(String username, String gameName) throws NoSuchElementException {
    return getGame(username, gameName).toString();
  }

  /**
   * Gets the game object from a user.
   * 
   * @param username the key for the user
   * @param gameName the name of the game
   * @return The game object.
   * @throws NoSuchElementException if the game doesnt exist
   */
  public Game getGame(String username, String gameName) throws NoSuchElementException {
    Game[] gamelist = this.lookup(username).getGameList();
    for (int i = 0; i < gamelist.length; i++) {
      if (gamelist[i] == null)
        continue;
      if (gamelist[i].getName().equalsIgnoreCase(gameName)) {
        return gamelist[i];
      }
    }
    throw new NoSuchElementException();
  }

  public static void main(String[] args) {
    Game[] gl = new Game[10];
    gl[0] = new Game("DOOM", 0.0, 0.0, 0.0);
    gl[1] = new Game("Destiny", 0.0, 0.0, 0.0);
    GameStorageHashTable table = new GameStorageHashTable();
    table.add(new User("Lucas", gl));
    System.out.println(table.size());
    System.out.println(table.containsKey("Lucas"));
    System.out.println(table.remove("Lucas"));
    System.out.println(table.size());
    table.add(new User("kah", null));
    table.add(new User("kako", null));
    table.add(new User("kakoo", null));
    table.add(new User("kakooo", null));
    table.add(new User("kakoooo", null));
    table.add(new User("kakooooo", null));
    table.add(new User("kakoooooo", null));
    table.add(new User("kakooooooo", null));
    
    System.out.println(table.lookup("kakooooo"));
    // System.out.println(table.get("hello"));
    System.out.println(table.remove("kakooooo"));
 
    table.add(new User("Lucas", gl));
    System.out.println(Arrays.toString(table.getGameStats("Lucas")));
    System.out.println(table.getGameStats("Lucas", "DOOM"));
    //System.out.println(table.getGameStats("Lucas", "GameDoesntexist"));

  }

}
