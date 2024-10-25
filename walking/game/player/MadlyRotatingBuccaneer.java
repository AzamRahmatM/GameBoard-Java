package walking.game.player;
import walking.game.util.Direction;

public class MadlyRotatingBuccaneer extends Player {
    private int turnCount; 

    public MadlyRotatingBuccaneer() {
        super();
        this.turnCount = 0; 
    }

    @Override
    public void turn() {
        if (turnCount > 0) {
            int rotations = turnCount % 2;
            if (rotations == 1) {
                turn90deg();
            } else {
                turn180Degrees();
            }
        }
        turnCount++;
    }

    private void turn90deg() {
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
        }
    }

    private void turn180Degrees() {
        switch (direction) {
            case UP:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.UP;
                break;
            case LEFT:
                direction = Direction.RIGHT;
                break;
        }
    }
}

