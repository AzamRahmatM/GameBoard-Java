package walking.game;
import java.util.Arrays;


import walking.game.util.Direction;

public class WalkingBoard {
       private int[][] tiles;
        private int x;
        private int y;
        public static final int BASE_TILE_SCORE = 3;

    public WalkingBoard(int size) {
        tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tiles[i][j] = BASE_TILE_SCORE;
            }
        }
        this.x = 0; 
        this.y = 0; 
    }

    public WalkingBoard(int[][] tiles) {
        this.tiles = new int[tiles.length][];
        for (int i = 0; i < tiles.length; i++) {
            this.tiles[i] = Arrays.copyOf(tiles[i], tiles[i].length);
            for (int j = 0; j < tiles[i].length; j++) {
                this.tiles[i][j] = Math.max(tiles[i][j], BASE_TILE_SCORE);
            }
        }
        this.x = this.tiles[0].length - 1; 
        this.y = this.tiles.length - 1; 
    }

    public int[][] getTiles() {
        int[][] copiedTiles = new int[this.tiles.length][];
        for (int i = 0; i < this.tiles.length; i++) {
            copiedTiles[i] = Arrays.copyOf(this.tiles[i], this.tiles[i].length);
        }
        return copiedTiles;
    }

    public int[] getPosition() {
    int[] position = new int[2];
    position[0] = this.x;
    position[1] = this.y;
    return position;

    }

    public boolean isValidPosition(int x, int y) {
     boolean result =x >= 0 && x < this.tiles.length && y >= 0 && y < this.tiles[x].length;
     return result;
    }

    public int getTile(int x, int y) {
        int value = this.tiles[x][y];
        if (!isValidPosition(x,y)){
            throw new IllegalArgumentException("INVALID POSITION");
        }
        return value;
    }

    public static int getXStep(Direction direction) {
        int s = 0;
        switch (direction) {
            case RIGHT:
                s = 1;
                break;
            case LEFT:
                s = -1;
                break;
        }
        return s;
    }

    public static int getYStep(Direction direction) {
        int s = 0;
        switch (direction) {
            case UP:
                s = -1;
                break;
            case DOWN:
                s = 1;
                break;
        }
        return s;
    }



    public int moveAndSet(Direction dir, int value) {
            int newX = this.x + getXStep(dir) * value;
            int newY = this.y + getYStep(dir) * value;


            if (!isValidPosition(newX, newY)) {
                return Integer.MIN_VALUE; 
            }
        
            int oldVal = tiles[newX][newY];
            tiles[newX][newY] = value;
            this.x = newX;
            this.y = newY;
            return oldVal;

            
        }



}

    






