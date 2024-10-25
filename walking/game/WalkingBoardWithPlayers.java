package walking.game;
import walking.game.player.Player;
import walking.game.player.MadlyRotatingBuccaneer;
import walking.game.util.Direction;


public class WalkingBoardWithPlayers extends WalkingBoard{
    private Player[] players;
    private int round;

    public static final int SCORE_EACH_STEP = 13;

    public WalkingBoardWithPlayers(int[][] board, int playerCount){
        super(board);
        initPlayers(playerCount);
    }

    public WalkingBoardWithPlayers(int size, int playerCount){
        super(size);
        initPlayers(playerCount);
    }

    private void initPlayers(int playerCount){
        if(playerCount < 2){
            throw new IllegalArgumentException("Player count must be at least 2.");
        } else {
            players = new Player[playerCount];
            players[0] = new MadlyRotatingBuccaneer();
            for (int i = 1; i < playerCount; i++) {
                players[i] = new Player();
            }
        }
    }

        public int[] walk(int... stepCounts) {
            int[] scores = new int[players.length];
            int totalSteps = 0;

            for (int steps : stepCounts) {
                Player currentPlayer;

                if (round == 0) {
                    currentPlayer = (MadlyRotatingBuccaneer) players[0];
                } else {
                    currentPlayer = players[round % players.length];
                }

                currentPlayer.turn();
                Direction currentDirection = currentPlayer.getDirection();

                int remSteps = steps;
                totalSteps = 0;


                while (remSteps > 0) {
                    int stepsToTake = Math.min(remSteps, SCORE_EACH_STEP);
                    int prevTileVal = moveAndSet(currentDirection, stepsToTake);

                    if (prevTileVal != Integer.MIN_VALUE) {
                        scores[round % players.length] += prevTileVal;
                        totalSteps += stepsToTake;
                    }

                            remSteps -= stepsToTake;

                    if (prevTileVal == 0) {
                        break;
                    }
                }

        round++;
    }

    return scores;
}

}