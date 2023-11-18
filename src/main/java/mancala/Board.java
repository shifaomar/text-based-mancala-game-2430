package mancala;

import java.util.ArrayList;
//import java.util.List;

public class Board{

    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private Player currentPlayer;
    

    public Board(){
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        initializeBoard();
        
        currentPlayer = new Player();

    }

    //captures stones from the opponents pits
    public int captureStones(int stoppingPoint) throws PitNotFoundException{
        if(stoppingPoint < 0 || stoppingPoint > 11){
            throw new PitNotFoundException("Pit not found.");
        }
        if (pits.get(stoppingPoint).getStoneCount() == 1) {
            int oppositePitIndex = pits.size() - 1 - stoppingPoint;         
            int capturedStones = pits.get(stoppingPoint).removeStones(); 
            capturedStones += pits.get(oppositePitIndex).removeStones(); 
            return capturedStones;
        }
        return 0;
    }


    //helper method that distributes stones into pits and stores, skipping the opponents store
    public int distributeStones(int startingPoint) throws PitNotFoundException{     
        if(startingPoint < 1 || startingPoint > 12){
            throw new PitNotFoundException("Pit not found.");
        } 
        int stonesInStore = 0;
        int remainingStones = pits.get(startingPoint-1).removeStones();
        int stonesRemoved = remainingStones;
        int currentPitIndex = (startingPoint - 1);
        while (remainingStones > 0) {
            currentPitIndex = (currentPitIndex + 1) % 12; // The board has 12 pits
            if ((startingPoint - 1) < 6){
                if(currentPitIndex >=6){
                    if(currentPitIndex == 6){
                        stores.get(0).addStones(1);  //add stone to players store
                        stonesInStore++;
                    }else{
                        pits.get(currentPitIndex - 1).addStone();
                    }
                }else{
                    pits.get(currentPitIndex).addStone();
                }
            }else if ((startingPoint-1) > 5){
                if(currentPitIndex <= 5){
                    if(currentPitIndex == 0){
                        stores.get(1).addStones(1);  //add stone to players store
                        stonesInStore++;
                    }else{
                        pits.get(currentPitIndex - 1).addStone();
                    }
                }else{
                    pits.get(currentPitIndex).addStone();
                }
            }
            remainingStones--;
        }
        return stonesRemoved;
    }

    // gets the number of stones in a specific pit
    public int getNumStones(int pitNum) throws PitNotFoundException{ 
        if(pitNum < 1 || pitNum > 12){
            throw new PitNotFoundException("Pit Not found.");
        }         
        return pits.get(pitNum-1).getStoneCount();
    }
    

    //Returns the list of pits in the board, not including the stores
    public ArrayList<Pit> getPits() {
        return pits;
    }

    //returns the list of stores in the board
    public ArrayList<Store> getStores(){
        return stores;
    }

    //initializes the board by distributing stones
    public void initializeBoard(){
        setUpPits();
        setUpStores();
    
        for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 4; j++) {                   //adding 4 stones to each pit
                    pits.get(i).addStone();
                }
        }
    }

    //indicates whether one side of the board is empty
    public boolean isSideEmpty(int pitNum) throws PitNotFoundException{
        if(pitNum < 1 || pitNum > 12){
            throw new PitNotFoundException("Pit not found.");
        }
        int startingPit = pitNum <= 6 ? 0 : 6;
        int endingPit = pitNum <= 6 ? 5 : 11;
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
            throw new InvalidMoveException("Invalid move.");
        }
        this.currentPlayer = player;
        int stonesCaptured = 0;
        int stonesInStoreBeforeMove = player.getStoreCount();
        try{
            distributeStones(startPit);
       
            int stonesInStartingPit = pits.get(startPit).getStoneCount();
            int stoppingPoint = (startPit - 1) + stonesInStartingPit;
            
            if(startPit < 6 && stoppingPoint < 6){
                stonesCaptured = captureStones(stoppingPoint);
                player.getStore().addStones(stonesCaptured);

            }else if (startPit > 5 && stoppingPoint > 5){
                stonesCaptured = captureStones(stoppingPoint);
                player.getStore().addStones(stonesCaptured);
            }
        } catch (PitNotFoundException e) {
            throw new InvalidMoveException("Invalid move: Pit not found.");
        }
        int stonesInStoreAfterMove = player.getStoreCount();
        int stonesAdded = stonesInStoreAfterMove - stonesInStoreBeforeMove;
    
        return stonesAdded;
    }

    //connects players to their stores. Will need to call methods in store and in player to ensure a two-way connection
    public void registerPlayers(Player one, Player two){
        one.setStore(stores.get(0));
        stores.get(0).setOwner(one);
        two.setStore(stores.get(1));
        stores.get(1).setOwner(two);
    }


    //resets the board by redistrbtuing the stones but retains the players
    public void resetBoard(){     
        for (int i = 0; i < 12; i++) {
            pits.get(i).removeStones();
        }
        initializeBoard();                                    
    
    }


    //establishes 12 empty pits in the board
    public void setUpPits(){
        for (int i = 0; i < 12; i++) {
                pits.add(new Pit());
        }
    }


    //establishes 2 empty stores in the board
    public void setUpStores(){
        stores.add(new Store());
        stores.add(new Store());
    }

    
    public String toString(){
    return "current player: " + currentPlayer;
    }
}

