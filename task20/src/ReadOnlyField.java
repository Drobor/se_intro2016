import java.util.*;

/**
 * Created by Drobor on 19.11.2016.
 */
public class ReadOnlyField implements IField {
    protected Player[][] field;
    protected HashMap<Point, Integer> pointPos = new HashMap<>();
    protected ArrayList<Point> emptyCells = new ArrayList<>();
    private List<Point> safeAccessEmptyCells;

    public ReadOnlyField(Player[][] field, HashMap pointPos, ArrayList emptyCells) {
        this.field = field;
        this.emptyCells = emptyCells;
        this.pointPos = pointPos;
        this.safeAccessEmptyCells = Collections.unmodifiableList(emptyCells);
    }

    public ReadOnlyField(int fieldSizeX, int fieldSizeY) {
        if (fieldSizeX < 1 || fieldSizeY < 1) {
            throw new RuntimeException("impossible field parameters");
        }
        this.field = new Player[fieldSizeX][fieldSizeY];
        init();
    }

    private void init() {
        int pos = 0;
        for (int x = 0; x < getSizeX(); x++) {
            for (int y = 0; y < getSizeY(); y++) {
                Point pt = new Point(x, y);
                this.emptyCells.add(pt);
                this.pointPos.put(pt, pos++);
            }
        }
        this.safeAccessEmptyCells = Collections.unmodifiableList(this.emptyCells);
    }

    public int getSizeX() {
        return this.field.length;
    }

    public int getSizeY() {
        return this.field[0].length;
    }

    public boolean isEmpty(int x, int y) {
        return this.field[x][y] == null;
    }

    public boolean hasEmpty() {
        for (int x = 0; x < this.field.length; x++) {
            for (int y = 0; y < this.field[0].length; y++) {
                if (this.field[x][y] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Point> getEmptyCells() {
        return safeAccessEmptyCells;
    }

    public Player get(int x, int y) {
        return this.field[x][y];
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        int fieldMarksSize = (int) Math.log10(Math.max(getSizeX(), getSizeY())) + 2;

        for (int i = 0; i < fieldMarksSize + 2; i++) {
            sb.append(' ');
        }

        for (int x = 0; x < getSizeX(); x += 2) {
            String idx = Integer.toString(x);
            sb.append(idx);
            for (int i = 0; i < 4 - idx.length(); i++) {
                sb.append(' ');
            }
        }
        sb.append('\n');
        for (int i = 0; i < fieldMarksSize + 2 + getSizeX() * 2; i++) {
            sb.append('-');
        }
        sb.append("\n");

        for (int y = 0; y < getSizeY(); y++) {
            String idx = Integer.toString(y);
            sb.append(idx);
            for (int i = 0; i < fieldMarksSize - idx.length(); i++) {
                sb.append(' ');
            }
            sb.append("| ");
            for (int x = 0; x < getSizeX(); x++) {
                Player curPlayer = get(x, y);
                if (curPlayer == null) {
                    sb.append("  ");
                } else {
                    sb.append(curPlayer.getPlayerChar() + " ");
                }
            }
            sb.append('\n');
        }

        for (int i = 0; i < fieldMarksSize + 2 + getSizeX() * 2; i++) {
            sb.append('-');
        }
        sb.append("\n");
        for (int i = 0; i < fieldMarksSize + 4; i++) {
            sb.append(' ');
        }
        for (int x = 1; x < getSizeX(); x += 2) {
            String idx = Integer.toString(x);
            sb.append(idx);
            for (int i = 0; i < 4 - idx.length(); i++) {
                sb.append(' ');
            }
        }
        sb.append('\n');

        return sb.toString();
    }
}