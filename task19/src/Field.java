/**
 * Created by Drobor on 19.11.2016.
 */
public class Field extends ReadOnlyField implements IField {
    private ReadOnlyField safeAccess;

    Field(int fieldSizeX, int fieldSizeY) {
        super(fieldSizeX, fieldSizeY);
        this.safeAccess = new ReadOnlyField(this.field, this.pointPos, this.emptyCells);
    }

    public int getSizeX() {
        return this.field.length;
    }

    public Player get(int x, int y) {
        return this.field[x][y];
    }

    public boolean isEmpty(int x, int y) {
        return this.field[x][y] == null;
    }

    public void set(int x, int y, Player val) {
        Point pt = new Point(x, y);
        int pos = this.pointPos.remove(pt);

        this.emptyCells.set(pos, this.emptyCells.get(this.emptyCells.size() - 1));
        this.pointPos.put(this.emptyCells.get(pos), pos);
        this.emptyCells.remove(this.emptyCells.size() - 1);

        this.field[x][y] = val;
    }

    public ReadOnlyField getSafeAccessField() {//just converting to readonly interface isnt hardcore enough protection
        return this.safeAccess;
    }
}
