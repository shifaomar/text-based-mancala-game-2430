package mancala;

public class Store{

    private int totalStones;
    private Player owner;
   

    public Store(){
        totalStones = 0;
        owner = null;
    }

    public void addStones(int amount){                   //adds stones to the store
        totalStones += amount;
    }

//empties the store and returns the number of stones that were in it
    public int emptyStore(){                                 
        int stonesInStore = totalStones;
        totalStones = 0;
        return stonesInStore;
    }

    public Player getOwner(){                                //gets the owner of the store
        return owner;
    }

    public int getTotalStones(){                             //gets the total number of stones in the store
        return totalStones;
    }

    public void setOwner(Player player){                     //sets the owner of the store
        owner = player;
    }

    @Override
    public String toString(){
        return String.valueOf(totalStones);
    }
}