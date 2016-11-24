/**
 * Created by m295- on 19.11.2016.
 */
public class ConsoleFieldTurnLogger implements IGameLogger {
    private ConsoleFieldLogger fieldLogger = new ConsoleFieldLogger();
    private ConsoleTurnLogger turnLogger = new ConsoleTurnLogger();

    public void Log(Game game, TurnResult turnResult) {
        this.turnLogger.Log(game, turnResult);
        this.fieldLogger.Log(game, turnResult);

    }
}
