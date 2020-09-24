# CS400P1 - Video game database
**TEAM: NE TEAM** 
**FLIPGRID:** http://flipgrid.com/finer400ne
**TA:** Daniel **TA EMAIL:** dfiner@wisc.edu
**TEAM EMAILS:** tnazareth@wisc.edu sdhossain@wisc.edu kadadha@wisc.edu probert@wisc.edu mbrudos@wisc.edu lfnguyen@wisc.edu
### Description
This app will be used to store data about specific video games that a person has played or is playing. This will be useful for people to track personal information about the games that they play. This data can also be shared with others.
***
### Data Wranglers: Tricia Nazareth Michael Brudos 

**Application Data:** 
The data being loaded by this program is the video games that a person is playing and the amount of time they spend on each respective game. 

**Data Format:**
We will use objects and arrays to store the games each person plays and the amount of time that they spend on each. We can make a new object for each person and make arrays with the games they play and for how long. 

**Data Wrangler Deliverables and Deadline:**
 Our group has made a group Discord that we communicate with each other on, as well as shared group documents for the project. We also have each other's emails if we need to email any code or documents. 
***

### Back End Developer: Samuel Hossain Lucas Nguyen 

**Data Processing:**

User will create the video game object and then use the preceding methods to add games into the table. The only thing to include in the methods is the name of the game and we will turn the video game name field into a valid hash code. We will implement our own hashcode method or the object hashcode method depending on the project requirements.
Our hashcode function:
Extraction: Put string to lowercase. Split  into an array where each index contains the ASCII value if the corresponding string.
Weighting: subtract 60 then multiple by a 31^i where i = maxIndex, maxIndex -1,... 0
Combine and mod by the table_size
This hash table holds the person’s played video game objects. 

**Front End Interface:**

`public void addGame(Game o);
public Game removeGame(Game o);
public int getSize();
public Game lookup(Game o);
public void clear();`

**Back End Developer Deliverables and Deadline:**
Will uses self documenting code to share the javadocs with other team members. We also have a discord group to ask specific questions about the code
***
### Front End Developer: Qosai Kadadha  

**User Commands:**
The user will be able to create a game object by inputting certain values including hours played, name of the game, console, genre, achievements, completion percentage, and a personal review score. After inputting this information, the user will be able to go back and look at their own data as well as others data that has been shared with them. 


**Error Messages:**
Assigning  a nonexistent game, console, or genre 
Negative hours played, negative review score, or any other negative integer values
Null object or null values within the object 
Invalid sharing addresses or trying to access data that the user does not have permission to see

**Front End Developer Deliverables and Deadline:**
Work on the project will be done on a shared group javadoc, and the discord group will be used to communicate throughout the project.
***
### Test Engineer: Pieran Robert  

**Test Descriptions:**
-Initial test to check that the size of the hashtable is 0
-test the addGame method to make sure that I can create a game, add stats, and that is inserted into the hashtable (this will be proven through size being increased as well as being able to lookup the newly added game and see that it is the same game with the same stats)
-test adding and retrieving games with similar names (ex. Mario Kart vs Mario Party)
-test increasing size over the initial capacity of the array, forcing a new array to be created
-test if removing Games decreases size and then testing for a return of false when the same game previously removed is looked up
-testing if exceptions are thrown when and where they should be
-testing small details in Game class. (completion can’t be over 100% etc)
-creating two games that hash to the same value and seeing if collisions are dealt with

Test Engineer Deliverables and Deadline:
Once program descriptions are written and fields, classes, and methods are named, tests can easily be written. Specific tests will most likely be small in terms of lines of code and these can easily be sent to team members to work through their method debugging and programming. The tests will be written within a few days of the proposal being finalized with names and descriptions.
***

