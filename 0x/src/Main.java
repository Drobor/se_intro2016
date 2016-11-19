import org.omg.CORBA.TRANSACTION_UNAVAILABLE;

/**
 * Created by Drobor on 19.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(3, 3, new RowVictoryChecker(3, true));
        game.createPlayer(new RandomInputProvider(), "bot1", 'x');
        game.createPlayer(new RandomInputProvider(), "bot2", 'o');
        RunGame(game, new ConsoleFieldLogger(), true);

        game = new Game(10, 10, new RowVictoryChecker(5, false));
        game.createPlayer(new RandomInputProvider(), "bot1", 'x');
        game.createPlayer(new RandomInputProvider(), "bot2", 'o');
        game.createPlayer(new RandomInputProvider(), "bot3");
        RunGame(game, new ConsoleFieldTurnLogger(), false);

        game = new Game(11, 11, new RowVictoryChecker(4, true));
        game.createPlayer(new RandomInputProvider(), "bot1");
        game.createPlayer(new RandomInputProvider(), "bot2");
        game.createPlayer(new RandomInputProvider(), "bot3");
        game.createPlayer(new ConsoleInputProvider(), "HUMAN???!!!", 'x');
        RunGame(game, new ConsoleTurnLogger(), false);
    }

    public static void RunGame(Game game, IGameLogger logger, boolean awaitEachTurn) {
        TurnResult turn;
        for (turn = game.makeTurn(); !turn.getGameState().getIsDraw() && turn.getGameState().getWinner() == null; turn = game.makeTurn()) {
            logger.Log(game, turn);
            if (awaitEachTurn)
                try {
                    for (int c = System.in.read(); c != 10 && c != 13; c = System.in.read()) ;
                } catch (Exception ex) {
                    //Should do something here. Though nothing should be fine. Hopefully
                }
        }
        logger.Log(game, turn);
        if (awaitEachTurn)
            try {
                for (int c = System.in.read(); c != 10 && c != 13; c = System.in.read()) ;
            } catch (Exception ex) {
                //Should do something here. Though nothing should be fine. Hopefully
            }
    }
}
