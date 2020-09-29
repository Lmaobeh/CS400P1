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

public class GameStorageHashTable implements GameStorageADT<String, User> {
  private LinkedList<User>[] hashTable;
  private int capacity;
  private int size;
  private final static double LOAD_THRESHOLD = .8;
  private final static int GAME_NUMBER=10;

  public GameStorageHashTable(int capacity) {
    this.capacity = capacity;
    hashTable = (LinkedList<User>[]) new LinkedList[this.capacity];
    this.size = 0;
  }

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

  private int hashFunction(String key) {
    return (key.hashCode() & 0x7fffffff) % capacity;
  }

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

  @Override
  public boolean add(User value) {
    String key = value.getUsername();
    if (this.containsKey(key))
      return false;
    if (hashTable[hashFunction(key)] != null) {
      hashTable[hashFunction(key)].add(value);
    }
    else {
      hashTable[hashFunction(key)] = new LinkedList<User>();
      hashTable[hashFunction(key)].add(value);
    }
    size++;
    if (this.checkLoadFactor())
      this.resizeTable();
    return true;
  }

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

  @Override
  public int size() {
    return size;
  }

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

  @Override
  public User remove(String key) {
    if (this.containsKey(key)) {
      for (User node : hashTable[hashFunction(key)]) {
        if (node.getUsername().equals(key)) {
          size--;
          hashTable[hashFunction(key)].remove(node);
          if(hashTable[hashFunction(key)].size() ==0) {
            hashTable[hashFunction(key)]= null;
          }
          return node;
        }
      }
    }
    return null;
  }

  @Override
  public void clear() {
    hashTable = (LinkedList<User>[]) new LinkedList[this.capacity];
    size = 0;
  } 
  
  public String[] getGameStats(String username) throws NoSuchElementException {
    Game[] gamelist = this.lookup(username).getGameList();
    String[] str = new String[gamelist.length];
    for (int i = 0; i < gamelist.length; i++) {
     if(gamelist[i]== null) continue;
     str[i] = gamelist[i].toString();
    }
   
    return str;
  }
  
  public String getGameStats(String username, String gameName) throws NoSuchElementException {
    return getGame(username, gameName).toString();
  }
  
  public Game getGame(String username, String gameName) throws NoSuchElementException{
    Game[] gamelist = this.lookup(username).getGameList();
    for (int i = 0; i < gamelist.length; i++) {
      if (gamelist[i]==null ) continue;
      if (gamelist[i].getName().equalsIgnoreCase(gameName)) {
        return gamelist[i];
      }
    }
    throw new NoSuchElementException();
  }

  public static void main(String[] args) {
    Game[] gl = new Game[10];
    gl[0] = new Game("DOOM", 0.0, 0.0, 0.0);
    gl[1] = new Game("Destiny", 0.0,0.0, 0.0);
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
    //System.out.println(table.get("hello"));
    System.out.println(table.remove("kakooooo"));
    System.out.println(table.size);
    table.add(new User("Lucas", gl));
    System.out.println(Arrays.toString(table.getGameStats("Lucas")));
    System.out.println(table.getGameStats("Lucas", "DOOM"));
    System.out.println(table.getGameStats("Lucas", "GameDoesntexist"));
    
  }

}
