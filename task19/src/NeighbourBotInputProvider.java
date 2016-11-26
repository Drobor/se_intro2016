import java.util.*;

/**
 * Created by m295- on 19.11.2016.
 */
class NeighbourBotInputProvider extends RandomBotInputProvider implements IInputProvider {
    private ArrayList<Point> myPoints = new ArrayList<>();
    private Point[] moveOptions = new Point[9];//cuz creating array each move is GC abusive
    private Random rnd = new Random();

    public Point getMove(IField field) {
        while (!this.myPoints.isEmpty()) {
            int optionsCount = 0;
            int pointPos = this.rnd.nextInt(this.myPoints.size());

            Point point = this.myPoints.get(pointPos);
            int x = point.getX();
            int y = point.getY();

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (canMoveHere(x + dx, y + dy, field)) {
                        this.moveOptions[optionsCount++] = new Point(x + dx, y + dy);
                    }
                }
            }

            if (optionsCount > 0) {
                Point move = this.moveOptions[this.rnd.nextInt(optionsCount)];
                this.myPoints.add(move);
                return move;
            } else {
                this.myPoints.set(pointPos, this.myPoints.get(this.myPoints.size() - 1));
                this.myPoints.remove(this.myPoints.size() - 1);
            }
        }
        Point move = super.getMove(field);
        this.myPoints.add(move);
        return move;
    }

    private boolean canMoveHere(int x, int y, IField field) {
        if (x >= 0 && y >= 0 && x < field.getSizeX() && y < field.getSizeY()) {
            return field.isEmpty(x, y);
        }
        return false;
    }
}

