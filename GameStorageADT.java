import java.util.NoSuchElementException;

/**
 * @author Lucas
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public interface GameStorageADT<KeyType,ValueType>{

    /**
     * Adds a value (with a key field) into the hash table.
     * @param value the value to add
     * @return returns true if added and false if otherwise
     */
    public boolean add(ValueType value);
    /**
     * Searches the hash table for the given key for its corresponding value
     * @param key the key to lookup
     * @return the value of the key value pair
     * @throws NoSuchElementException if the key was not found
     */
    public ValueType lookup(KeyType key) throws NoSuchElementException;
    /**
     * returns size of table
     * @return the size of table
     */
    public int size();
    /**
     * Looks to see if the hash table contains a given key value pair
     * @param key the key
     * @return true if it does and false if otherwise
     */
    public boolean containsKey(KeyType key);
    /**
     * Removes the given key value pair form the hash table
     * @param key the key
     * @return the value that was removed
     */
    public ValueType remove(KeyType key);
    /**
     * Clears the hash table
     */
    public void clear();
	/**
	 * Gets the game stats for a user
	 * @param userName the user to get game stats for
	 * @return the string of game stats
	 * @throws NoSuchElementException if the user was not found
	 */
	public String[] getGameStats(String userName) throws NoSuchElementException;
	/**
	 * Returns a string of the game stats for a given user
	 * @param userName the user game stats
	 * @param gameName the game to get
	 * @return a string of the game stats
	 * @throws NoSuchElementException if the user or game doesnt exist
	 */
	public String getGameStats(String userName, String gameName) throws NoSuchElementException; 
	/**
	   * Gets the game object from a user.
	   * @param username the key for the user
	   * @param gameName the name of the game
	   * @return The game object.
	   * @throws NoSuchElementException if the game doesnt exist
	 */
	public Game getGame(String userName, String gameName) throws NoSuchElementException;
 	
}
