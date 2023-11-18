package mancala;

public class Player {
    private String theName;
    private Store theStore;

    public Player() {
        this.theName = new String();
        this.theStore = new Store();
    }

    public Player(String name) {
        this.theName = name;
        this.theStore = new Store();
    }

    public String getName() {               //Gets the name of the player.
        return theName;
    }

    public Store getStore() {               //Gets the player's store where they collect stones.
        return theStore;
    }

    //Gets the count of the number of stones in the player's store where they collect stones.
    public int getStoreCount() {         
        return theStore.getTotalStones();
    }

    public void setName(String name) {      //Sets the player's name.
        this.theName = name;
    }

    public void setStore(Store store) {     //Sets the player's store.
        this.theStore = store;
    }

    @Override
    public String toString() {
        return "Player = " + theName;
    }
}