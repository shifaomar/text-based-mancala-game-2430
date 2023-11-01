package mancala;

public class Pit{
    private int stoneCount;

    public Pit(){
        stoneCount = 0;
    }
    
    public void addStone(){                                        //adds a stone to the pit
        stoneCount++;
    }

    public int getStoneCount(){                                    //gets the number of stones in the pit
        return stoneCount;
    }

    public int removeStones(){                                     //removes and returns the stones from the pit
        int stonesRemoved = stoneCount;
        stoneCount = 0;
        return stonesRemoved;
    }

    public String toString(){
        return String.valueOf(stoneCount);
        
    }

}