package mancala;

import java.util.ArrayList;
import java.util.List;

public class Board{

    public int captureStones(int stoppingPoint){
        return 0;
    }

    public int distributeStones(int startingPoint){        //helper method that distributes stones into pits and stores, skipping the opponents store
        return 0;
    }
    public int getNumStones(int pitNum){                        // gets the number of stones in a specific pit          
        return 0;
    }
    
    public ArrayList<Pit> getPits() {
   
    ArrayList<Pit> pits = new ArrayList<>();
    
    
    
    return pits;
    }

    public ArrayList<Store> getStores(){                        //returns the list of stores in the board
        ArrayList<Store> stores = new ArrayList<>();
        return stores;

    }
    public void initializeBoard(){                              //initializes the board by distributing stones
    
    }
    public boolean isSideEmpty(int pitNum){                     //indicates whether one side of the board is empty
        return false;
    }
    public int moveStones(int startPit, Player player){         //moves stones for the player starting from a specific pit
        return 0;
    }
    public void registerPlayers(Player one, Player two){        //connects players to their stores
    
    }

    public void resetBoard(){                                   //resets the board by redistrbtuing the stones but retains the players
    
    }
    public void setUpPits(){                                    //establishes 12 empty pits in the board
    
    }
    public void setUpStores(){                                  //establishes 2 empty stores in the board
    
    }
    public String toString(){
    return ("o\n");
    }
}