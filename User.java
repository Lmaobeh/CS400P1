// --== CS400 File Header Information ==--
// Name: <Michael Brudos>
// Email: <mbrudos@wisc.edu>
// Team: <NE>
// Role: <Data Wrangler 2>
// TA: <Daniel>
// Lecturer: <Gary>
// Notes to Grader: <optional extra notes>
/**
 * @author Michael B
 * Implements a User that has a collection of games to be used in the Hash table
 */
public class User {
private String username;
private Game[] gameList;

// Game list should be a Game array of capacity 10
  /** Creates a new User with a name and collection of games
   * @param username - name of user
   * @param gameList - user's collection of games
   */
  public User(String username, Game[] gameList) {
    this.username = username;
    this.gameList = gameList;
  }

  /** Returns the username of the user
   * @return username 
   */
  public String getUsernmae() {
    return this.username;
  }
  
  /** Changes the username of the User
   * @param username - new username 
   */
  public void setUsername(String username) {
    this.username = username;
  }
  
  /** Returns the User's collection of games
   * @return gameList - User's collection of games
   */
  public Game[] getGameList() {
    return gameList;
  }
  
}
