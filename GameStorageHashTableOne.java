// --== CS400 File Header Information ==--
// Name: Sam Hossain
// Email:sdhossain@wisc.edu
// Team: NE
// TA: Daniel
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
//

import java.util.NoSuchElementException;
import java.util.Arrays;

public class GameStorageHashTableOne implements GameStorageADT<String, User> {

	private HashTableMapOne GameStore; //creating instance of HashTableMapOne
	/**
	*Creates new hash table to store games from the HashTableMapOne implementation
	*/
	  public GameStorageHashTableOne(int capacity) {
    GameStore = new HashTableMapOne(capacity);  
    			}

  public GameStorageHashTableOne() {
    GameStore = new HashTableMapOne(10); //no arg will initalize our hashtable to 10
  			}
	@Override
	public boolean addUser(User user){
		return GameStore.put(user.getUsername(), user);
			}
    @Override			
	public User lookup(String username) throws NoSuchElementException{
		return GameStore.get(username);
	}
	@Override
	public int size() {
		return GameStore.size();
	}
	@Override
	public boolean containsKey(String username){
		return GameStore.containsKey(username);
	}
	@Override
	public User remove(String username){
		return GameStore.remove(username);
	}
	@Override
	public void clear(){
		GameStore.clear();
	}
	@Override
	public String[] getGameStats(String username) throws NoSuchElementException{
		Game[] temp = new Game[10];
		temp = GameStore.get(username).getGameList();
		String[] ret = new String[10];

		for (int i = 0; i < temp.length; i++){
			if (temp[i] == null)
				continue;
			ret[i] = temp[i].toString();
		}

		return ret;
	}
	@Override
	public String getGameStats(String username, int gameIndex) throws NoSuchElementException {
		if (gameIndex > 9)
			throw new NoSuchElementException();
		return GameStore.get(username).getGameList()[gameIndex].toString();
	}

}
