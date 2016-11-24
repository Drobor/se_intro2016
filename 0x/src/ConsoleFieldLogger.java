/**
 * Created by m295- on 19.11.2016.
 */
public class ConsoleFieldLogger implements IGameLogger {
    public void Log(Game game, TurnResult lastTurn) {
        System.out.print(game.getField().print());
    }
}
