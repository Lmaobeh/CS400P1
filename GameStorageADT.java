import java.util.NoSuchElementException;

public interface GameStorageADT<KeyType, ValueType> {

	public boolean addUser(ValueType value);
	public ValueType lookup(KeyType key) throws NoSuchElementException;
	public int size();
	public boolean containsKey(KeyType key);
	public ValueType remove(KeyType key);
	public void clear();
	public String[] getGameStats(String userName) throws NoSuchElementException;
	public String getGameStats(String userName, int gameIndex) throws NoSuchElementException; 

	
}
