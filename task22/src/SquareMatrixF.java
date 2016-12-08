/**
 * Created by Drobor on 06.12.2016.
 */
public class SquareMatrixF {
    float[][] arr;

    public SquareMatrixF(final int size) {
        arr = new float[size][size];
    }

    public void set(final int x, final int y, final float val) {
        arr[x][y] = val;
    }

    public float get(final int x, final int y) {
        return arr[x][y];
    }

    public float determinant() {
        if (arr.length == 1) {
            return arr[0][0];
        }
        float returns = 0;
        SquareMatrixF[] reduced = reduce();
        for (int i = 0; i < arr.length; i += 2) {
            returns += arr[i][0] * reduced[i].determinant();
        }
        for (int i = 1; i < arr.length; i += 2) {
            returns -= arr[i][0] * reduced[i].determinant();
        }
        return returns;
    }

    SquareMatrixF[] reduce() {
        SquareMatrixF[] returns = new SquareMatrixF[arr.length];
        for (int i = 0; i < arr.length; i++) {
            returns[i] = new SquareMatrixF(arr.length - 1);
            int curX = 0;
            for (int x = 0; x < arr.length; x++) {
                if (x != i) {
                    for (int y = 1; y < arr.length; y++) {
                        returns[i].arr[curX][y - 1] = arr[x][y];
                    }
                    curX++;
                }
            }
        }
        return returns;
    }
}
