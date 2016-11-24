import java.util.List;
import java.util.Random;

/**
 * Created by Drobor on 19.11.2016.
 */
public class RandomBotInputProvider implements IInputProvider {
    private Random rnd = new Random();

    public Point getMove(IField field) {
        List<Point> emptyCells=field.getEmptyCells();
        return emptyCells.get(rnd.nextInt(emptyCells.size()));
    }
}