/**
 * Created by Drobor on 19.11.2016.
 */
public class ReadOnlyField implements IField {
    protected Player[][] field;

    public ReadOnlyField(Player[][] field) {
        this.field = field;
    }

    public ReadOnlyField(int fieldSizeX, int fieldSizeY) {
        if (fieldSizeX < 1 || fieldSizeY < 1)
            throw new RuntimeException("impossible field parameters");
        this.field = new Player[fieldSizeX][fieldSizeY];
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
        for (int x = 0; x < field.length; x++)
            for (int y = 0; y < field[0].length; y++)
                if (field[x][y] == null)
                    return true;
        return false;
    }

    public Player get(int x, int y) {
        return this.field[x][y];
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        int fieldMarksSize = (int) Math.log10(Math.max(getSizeX(), getSizeY())) + 2;

        for (int i = 0; i < fieldMarksSize + 2; i++)
            sb.append(' ');

        for (int x = 0; x < getSizeX(); x += 2) {
            String idx = Integer.toString(x);
            sb.append(idx);
            for (int i = 0; i < 4 - idx.length(); i++)
                sb.append(' ');
        }
        sb.append('\n');
        for (int i = 0; i < fieldMarksSize + 2 + getSizeX() * 2; i++)
            sb.append('-');
        sb.append("\n");

        for (int y = 0; y < getSizeY(); y++) {
            String idx = Integer.toString(y);
            sb.append(idx);
            for (int i = 0; i < fieldMarksSize - idx.length(); i++)
                sb.append(' ');
            sb.append("| ");
            for (int x = 0; x < getSizeX(); x++) {
                Player curPlayer = get(x, y);
                if (curPlayer == null)
                    sb.append("  ");
                else
                    sb.append(curPlayer.getPlayerChar() + " ");
            }
            sb.append('\n');
        }

        for (int i = 0; i < fieldMarksSize + 2 + getSizeX() * 2; i++)
            sb.append('-');
        sb.append("\n");
        for (int i = 0; i < fieldMarksSize + 4; i++)
            sb.append(' ');
        for (int x = 1; x < getSizeX(); x += 2) {
            String idx = Integer.toString(x);
            sb.append(idx);
            for (int i = 0; i < 4 - idx.length(); i++)
                sb.append(' ');
        }
        sb.append('\n');

        return sb.toString();
    }
}
