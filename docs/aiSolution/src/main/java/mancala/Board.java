package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private Player playerOne;
    private Player playerTwo;

    public Board() {
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        playerOne = new Player("Player 1");
        playerTwo = new Player("Player 2");
        initializeBoard();
    }

    public int captureStones(int stoppingPoint) {
        // Implement capturing stones logic
        return 0;
    }

    public int distributeStones(int startingPoint) {
        // Implement distributing stones logic
        return 0;
    }

    public int getNumStones(int pitNum) {
        return pits.get(pitNum).getStoneCount();
    }

    public ArrayList<Pit> getPits() {
        return pits;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void initializeBoard() {
        setUpPits();
        setUpStores();
        registerPlayers(playerOne, playerTwo);
    }

    public boolean isSideEmpty(int pitNum) {
        // Check if one side of the board is empty
        return true;
    }

    public int moveStones(int startPit, Player player) {
        // Move stones for the player from a specific pit
        return 0;
    }

    public void registerPlayers(Player one, Player two) {
        playerOne.setStore(one.getStore());
        playerTwo.setStore(two.getStore());
    }

    public void resetBoard() {
        // Reset the board by redistributing the stones but retain the players
    }

    public void setUpPits() {
        for (int i = 0; i < 12; i++) {
            pits.add(new Pit());
        }
    }

    public void setUpStores() {
        stores.add(playerOne.getStore());
        stores.add(playerTwo.getStore());
    }

    @Override
    public String toString() {
        // Implement the board's string representation
        return "Board Representation";
    }
}