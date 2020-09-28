public class User {
private String username;
private Game[] gameList;

// Game list should be a Game array of capacity 10
  public User(String username, Game[] gameList) {
    this.username = username; 
    this.gameList = gameList;
    
  }
  public User(String username) {
    this.username = username;
  }

  public String getUsername() {
    return this.username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public Game[] getGameList() {
    return gameList;
  }
  
}