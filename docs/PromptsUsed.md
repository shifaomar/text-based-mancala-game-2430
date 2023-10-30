## Prompts used:

# Prompt 1:
can you make a a text based version of the game mancala?
these are the rules of the game(game logic):

What You Need:
Mancala board

48 markers

Setup

The Mancala 'board' is made up of two rows of six holes, or pits, each. If you don't have a Mancala board handy, an empty egg carton can work. Next, four pieces -- marbles or stones -- are placed in each of the 12 holes. The color of the pieces is irrelevant.

Each player has a 'store' to the right side of the Mancala board. (Cereal bowls work well for this purpose.) 

Play
 
The game begins with one player picking up all of the pieces in any one of the holes on his side.Moving counter-clockwise, the player deposits one of the stones in each hole until the stones run out.
 
1. If you run into your own store, deposit one piece in it. If you run into your opponent's store, skip it.

2. If the last piece you drop is in your own store, you get a free turn.

3. If the last piece you drop is in an empty hole on your side, you capture that piece and any pieces in the hole directly opposite.

4. Always place all captured pieces in your store.

Winning the game

The game ends when all six spaces on one side of the Mancala board are empty. The player who still has pieces on his side of the board when the game ends captures all of those pieces. Count all the pieces in each store. The winner is the player with the most pieces.

there are 2 packages in this program, called mancala and ui respectively. the mancala package contains the MancalaGame class, Board class, Player class, Pit class, and Store class. it also contains GameNotOverException class, InvalidMoveException class, NoSuchPlayerException class, and the PitNotFoundException class. the ui package contains the TextUI class which has the main method. the required methods for each class in the mancala package are given below.

Class mancala game
Constructor   
mancalaGame()         initializes a new mancala game
Method summary 
Modifier and type         method                                                   description
Board                                 getBoard()                                             gets the board for the game
Player                                 getCurrentPlayer()                            gets the current player
int                                         getNumStones(int pitNum)          gets the number of stones in the specific pit
ArrayList<Player>        getPlayers()                                          gets the players for the game
int                                         getStoreCount(Player player)      gets the total no. of stones in a players store
Player                                 getWinner()                                           gets the winner of the game
boolean                             isGameOver()                                       checks if the game is over
int                                         move(int StartPit)                               makes a move for the current player
void                                     setBoard(Board theBoard)             sets the board for the game
void                                     setCurrentPlayer(Player player)   sets the current player
void                                     setPlayers(Player p1, Player p2)    sets the players for the game
void                                     startNewGame()                                  starts a new game by resetting the board
String                                 toString()                                                 generates a string representation of the game

Class Board
Constructor  
Board()                initializes a new mancala board with pits and stores
Method summary 
Modifier and type         method                                                           description
int                                         captureStones(int stoppingPoint)     captures stones fromthe opponents pits
int                                        distributeStones(int startingPoint)    helper method that distributes stones into pits and stores, skipping the opponents store
int                                        getNumStones(int pitNum)                  gets the number of stones in a specific pit          
ArrayList<Pit>              getPits()                                                         returns the list of pits in the board, not including the stores
ArrayList<Store>         getStores()                                                   returns the list of stores in the board
void                                    initializeBoard()                                         initializes the board by distributing stones
boolean                           isSideEmpty(int pitNum)                       indicates whether one side of the board is empty
int                                       moveStones(int startPit  Player player) moves stones for the player starting from a specific pit
void                                 registerPlayers(Player one, Player two)  connects players to their stores
void                                  resetBoard()                                                  resets the board by redistrbtuing the stones but retains the players
void                                 setUpPits()                                                    establishes 12 empty pits in the board
void                                 setUpStores()                                              establishes 2 empty stores in the board
String                              toString()

class Pit
constructor
pit()           initializes a new pit
Method summary 
Modifier and type         method                                                           description
void                                     addStone()                                                    adds a stone to the pit
int                                         getStoneCount()                                     gets the number of stones in the pit
int                                        removeStones()                                          removes and returns the stones from the pit
String                                toString()

Class Store
constructor
Store()                          initializes a new store
Method summary 
Modifier and type         method                                                           description
void                                     addStones(int amount)                           adds stones to the store
int                                       emptyStore()                                                empties the store and returns the number of stones that were in it
Player                                getOwner()                                                    gets the owner of the store
int                                        getTotalStones()                                      gets the total number of stones in the store
void                                    setOwner(Player player)                       sets the owner of the store
String                                toString

Class Player
constructor 
Player()                                    initializes a new player
Player(String name)          initializes a new player with a name

