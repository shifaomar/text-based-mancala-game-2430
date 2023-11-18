package mancala;

public class Pit {
    private int stoneCount;

    public Pit() {
        stoneCount = 0;
    }

    public void addStone() {                //Adds a stone to the pit.
        stoneCount++;
    }

    public int getStoneCount() {            //Gets the number of stones in the pit.
        return stoneCount;
    }

    public int removeStones() {             //Removes and returns the stones from the pit.
        int stones = stoneCount;
        stoneCount = 0;
        return stones;
    }

    @Override
    public String toString() {
        return "Pit{" + "stoneCount=" + stoneCount + '}';
    }
}