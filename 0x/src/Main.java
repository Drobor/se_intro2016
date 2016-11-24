import org.omg.CORBA.TRANSACTION_UNAVAILABLE;

/**
 * Created by Drobor on 19.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(3, 3, new RowVictoryChecker(3, true));
        game.createPlayer(new RandomInputProvider(), "bot1", 'x');
        game.createPlayer(new RandomInputProvider(), "bot2", 'o');
        runGame(game, new ConsoleFieldLogger(), true);

        game = new Game(10, 10, new RowVictoryChecker(5, false));
        game.createPlayer(new RandomInputProvider(), "bot1", 'x');
        game.createPlayer(new RandomInputProvider(), "bot2", 'o');
        game.createPlayer(new RandomInputProvider(), "bot3");
        runGame(game, new ConsoleFieldTurnLogger(), false);

        game = new Game(11, 11, new RowVictoryChecker(4, true));
        game.createPlayer(new RandomInputProvider(), "bot1");
        game.createPlayer(new RandomInputProvider(), "bot2");
        game.createPlayer(new RandomInputProvider(), "bot3");
        game.createPlayer(new ConsoleInputProvider(), "HUMAN???!!!", 'x');
        runGame(game, new ConsoleTurnLogger(), false);

        game = new Game(20, 20, new RowVictoryChecker(4, true));
        game.createPlayer(new RandomInputProvider(), "bot1", 'o');
        game.createPlayer(new RandomInputProvider(), "bot2", 'x');
        game.createPlayer(new RandomInputProvider(), "bot3", '*');
        game.createPlayer(new RandomInputProvider(), "bot4", 'u');
        game.createPlayer(new RandomInputProvider(), "bot5", 'f');
        game.createPlayer(new RandomInputProvider(), "bot6", 's');
        runGame(game, new ConsoleFieldTurnLogger(), false);
    }

    public static void runGame(Game game, IGameLogger logger, boolean awaitEachTurn) {
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
