
public class Game{
private String name;
private double timePlayed;
private double completion;
private double personalRating;

public Game(String name, double timePlayed, double completion, double personalRating) {
  this.name = name;
  this.timePlayed = timePlayed;
  this.completion = completion;
  this.personalRating = personalRating;
}

public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public void setTimePlayed(double timePlayed) {
  this.timePlayed = timePlayed;
}

public void setCompletion(double completion) {
  this.completion = completion;
}

public void setPersonalRating(double personalRating) {
  this.personalRating = personalRating;
}

public double getTimePlayed() {
  return timePlayed;
}

public double getCompletion() {
   return completion;
}

public double getPersonalRating() {
    return personalRating;
}
public String toString() {
  String str = "Game Name: " + name +"\n";
  str += "\t Time Played: " +timePlayed + "\n";
  str += "\t Completion " + timePlayed+ "%\n";
  str += "\t Personal Rating: "+ personalRating+ "\n";
  return str;
}
  
}
