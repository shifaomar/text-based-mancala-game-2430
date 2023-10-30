package ui;
import mancala.MancalaGame;
import mancala.Board;
import mancala.Player;
import mancala.Store;
import mancala.Pit;
import mancala.GameNotOverException;
import mancala.InvalidMoveException;
import mancala.NoSuchPlayerException;
import mancala.PitNotFoundException;

import java.util.Scanner;
import java.util.List;

public class TextUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the Mancala game and set up players
        MancalaGame game = new MancalaGame();
        game.getBoard().setUpPits();
        List<Pit> pits = game.getBoard().getPits();
        Player player1 = new Player();
        Player player2 = new Player();
        game.setPlayers(player1, player2);

        // Start the game loop
        while (!game.isGameOver()) {
            // Display the current game state (e.g., the board, player names, stone counts)
            System.out.println("Current Game State:");
            System.out.println("Board: " + game.getBoard().toString());
            System.out.println(player1.getName() + "'s Store: " + player1.getStoreCount() + " stones");
            System.out.println(player2.getName() + "'s Store: " + player2.getStoreCount() + " stones");

            // Ask the current player to make a move
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + ", it's your turn.");
            System.out.print("Enter the pit number to move from: ");
            int pitNumber = scanner.nextInt();

            System.out.println("pit " + pitNumber + " has " + pits.get(pitNumber).getStoneCount() + " stones");
            System.out.println("now moving ...");

            // Perform the move
            int capturedStones = game.move(pitNumber);

            // Display the move result
            System.out.println("Stones moved from pit " + pitNumber + ". Captured " + capturedStones + " stones.");
        }

        // Display the game result (e.g., the winner)
        Player winner = game.getWinner();
        System.out.println("Game Over! " + winner.getName() + " wins!");

        // Close the scanner
        scanner.close();
    }
}