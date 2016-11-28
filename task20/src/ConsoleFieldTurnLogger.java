/**
 * Created by m295- on 19.11.2016.
 */
public class ConsoleFieldTurnLogger implements IGameLogger {
    private ConsoleFieldLogger fieldLogger = new ConsoleFieldLogger();
    private ConsoleTurnLogger turnLogger = new ConsoleTurnLogger();

    public void log(IField field, TurnResult turnResult) {
        this.turnLogger.log(field, turnResult);
        this.fieldLogger.log(field, turnResult);
    }
}
