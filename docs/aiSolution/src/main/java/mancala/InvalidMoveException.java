package mancala;

public class InvalidMoveException extends Exception {
    public InvalidMoveException() {
        super("Invalid move. Please try again.");
    }

    public InvalidMoveException(String message) {
        super(message);
    }
}