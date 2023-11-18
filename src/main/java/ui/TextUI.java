package ui;
import mancala.MancalaGame;
import mancala.Board;
import mancala.Player;
import mancala.Store;
import mancala.Pit;
import mancala.GameNotOverException;
import mancala.InvalidMoveException;
//import mancala.NoSuchPlayerException;
//import mancala.PitNotFoundException;

import java.util.Scanner;
import java.util.ArrayList;

public class TextUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Initialize the Mancala game and set up players
        MancalaGame game = new MancalaGame();
    
        Player player1 = new Player("Alice");
        Player player2 = new Player("Emily");

        game.setPlayers(player1, player2);
        game.setCurrentPlayer(player1);
        Player currentPlayer = game.getCurrentPlayer();
        Board board = new Board();
        game.setBoard(board);
        
        Pit pit = new Pit();
        game.getBoard().setUpPits();
        //List<Pit> pitsList = game.getBoard().getPits();

        Store store = new Store();
        game.getBoard().setUpStores();
        ArrayList<Store> stores = board.getStores();
        board.registerPlayers(player1,player2);
        //List<Store> storeList = game.getBoard().getStores();

        ArrayList<Pit> pits = game.getBoard().getPits();
        

        //game.setPlayers(player1, player2);

        
        // Start the game loop
        while (!game.isGameOver()) {
            // Display the current game state (e.g., the board, player names, stone counts)
            System.out.println("Current Game State:");
            //System.out.println("Board: " + game.getBoard().toString());
            System.out.println(player1.getName() + "'s Store: " + player1.getStoreCount() + " stones");
            System.out.println(player2.getName() + "'s Store: " + player2.getStoreCount() + " stones");

            for(int i = 0; i < 12; i++){
                int j = i + 1;
                System.out.println("pit " + j + " : " + pits.get(i).getStoneCount());
            }

            // Ask the current player to make a move
            //Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + ", it's your turn.");
            System.out.print("Enter the pit number to move from: ");
            int pitNumber = scanner.nextInt();

            System.out.println("pit " + pitNumber + " has " + pits.get(pitNumber - 1).getStoneCount() + " stones");
            System.out.println("now moving ...");

            // Perform the move
            int capturedStones = 0;
            int moveStones = 0;
            try{
                game.move(pitNumber);
                //capturedStones = board.moveStones(pitNumber, currentPlayer);

            }catch(InvalidMoveException e){
                System.out.println("Invalid move. try again.");
            }
            
            currentPlayer = game.getCurrentPlayer();


            // Display the move result
            System.out.println("Stones moved from pit " + pitNumber + ".");
        }

        // Display the game result (e.g., the winner)

        try{
            Player winner = game.getWinner();
            System.out.println("Game Over! " + winner.getName() + " wins!");
        }catch(GameNotOverException e){
            System.out.println("Game is not over.");
        }
        
        // Close the scanner
        scanner.close();
    }
}