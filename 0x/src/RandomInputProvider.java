import java.util.Random;

/**
 * Created by Drobor on 19.11.2016.
 */
public class RandomInputProvider implements IInputProvider {
    private Random rnd = new Random();

    public Point getMove(IField field) {
        int x = rnd.nextInt(field.getSizeX());
        int y = rnd.nextInt(field.getSizeY());
        while (!field.isEmpty(x, y)) {
            x = rnd.nextInt(field.getSizeX());
            y = rnd.nextInt(field.getSizeY());
        }
        return new Point(x, y);
    }
}
