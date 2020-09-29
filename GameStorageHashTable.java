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
  private LinkedList<User>[] hashTable;
  private int capacity;
  private int size;
  private final static double LOAD_THRESHOLD = .8;
  private final static int GAME_NUMBER = 10;

  /**
   * Initalizes hash table with a specified capacity
   * 
   * @param capacity the capacity
   */
  public GameStorageHashTable(int capacity) {
    this.capacity = capacity;
    hashTable = (LinkedList<User>[]) new LinkedList[this.capacity];
    this.size = 0;
  }

  /**
   * Initalizes with a default 10
   */
  public GameStorageHashTable() {
    this.capacity = 10;
    hashTable = (LinkedList<User>[]) new LinkedList[this.capacity];
    this.size = 0;
  }// with default capacity = 10

  /**
   * Checks if the load factor is greater than or equal to 80%
   * 
   * @return true if it is greater, false if it is not.
   */
  private boolean checkLoadFactor() {
    return (double) size / (double) capacity >= LOAD_THRESHOLD;
  }

  /**
   * Computes a hash index from a given key
   * 
   * @param key the key
   * @return the hash index returned
   */
  private int hashFunction(String key) {
    return (key.hashCode() & 0x7fffffff) % capacity;
  }

  /**
   * Preforms a resize operation on the hash table, doubling the capacity
   */
  private void resizeTable() {
    LinkedList<User>[] temp = hashTable;
    hashTable = (LinkedList<User>[]) new LinkedList[capacity *= 2];
    size = 0;
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == null)
        continue;
      for (User o : temp[i]) {
        this.add(o);
      }
    }

  }

  /**
   * @param user Takes a user object to add to this table
   * @return true if the user was successfully added, false if the user already existed
   */
  @Override
  public boolean add(User value) {
    String key = value.getUsername();
    if (this.containsKey(key))
      return false;
    if (hashTable[hashFunction(key)] != null) {
      hashTable[hashFunction(key)].add(value);
    } else {
      hashTable[hashFunction(key)] = new LinkedList<User>();
      hashTable[hashFunction(key)].add(value);
    }
    size++;
    if (this.checkLoadFactor())
      this.resizeTable();
    return true;
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
    if (hashTable[hashFunction(key)] == null) {
      throw new NoSuchElementException();
    }
    for (User i : hashTable[hashFunction(key)]) {
      if (i.getUsername().equals(key)) {
        return i;
      }
    }
    throw new NoSuchElementException();
  }

  /**
   * @returns the size
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Looks to see if the corresponding user is in the hash table
   * 
   * @param String key key of user to check
   * @return true if they are, false if otherwise
   */
  @Override
  public boolean containsKey(String key) {
    if (hashTable[hashFunction(key)] == null) {
      return false;
    }
    for (User i : hashTable[hashFunction(key)]) {
      if (i.getUsername().equals(key)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Removes a key value pair from the following hash table
   * 
   * @param Strin key the key of the user to remove
   * @return the user or null if the user wasnt there
   */
  @Override
  public User remove(String key) {
    if (this.containsKey(key)) {
      for (User node : hashTable[hashFunction(key)]) {
        if (node.getUsername().equals(key)) {
          size--;
          hashTable[hashFunction(key)].remove(node);
          if (hashTable[hashFunction(key)].size() == 0) {
            hashTable[hashFunction(key)] = null;
          }
          return node;
        }
      }
    }
    return null;
  }

  /**
   * Clears the hash table
   */
  @Override
  public void clear() {
    hashTable = (LinkedList<User>[]) new LinkedList[this.capacity];
    size = 0;
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
    System.out.println(table.capacity);
    System.out.println(table.lookup("kakooooo"));
    // System.out.println(table.get("hello"));
    System.out.println(table.remove("kakooooo"));
    System.out.println(table.size);
    table.add(new User("Lucas", gl));
    System.out.println(Arrays.toString(table.getGameStats("Lucas")));
    System.out.println(table.getGameStats("Lucas", "DOOM"));
    System.out.println(table.getGameStats("Lucas", "GameDoesntexist"));

  }

}
