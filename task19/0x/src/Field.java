/**
 * Created by Drobor on 19.11.2016.
 */
public class Field extends ReadOnlyField implements IField {

    Field(int fieldSizeX, int fieldSizeY) {
        super(fieldSizeX, fieldSizeY);
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
        this.field[x][y] = val;
    }

    public ReadOnlyField getSafeAccessField() {//just converting to readonly interface isnt hardcore enough protection
        return new ReadOnlyField(this.field);
    }
}
