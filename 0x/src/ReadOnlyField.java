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

    public Player get(int x, int y) {
        return this.field[x][y];
    }
}
