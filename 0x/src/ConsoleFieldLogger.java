/**
 * Created by m295- on 19.11.2016.
 */
public class ConsoleFieldLogger implements IGameLogger {
    public void Log(Game game, TurnResult lastTurn) {
        IField field = game.getField();
        for (int y = 0; y < field.getSizeY(); y++) {
            for (int x = 0; x < field.getSizeX(); x++) {
                Player curPlayer = field.get(x, y);
                if (curPlayer == null)
                    System.out.print("  ");
                else
                    System.out.print(curPlayer.getPlayerChar() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
