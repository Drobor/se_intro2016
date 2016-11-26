/**
 * Created by m295- on 19.11.2016.
 */
public class GameState {
    private boolean isDraw;
    private Player winner;

    public GameState(boolean isDraw) {
        this.isDraw = isDraw;
    }

    public GameState(Player winner) {
        this.winner = winner;
    }

    public boolean getIsDraw() {
        return this.isDraw;
    }

    public boolean gameEnded() {
        return this.isDraw | this.winner != null;
    }

    public Player getWinner() {
        return this.winner;
    }
}
