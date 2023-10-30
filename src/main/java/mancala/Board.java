package mancala;

import java.util.ArrayList;
//import java.util.List;

public class Board{

    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private MancalaGame game;

    public Board(){
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        //this.game = game;
        initializeBoard();

        for (int i = 0; i < 12; i++) {
            pits.add(new Pit());
        }
        for (int i = 0; i < 2; i++) {
            stores.add(new Store());
        }
        
    }

    public void setGame(MancalaGame game) {
        this.game = game;
    }

    public int captureStones(int stoppingPoint){           //captures stones from the opponents pits
    //complete to check if it is on current players side
        if (pits.get(stoppingPoint).getStoneCount() == 1) {
            int oppositePitIndex = pits.size() - 1 - stoppingPoint;         
            int capturedStones = pits.get(stoppingPoint).removeStones(); 
            capturedStones += pits.get(oppositePitIndex).removeStones(); 

            // Placing the captured stones in the player's store
            game.getCurrentPlayer().getStore().addStones(capturedStones);
            
            return capturedStones;
        }
        return 0;
    }


//helper method that distributes stones into pits and stores, skipping the opponents store
    public int distributeStones(int startingPoint){      
          int remainingStones = pits.get(startingPoint).removeStones();
        int currentPitIndex = startingPoint;
        while (remainingStones > 0) {
            currentPitIndex = (currentPitIndex + 1) % 14; // The board has 14 pits
            if (currentPitIndex != 13) {
                pits.get(currentPitIndex).addStone();
                remainingStones--;
            }
        }
        return currentPitIndex;
    }

    public int getNumStones(int pitNum){                        // gets the number of stones in a specific pit          
        return pits.get(pitNum).getStoneCount();
    }
    

    //Returns the list of pits in the board, not including the stores
    public ArrayList<Pit> getPits() {
        return pits;
    }

    public ArrayList<Store> getStores(){                        //returns the list of stores in the board
        return stores;
    }

    public void initializeBoard(){                              //initializes the board by distributing stones
        setUpPits();
        setUpStores();
    
        for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 4; j++) {                   //adding 4 stones to each pit
                    pits.get(i).addStone();
                }
        }
    }

    
    public boolean isSideEmpty(int pitNum){                     //indicates whether one side of the board is empty
        int startingPit = pitNum <= 6 ? 0 : 7;
        int endingPit = pitNum <= 6 ? 6 : 13;
        for (int i = startingPit; i <= endingPit; i++) {
            if (getNumStones(i) > 0) {
                return false;
            }
        }
        return true;
    }

    //moves stones for the player starting from a specific pit
    public int moveStones(int startPit, Player player) throws InvalidMoveException {
        if (!game.isValidMove(startPit, player)) {
            throw new InvalidMoveException("Invalid move. Try again.");
        }

        int currentPitIndex = distributeStones(startPit);

        if (currentPitIndex == player.getStoreIndex()) {
            game.setCurrentPlayer(player);
        }

        // Checking if the game is over after distributing stones
        if (game.isGameOver()) {
            for (int i = 0; i < 14; i++) {
                int pitStoneCount = game.getNumStones(i);
                if (pitStoneCount > 0) {
                player.getStore().addStones(pitStoneCount);
                }
            }
        }

        return currentPitIndex;
    }


    public void registerPlayers(Player one, Player two){        //connects players to their stores
        one.setStore(stores.get(6));
        two.setStore(stores.get(13));
    }


//resets the board by redistrbtuing the stones but retains the players
    public void resetBoard(){     
        for (int i = 0; i < 14; i++) {
            pits.get(i).removeStones();
        }
        initializeBoard();                                    
    
    }

    public void setUpPits(){                                    //establishes 12 empty pits in the board
        for (int i = 0; i < 12; i++) {
                pits.add(new Pit());
        }
    }

    public void setUpStores(){                                  //establishes 2 empty stores in the board
        
        stores.add(new Store());
        stores.add(new Store());
    }
    public String toString(){
    return ("o\n");
    }
}

