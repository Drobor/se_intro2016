/**
 * Created by Drobor on 19.11.2016.
 */
public class RowVictoryChecker implements IVictoryChecker {
    private int rowLength = 0;
    private boolean checkDiagonals;

    public RowVictoryChecker(int rowLength, boolean checkDiagonals) {
        this.rowLength = rowLength;
        this.checkDiagonals = checkDiagonals;
    }

    public GameState check(IField field) {
        GameState returns;
        for (int sx = 0; sx <= field.getSizeX() - this.rowLength; sx++) {//shift by X from the up left corner
            for (int sy = 0; sy <= field.getSizeY() - this.rowLength; sy++) {
                if (!((returns = checkHorizontalVertical(field, sx, sy)) == null)) {
                    return returns;
                }
                if (this.checkDiagonals && (!((returns = checkDiagonals(field, sx, sy)) == null))) {
                    return returns;
                }
            }
        }
        return isDraw(field);
    }

    private GameState isDraw(IField field) {
        for (int x = 0; x < field.getSizeX(); x++) {
            for (int y = 0; y < field.getSizeY(); y++) {
                if (field.isEmpty(x, y)) {
                    return new GameState(false);
                }
            }
        }
        return new GameState(true);
    }

    private GameState checkDiagonals(IField field, int sx, int sy) {
        int upRightCorner = sy + this.rowLength - 1;
        Player d1Player = field.get(sx, sy);
        Player d2Player = field.get(sx, upRightCorner);
        for (int i = 1; i < this.rowLength; i++) {
            if (!(d1Player == field.get(sx + i, sy + i))) {
                d1Player = null;
            }
            if (!(d2Player == field.get(sx + i, upRightCorner - i))) {
                d2Player = null;
            }
        }
        if (!(d1Player == null)) {
            return new GameState(d1Player);
        }
        if (!(d2Player == null)) {
            return new GameState(d2Player);
        }
        return null;
    }

    private GameState checkHorizontalVertical(IField field, int sx, int sy) {
        for (int x = 0; x < this.rowLength; x++) {
            Player curPlayer = field.get(sx + x, sy);

            for (int y = 1; y < this.rowLength; y++) {
                if (!(curPlayer == field.get(sx + x, sy + y))) {
                    curPlayer = null;
                }
            }

            if (!(curPlayer == null)) {
                return new GameState(curPlayer);
            }

            curPlayer = field.get(sx, sy + x);

            for (int y = 1; y < this.rowLength; y++) {
                if (!(curPlayer == field.get(sx + y, sy + x))) {
                    curPlayer = null;
                }
            }

            if (!(curPlayer == null)) {
                return new GameState(curPlayer);
            }
        }
        return null;
    }
}