
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
public Game(String name) {
  this.name = name;
  this.timePlayed = 0.0;
  this.completion = 0.0;
  this.personalRating = 0.0;
}

public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public void setTimePlayed(double timePlayed) {
  if (timePlayed < 0.0) throw new IndexOutOfBoundsException();
  this.timePlayed = timePlayed;
}

public void setCompletion(double completion) {
  if (completion < 0 || completion > 100) throw new IndexOutOfBoundsException();
  this.completion = completion;
}

public void setPersonalRating(double personalRating) {
  if(personalRating < 0.0 || personalRating > 5.0) throw new IndexOutOfBoundsException();
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
  str += "\t Completion " + String.format("%5.2f", completion*100.0) + "%\n";
  str += "\t Personal Rating: "+ personalRating+ "\n";
  return str;
}
  
}
