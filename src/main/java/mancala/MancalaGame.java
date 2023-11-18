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

    public int getNumStones(int pitNum) throws PitNotFoundException{    //gets the number of stones in the specific pit
        if(pitNum < 1 || pitNum > 12){
            throw new PitNotFoundException("Pit not found.");
        }
           return board.getNumStones(pitNum);
           
    }   

    public ArrayList<Player> getPlayers(){                              //gets the players for the game
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        return players;
    }

//gets the total no. of stones in a players store
    public int getStoreCount(Player player) throws NoSuchPlayerException{
        if(player != player1 || player != player2){
            throw new NoSuchPlayerException("no such player.");
        }                            
        return player.getStoreCount();
    }

    public Player getWinner() throws GameNotOverException{              //gets the winner of the game
        if(!isGameOver()){
            throw new GameNotOverException("Game is not over.");
        }
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


    public boolean isGameOver(){                                        //checks if the game is over
        boolean isGameOver = false;
        try{
            isGameOver = board.isSideEmpty(0) || board.isSideEmpty(7);
        }catch(PitNotFoundException e){
            System.out.println("Pit not found.");
        }
        return isGameOver;
    }

    public int move(int startPit) throws InvalidMoveException{          //makes a move for the current player
        if(startPit < 1 || startPit > 12){
            throw new InvalidMoveException("Invalid move.");
        }
        int currentPitIndex; 
        int stonesInPits = 0;
        Player player = currentPlayer;
        ArrayList<Pit> pits = board.getPits();
        try {
            int stoneCountBeforeMove = pits.get(startPit).getStoneCount();
            board.moveStones(startPit, currentPlayer);
            currentPitIndex = (startPit - 1) + stoneCountBeforeMove % 12;
            if (currentPitIndex == 6 || currentPitIndex == 0) {
            currentPlayer = (currentPlayer == player1) ? player1 : player2; // dont Change the current player
            } else{
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        } catch (InvalidMoveException e) {
            System.out.println("Invalid move. Try again.");
             
        }
        if (currentPlayer == player1){
            for (int i = 0; i < 6; i++){
                stonesInPits += pits.get(i).getStoneCount();
            }
        }else if(currentPlayer == player2){
            for(int i = 6; i < 12; i++){
                stonesInPits += pits.get(i).getStoneCount();
            }
        }
       
            if(isGameOver()){//put leftover stones in store if game over
                for (int i = 0; i < 12; i++) {
                    int pitStoneCount =  pits.get(i).getStoneCount();
                    if (pitStoneCount > 0) {
                        if (i < 6) {
                            player1.getStore().addStones(pitStoneCount);
                            stonesInPits = 0;
                        } else {
                        player2.getStore().addStones(pitStoneCount);
                        stonesInPits = 0;
                        }
                    }
                }
            }
      
        return stonesInPits; //return the total number of stones remaining in the players side pits
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
        //return ("o\n");
        return "Mancala Game - Current Player: " + currentPlayer;
    }
}
