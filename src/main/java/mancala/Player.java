package mancala;

public class Player{

    private String theName;
    private Store theStore;

    public Player() {
        
        //theName = "DefaultPlayer";
        theName = null; 
        theStore = new Store(); 
    }

    public Player(String name){
        //this.theName = name;
        setName(name);
        theStore = new Store();
    }

    public String getName(){                   //gets the name of the player
        
        return theName;
    }

    public Store getStore(){                   //gets the players store when they collect stones
        return theStore;
    }

     /*public int getStoreIndex() {
        if (this.getName().equals("Player 1")) {
            return 0;
        } else {
            return 1;
        }
    }*/

//gets the count of the number of stones in the players store when they collect stones
    public int getStoreCount(){             
        return theStore.getTotalStones();
    }

    public void setName(String name){           //sets the players name
        this.theName = name;
    }
    
    public void setStore(Store store){          //sets the players store
        this.theStore = store;
    }

    @Override
    public String toString(){
            return theName;
    }

}