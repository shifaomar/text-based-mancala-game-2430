package mancala;

import java.util.ArrayList;
//import java.util.List;

public class Board{

    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    //private MancalaGame game;
    private Player playerr;
    

    public Board(){
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        //this.game = game;
        //setGame(game);
        initializeBoard();
        
        playerr = new Player();
        

        for (int i = 0; i < 12; i++) {
            pits.add(new Pit());
        }
        for (int i = 0; i < 2; i++) {
            stores.add(new Store());
        }
        

    }

    /*public void setGame(MancalaGame thisGame) {
        this.game = thisGame;
    }*/

    public int captureStones(int stoppingPoint){           //captures stones from the opponents pits
    //complete to check if it is on current players side
        if (pits.get(stoppingPoint).getStoneCount() == 1) {
            int oppositePitIndex = pits.size() - 1 - stoppingPoint;         
            int capturedStones = pits.get(stoppingPoint).removeStones(); 
            capturedStones += pits.get(oppositePitIndex).removeStones(); 

            // Placing the captured stones in the player's store
            playerr.getStore().addStones(capturedStones);
            
            return capturedStones;
        }
        return 0;
    }


//helper method that distributes stones into pits and stores, skipping the opponents store
    public int distributeStones(int startingPoint){      
          int remainingStones = pits.get(startingPoint-1).removeStones();
        int currentPitIndex = (startingPoint - 1);
        while (remainingStones > 0) {
            currentPitIndex = (currentPitIndex + 1) % 12; // The board has 12 pits
            if ((startingPoint - 1) <= 5 && currentPitIndex >=6){
                if(currentPitIndex == 6){
                    playerr.getStore().addStones(1);
                }else{
                    pits.get(currentPitIndex - 1).addStone();
                }
            }else if ((startingPoint-1) >= 6 && currentPitIndex < 6){
                if(currentPitIndex == 0){
                    playerr.getStore().addStones(1);
                }else{
                    pits.get(currentPitIndex - 1).addStone();
                }
            }
           
            //if (currentPitIndex != 1) {
              //  pits.get(currentPitIndex).addStone();
                remainingStones--;
            //}
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
        int startingPit = pitNum <= 6 ? 0 : 5;
        int endingPit = pitNum <= 6 ? 6 : 11;
        for (int i = startingPit; i <= endingPit; i++) {
            if (getNumStones(i) > 0) {
                return false;
            }
        }
        return true;
    }

    //moves stones for the player starting from a specific pit
    public int moveStones(int startPit, Player player) throws InvalidMoveException {
        if (startPit > 12 || startPit < 1) {
            throw new InvalidMoveException("Invalid move selection.");
        }
        int currentPitIndex = distributeStones(startPit);

        /*if (currentPitIndex == player.getStoreIndex()) {
            game.setCurrentPlayer(player);
        }*/
        Store playerStore = player.getStore();
        
        if(startPit <=6){
            if (currentPitIndex == 6){
                playerr = player; //fix this
            }
        }
        

        // Checking if the game is over after distributing stones
        if (isSideEmpty(0) || isSideEmpty(6)) {
            for (int i = 0; i < 12; i++) {
                int pitStoneCount = getNumStones(i);
                if (pitStoneCount > 0) {
                player.getStore().addStones(pitStoneCount);
                }
            }
        }

        return currentPitIndex;
    }


    public void registerPlayers(Player one, Player two){        //connects players to their stores
        one.setStore(stores.get(0));
        two.setStore(stores.get(1));
    }


//resets the board by redistrbtuing the stones but retains the players
    public void resetBoard(){     
        for (int i = 0; i < 12; i++) {
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

