package mancala;

public class Player{
    public String getName(){                   //gets the name of the player
        
        return "";
    }

    public Store getStore(){                      //gets the players store when they collect stones
        Store store = new Store();
        return store;
    }

    public int getStoreCount(){             //gets the count of the number of stones in the players store when they collect stones
        return 0;
    }

    public void setName(String name){           //sets the players name
        
    }
    
    public void setStore(Store store){          //sets the players store

    }

    public String toString(){
            return ("o\n");
    }



}