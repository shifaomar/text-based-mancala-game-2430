package mancala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class BoardTest {
    private Board board;
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        board = new Board();
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        board.registerPlayers(player1, player2);
    }

    @Test
    void testInitializeBoard() {
        // Assuming 12 pits and 2 stores are set up during initialization
        assertEquals(12, board.getPits().size());
        assertEquals(2, board.getStores().size());

        // Test if all pits are initialized with 4 stones
        for (Pit pit : board.getPits()) {
            assertEquals(4, pit.getStoneCount());
        }
    }

    /*@Test
    void testIsSideEmpty() throws PitNotFoundException {
        // Assuming the board is initialized and both sides are not empty initially
        assertFalse(board.isSideEmpty(4));
        assertFalse(board.isSideEmpty(9));

        // Assuming a side is emptied
        // Manually removing stones from pits to simulate an empty side
        for (int i = 0; i < 6; i++) {
            board.getPits().get(i).removeStones();
        }
        assertTrue(board.isSideEmpty(4));
    }
*/
    @Test
    void testMoveStones() throws InvalidMoveException {
        // Assuming a valid move where stones are moved
        int stonesAdded = board.moveStones(3, player1);
        assertTrue(stonesAdded >= 0); // Checking if stones were added to the store

        // Assuming an invalid move outside the board range
        assertThrows(InvalidMoveException.class, () -> board.moveStones(15, player2));
    }


    @Test
    void testCaptureStones() {
        try {
            // Make pit 3 have only 1 stone
            board.getPits().get(3).removeStones();
            board.getPits().get(3).addStone();
            
            int stonesCaptured = board.captureStones(3);
            assertTrue(stonesCaptured > 0); // Check if stones were captured
        } catch (PitNotFoundException e) {
            fail("Pit not found while testing.");
        }
    }

    @Test
    void testDistributeStones() {
       try{
            board.getPits().get(3).removeStones();
            for(int i =0; i<4; i++){
                board.getPits().get(3).addStone();
            }
            int stonesRemoved = board.distributeStones(3);
            assertEquals(4, stonesRemoved);
       } catch (PitNotFoundException e) {
            fail("Pit not found while testing.");
        }
    }
}