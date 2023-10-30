package mancala;

import java.util.ArrayList;

public class MancalaGame{

    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public MancalaGame() {
        
        board = new Board();
        player1 = new Player();
        player2 = new Player();
        currentPlayer = player1;
    }

    public Board getBoard(){                                           //gets the board for the game
        return board;
    }

    public Player getCurrentPlayer(){                                   //gets the current player
        return currentPlayer;
    }

    public int getNumStones(int pitNum){                                //gets the number of stones in the specific pit
           return board.getNumStones(pitNum);
           
    }   

    public ArrayList<Player> getPlayers(){                              //gets the players for the game
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        return players;
    }

//gets the total no. of stones in a players store
    public int getStoreCount(Player player){                            
        return player.getStoreCount();
    }

    public Player getWinner(){                                          //gets the winner of the game
        int storeCount1 = player1.getStoreCount();
        int storeCount2 = player2.getStoreCount();

        if (storeCount1 > storeCount2) {
            return player1;
        } else if (storeCount2 > storeCount1) {
            return player2;
        } else {
            return null; // It's a tie
        }
    }


    public boolean isValidMove(int startPit, Player player) {
        if (isGameOver()) {
            return false; // Game is already over
        }

        // Check if the selected pit belongs to the current player
        if (player != getCurrentPlayer()) {
            return false; // It's not the player's turn
        }

        // Check if the selected pit is not empty
        if (getBoard().getPits().get(startPit).getStoneCount() == 0) {
            return false; // The selected pit is empty
        }

        return true; // Valid move
    }

    public boolean isGameOver(){                                        //checks if the game is over
        return board.isSideEmpty(0) || board.isSideEmpty(7);
        //return false;
    }

    public int move(int startPit){                                      //makes a move for the current player
        int currentPitIndex; 

        try {
            currentPitIndex = board.moveStones(startPit, currentPlayer);
        } catch (InvalidMoveException e) {
            System.out.println("Invalid move. Try again.");
            currentPitIndex = -1; 
        }
        return currentPitIndex;
    }

    public void setBoard(Board theBoard){                               //sets the board for the game
        board = theBoard;
    }

    public void setCurrentPlayer(Player player){                        //sets the current player
        currentPlayer = player;
    }

    public void setPlayers(Player onePlayer, Player twoPlayer){                       //sets the players for the game
        player1 = onePlayer;
        player2 = twoPlayer;
    }

    public void startNewGame(){                                         //starts a new game by resetting the board
        board.resetBoard();
        currentPlayer = player1;
    }

    public String toString(){                                           //generates a string representation of the game
        return ("o\n");
    }
}
