import java.util.Random;

/**
 * Created by Drobor on 19.11.2016.
 */
public class RandomBotInputProvider implements IInputProvider {
    private Random rnd = new Random();

    public Point getMove(IField field) {
        int x = this.rnd.nextInt(field.getSizeX());
        int y = this.rnd.nextInt(field.getSizeY());
        while (!field.isEmpty(x, y)) {
            x = this.rnd.nextInt(field.getSizeX());
            y = this.rnd.nextInt(field.getSizeY());
        }
        return new Point(x, y);
    }
}


