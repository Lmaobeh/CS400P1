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
 *  Implements a Game to be used / collected by a User
 */
public class Game{
private String name;
private double timePlayed;
private double completion;
private double personalRating;

/** Creates a new Game 
 * @param name - name of the game 
 * @param timePlayed - time played in the game
 * @param completion - The  current progress amount in game
 * @param personalRating - The users rating on the game
 */
public Game(String name, double timePlayed, double completion, double personalRating) {
  this.name = name;
  this.timePlayed = timePlayed;
  this.completion = completion;
  this.personalRating = personalRating;
}
/** Creates a game with no game stats
 * @param name - name of the game
 */
public Game(String name) {
  this.name = name;
  this.timePlayed = 0.0;
  this.completion = 0.0;
  this.personalRating = 0.0;
}

/** Returns the name of the game
 * @return The name of the game - name
 */
public String getName() {
  return name;
}

/** Changes the name of the game
 * @param name - new name for game
 */
public void setName(String name) {
  this.name = name;
}

/** Changes the time played in the game
 * @param timePlayed - new total time spent in game
 */
public void setTimePlayed(double timePlayed) {
  this.timePlayed = timePlayed;
}

/** Changes the completion amount in a game
 * @param completion - current completion
 */
public void setCompletion(double completion) {
  this.completion = completion;
}

/** Changes the personal Rating of the game
 * @param personalRating - the new rating of the game
 */
public void setPersonalRating(double personalRating) {
  this.personalRating = personalRating;
}

/** Returns the time played in a game
 * @return - time played in a game
 */
public double getTimePlayed() {
  return timePlayed;
}

/** Returns the completion of the game
 * @return - the completion of the game
 */
public double getCompletion() {
   return completion;
}

/** Returns the personal rating of the game
 * @return - personal rating of the game
 */
public double getPersonalRating() {
    return personalRating;
}
/** Returns a string representation of the game 
 * @Override 
 */
public String toString() {
  String str = "Game Name: " + name +"\n";
  str += "\t Time Played: " +timePlayed + "\n";
  str += "\t Completion " + timePlayed+ "%\n";
  str += "\t Personal Rating: "+ personalRating+ "\n";
  return str;
}
  
}
