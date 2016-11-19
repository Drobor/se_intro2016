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

    public boolean getIsDraw()
    {
        return isDraw;
    }

    public Player getWinner()
    {
        return winner;
    }
}
