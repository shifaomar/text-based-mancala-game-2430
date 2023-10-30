package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Board board;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private boolean gameIsOver;
    private Player winner;

    public MancalaGame() {
        board = new Board();
        players = new ArrayList<>();
        gameIsOver = false;
        winner = null;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getNumStones(int pitNum) {
        return board.getNumStones(pitNum);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getStoreCount(Player player) {
        return player.getStoreCount();
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isGameOver() {
        return gameIsOver;
    }

    
    public int move(int startPit) throws InvalidMoveException {
    // Add your logic to check if the move is valid
    int capturedStones = 0;
    if (!isValidMove(startPit)) {
        
        throw new InvalidMoveException("Invalid move");
    }

    // Implement the move logic here

    return capturedStones;
    }

    

    public void setBoard(Board theBoard) {
        board = theBoard;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    public void setPlayers(Player p1, Player p2) {
        players.add(p1);
        players.add(p2);
        currentPlayer = p1;
    }

    public void startNewGame() {
        board.resetBoard();
        gameIsOver = false;
        winner = null;
    }

    @Override
    public String toString() {
        // Implement the game's string representation
        return "Mancala Game Representation";
    }


 public boolean isValidMove(int startPit) {
        // Check if the move is valid based on the game rules
        if (startPit < 0 || startPit >= board.getPits().size()) {
            // Pit number is out of bounds
            return false;
        }

        // Additional rules for a valid move can be implemented here

        return true; // If the move passes all checks, it's valid
    }
}