package mancala;

public class Store {
    private Player owner;
    private int totalStones;

    public Store() {
        owner = null;
        totalStones = 0;
    }

    public void addStones(int amount) {
        totalStones += amount;
    }

    public int emptyStore() {
        int stonesInStore = totalStones;
        totalStones = 0;
        return stonesInStore;
    }

    public Player getOwner() {
        return owner;
    }

    public int getTotalStones() {
        return totalStones;
    }

    public void setOwner(Player player) {
        owner = player;
    }

    @Override
    public String toString() {
        return Integer.toString(totalStones);
    }
}