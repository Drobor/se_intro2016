/**
 * Created by m295- on 19.11.2016.
 */
public class ConsoleTurnLogger implements IGameLogger {
    private int turnCounter;

    public void log(IField field, TurnResult turnResult) {
        Player curPlayer = turnResult.getCurrentPlayer();
        GameState state = turnResult.getGameState();

        System.out.println("Turn " + ++this.turnCounter);
        System.out.println(curPlayer.toString() + " decided to move on " + turnResult.getMove().toString());

        if (!turnResult.getMoveValid()) {
            System.out.println("But this move was invalid.\n" + curPlayer.toString() + " is now excluded from the game");
        }

        if (state.getIsDraw()) {
            System.out.println("Game has ended with a draw");
        } else if (!(state.getWinner() == null)) {
            System.out.println("Player " + state.getWinner().toString() + " won the game!");
        }
    }
}
