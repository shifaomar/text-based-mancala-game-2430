package ui;
import mancala.*;

import java.util.Scanner;

public class TextUI {
    public static void main(String[] args) {
        MancalaGame game = new MancalaGame();
        game.setPlayers(new Player("Player 1"), new Player("Player 2"));
        game.startNewGame();
        int pitNumber = 1;

        System.out.println("Welcome to the Mancala game!");

        while (!game.isGameOver()) {
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("\n" + currentPlayer.getName() + "'s turn");

            // Display the current state of the board
            System.out.println(game.toString());

            // Implement user input to make a move
            // You can add logic to handle player moves here
            // For example, read the pit number from the user and call game.move(pitNumber)

            // Example: Read a pit number from the console
            // int pitNumber = 0; // Read the pit number from the user

            // Try to make the move and handle exceptions
            try {
                // Replace the following line with your move logic
                 game.move(pitNumber);
            } catch (InvalidMoveException e) {
                System.out.println("Invalid move. Try again.");
            }

            // Switch to the next player
            game.setCurrentPlayer(game.getCurrentPlayer() == game.getPlayers().get(0) ? game.getPlayers().get(1) : game.getPlayers().get(0));
        }

        // Display the final state of the board
        System.out.println("\nGame over!");
        System.out.println(game.toString());

        // Determine the winner and display the result
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println(winner.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}