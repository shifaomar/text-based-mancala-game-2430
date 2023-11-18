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
        int stones = totalStones;
        totalStones = 0;
        return stones;
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
        return "Store{" +
                "owner=" + owner +
                ", totalStones=" + totalStones +
                '}';
    }
}