/**
 * Created by Drobor on 19.11.2016.
 */
public class TurnResult {
    private Player player;
    private Point move;
    private boolean moveValid;
    private GameState gameState;

    public TurnResult(Player player, Point move, boolean moveValid, GameState gameState) {
        this.moveValid = moveValid;
        this.move = move;
        this.player = player;
        this.gameState = gameState;
    }

    public Player getCurrentPlayer() {
        return player;
    }

    public Point getMove() {
        return move;
    }

    public boolean getMoveValid() {
        return moveValid;
    }

    public GameState getGameState() {
        return gameState;
    }


}