Method summary 
Modifier and type         method                                          description
String                                 getName()                                    gets the name of the player
Store                                  getStore()                                     gets the players store when they collect stones
int                                        getStoreCount()                         gets the count of the number of stones in the players store when they collect stones
void                                    setName(String name)          sets the players name
void                                    setStore(Store store)               sets the players store
String                                 toString()

step 1: write the code for all the methods for the Pit class, using the game logic
step 2: write the code for all the methods for the Store class
step 3: write the code for all the methods for the Player class
step 4: write the code for all the methods for the Board class
step 5: write the code for all the methods for the MancalaGame class
step 6: write the code for the TextUI class in the ui package

write the full code so that the code will compile and run. Do all these step by step.

# Prompt 2:
do steps 4,5, and 6 again. write the full code so that it will build and run like a text-based version of the game

# Prompt 3:
 gradle build

> Task :compileJava FAILED
/course/coursework/A2Starter/src/main/java/mancala/Board.java:161: error: cannot find symbol
    private ArrayList<Pit> pits;
                      ^
  symbol:   class Pit
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:162: error: cannot find symbol
    private ArrayList<Store> stores;
                      ^
  symbol:   class Store
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:163: error: cannot find symbol
    private Player playerOne;
            ^
  symbol:   class Player
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:164: error: cannot find symbol
    private Player playerTwo;
            ^
  symbol:   class Player
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:188: error: cannot find symbol
    public ArrayList<Pit> getPits() 
                     ^
  symbol:   class Pit
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:192: error: cannot find symbol
    public ArrayList<Store> getStores() 
                     ^
  symbol:   class Store
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:207: error: cannot find symbol
    public int moveStones(int startPit, Player player) 
                                        ^
  symbol:   class Player
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:212: error: cannot find symbol
    public void registerPlayers(Player one, Player two) 
                                ^
  symbol:   class Player
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:212: error: cannot find symbol
    public void registerPlayers(Player one, Player two) 
                                            ^
  symbol:   class Player
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/MancalaGame.java:92: error: cannot find symbol
    private Board board;
            ^
  symbol:   class Board
  location: class MancalaGame
/course/coursework/A2Starter/src/main/java/mancala/MancalaGame.java:105: error: cannot find symbol
    public Board getBoard() 
           ^
  symbol:   class Board
  location: class MancalaGame
/course/coursework/A2Starter/src/main/java/mancala/MancalaGame.java:138: error: cannot find symbol
    public void setBoard(Board theBoard) 
                         ^
  symbol:   class Board
  location: class MancalaGame
/course/coursework/A2Starter/src/main/java/mancala/Board.java:169: error: cannot find symbol
        playerOne = new Player("Player 1");
                        ^
  symbol:   class Player
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:170: error: cannot find symbol
        playerTwo = new Player("Player 2");
                        ^
  symbol:   class Player
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/Board.java:223: error: cannot find symbol
            pits.add(new Pit());
                         ^
  symbol:   class Pit
  location: class Board
/course/coursework/A2Starter/src/main/java/mancala/MancalaGame.java:99: error: cannot find symbol
        board = new Board();
                    ^
  symbol:   class Board
  location: class MancalaGame
16 errors

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileJava'.
> Compilation failed; see the compiler error output for details.


fix these.

# Prompt 4:
User
/course/coursework/A2Starter/src/main/java/ui/TextUI.java:114: error: class, interface, enum, or record expected
package ui;
^
1 error
fix this

# Prompt 5:
> Task :compileJava
/course/coursework/A2Starter/src/main/java/ui/TextUI.java:142: error: exception InvalidMoveException is never thrown in body of corresponding try statement
             catch (InvalidMoveException e) 
              ^
1 error

what about this

# Prompt 6
> Task :compileJava
/course/coursework/A2Starter/src/main/java/ui/TextUI.java:141: error: cannot find symbol
                 game.move(pitNumber);
                           ^
  symbol:   variable pitNumber
  location: class TextUI
1 error

this?

# Prompt 7:
try {
                
                 game.move(pitNumber);
            } catch (InvalidMoveException e) {
                System.out.println("Invalid move. Try again.");
            }
fix this part of the code

# Prompt 8:
isValidMove
mke this method for me also. 

# Prompt 9:
 Task :compileJava
/course/coursework/A2Starter/src/main/java/mancala/MancalaGame.java:142: error: cannot find symbol
    return capturedStones;
           ^
  symbol:   variable capturedStones
  location: class MancalaGame 
fix this

