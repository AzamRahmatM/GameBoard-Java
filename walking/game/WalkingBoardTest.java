package walking.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import walking.game.util.Direction;
import static org.junit.jupiter.api.Assertions.*;

public class WalkingBoardTest {

    private WalkingBoard board;

    @BeforeEach
    public void setUp() {
        board = new WalkingBoard(4);
    }

    @ParameterizedTest
    @CsvSource({"2", "3", "4"})
    public void testSimpleInit(int size) {
        WalkingBoard board = new WalkingBoard(size);

        assertEquals(size, board.getTiles().length);
        assertEquals(size, board.getTiles()[0].length);

        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTile(0, 0));
        assertEquals(WalkingBoard.BASE_TILE_SCORE, board.getTile(size - 1, size - 1));
    }

   @ParameterizedTest
@CsvSource({
    "1, 2, 3, 0, 0, 3",
    "5, 6, 7, 0, 0, 5", 
    "3, 4, 5, 0, 2, 5"  
})
public void testCustomInit(int v1, int v2, int v3, int x, int y, int expected) {
    int[][] tiles = {{v1, v2, v3}};
    WalkingBoard board = new WalkingBoard(tiles);

    assertEquals(expected, board.getTile(x, y));
}


@Test
public void testMoves() {
    WalkingBoard board = new WalkingBoard(3);

    int[] initialPosition = board.getPosition();
    assertEquals(0, initialPosition[0]);
    assertEquals(0, initialPosition[1]);
    assertEquals(3, board.getTile(initialPosition[0], initialPosition[1]));

    assertEquals(Integer.MIN_VALUE, board.moveAndSet(Direction.RIGHT, 4));
    int[] newPosition = board.getPosition();
    assertEquals(0, newPosition[0]);
    assertEquals(0, newPosition[1]);
    assertEquals(3, board.getTile(newPosition[0], newPosition[1]));

    assertEquals(Integer.MIN_VALUE, board.moveAndSet(Direction.DOWN, 5));
    newPosition = board.getPosition();
    assertEquals(0, newPosition[0]);
    assertEquals(0, newPosition[1]);
    assertEquals(3, board.getTile(newPosition[0], newPosition[1]));

    assertEquals(Integer.MIN_VALUE, board.moveAndSet(Direction.UP, 1));
    newPosition = board.getPosition();
    assertEquals(0, newPosition[0]);
    assertEquals(0, newPosition[1]);
    assertEquals(3, board.getTile(newPosition[0], newPosition[1]));
}







}
