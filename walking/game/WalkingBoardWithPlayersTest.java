package walking.game;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import walking.game.player.MadlyRotatingBuccaneer;
import walking.game.util.Direction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WalkingBoardWithPlayersTest {
    @ParameterizedTest
    @CsvSource({
        "3, 3, 4, 2",
        "4, 4, 3, 5"   
    })
    public void walk1(int boardSize, int playerCount, int steps1, int steps2) {
        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(boardSize, playerCount);

        int[] stepCounts = {steps1, steps2};

        int[] finalScores = board.walk(stepCounts);

        assertEquals(playerCount, finalScores.length);

        for (int score : finalScores) {
            assertTrue(score >= 0);
        }

        assertEquals(3, board.getTile(0, 0));
    }

    @ParameterizedTest
    @CsvSource({
        "5, 2, 3, 4, 1",  
        "3, 5, 2, 2, 3"   
    })
    public void walk2(int boardSize, int playerCount, int steps1, int steps2, int steps3) {
        WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(boardSize, playerCount);

        int[] stepCounts = {steps1, steps2, steps3};

        int[] finalScores = board.walk(stepCounts);

        assertEquals(playerCount, finalScores.length);

        for (int score : finalScores) {
            assertTrue(score >= 0);
        }

        assertEquals(3, board.getTile(0, 0));
    }
}
