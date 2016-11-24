/**
 * Created by m295- on 19.11.2016.
 */
public class ConsoleFieldLogger implements IGameLogger {
    public void log(IField field, TurnResult lastTurn) {
        System.out.print(field.print());
    }
}
