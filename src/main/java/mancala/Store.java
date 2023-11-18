package mancala;

public class Store {
    private Player owner;
    private int totalStones;

    public Store() {
        owner = null;
        totalStones = 0;
    }

    public void addStones(int amount) {          //Adds stones to the store.
        totalStones += amount;
    }

    public int emptyStore() {                   //Empties the store and returns the number of stones that were in it.
        int stones = totalStones;
        totalStones = 0;
        return stones;
    }

    public Player getOwner() {                  //Gets the owner of the store.
        return owner;
    }

    public int getTotalStones() {               //Gets the total number of stones in the store.
        return totalStones;
    }

    public void setOwner(Player player) {       //Sets the owner of the store.
        owner = player;
    }

    @Override
    public String toString() {
        return "Store{" + "owner=" + owner + ", totalStones captured =" + totalStones + '}';
    }
}