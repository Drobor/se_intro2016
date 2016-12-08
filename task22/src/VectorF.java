/**
 * Created by Drobor on 06.12.2016.
 */
public class VectorF {
    private final float[] arr;

    public VectorF(final int size) {
        arr = new float[size];
    }

    public void set(final int pos, final float val) {
        arr[pos] = val;
    }

    public float get(final int pos) {
        return arr[pos];
    }

    public int getSize() {
        return arr.length;
    }

    public VectorF add(final VectorF vector) {
        if (vector.getSize() != getSize()) {
            throw new RuntimeException("Vectors dimensions do not match!");
        }
        VectorF result = new VectorF(arr.length);
        for (int i = 0; i < arr.length; i++) {
            result.set(i, arr[i] + vector.get(i));
        }
        return result;
    }

    public VectorF sub(final VectorF vector) {
        if (vector.getSize() != getSize()) {
            throw new RuntimeException("Vectors dimensions do not match!");
        }
        VectorF result = new VectorF(arr.length);
        for (int i = 0; i < arr.length; i++) {
            result.set(i, arr[i] - vector.get(i));
        }
        return result;
    }

    public VectorF mul(final VectorF vector) {
        if (vector.getSize() != getSize()) {
            throw new RuntimeException("Vectors dimensions do not match!");
        }
        VectorF result = new VectorF(arr.length);
        for (int i = 0; i < arr.length; i++) {
            result.set(i, arr[i] * vector.get(i));
        }
        return result;
    }

    public VectorF div(final VectorF vector) {
        if (vector.getSize() != getSize()) {
            throw new RuntimeException("Vectors dimensions do not match!");
        }
        VectorF result = new VectorF(arr.length);
        for (int i = 0; i < arr.length; i++) {
            result.set(i, arr[i] / vector.get(i));
        }
        return result;
    }

    public VectorF mul(final float val) {
        VectorF result = new VectorF(arr.length);
        for (int i = 0; i < arr.length; i++) {
            result.set(i, arr[i] * val);
        }
        return result;
    }

    public VectorF div(final float val) {
        VectorF result = new VectorF(arr.length);
        for (int i = 0; i < arr.length; i++) {
            result.set(i, arr[i] / val);
        }
        return result;
    }

    public float length() {
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * arr[i];
        }
        return (float) Math.sqrt(sum);
    }

    public VectorF normal() {
        return div(length());
    }

    public float mulScalar(final VectorF vector) {
        if (vector.getSize() != getSize()) {
            throw new RuntimeException("Vectors dimensions do not match!");
        }
        VectorF mul = mul(vector);
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += mul.arr[i];
        }
        return sum;
    }

    public static VectorF mulVector(final VectorF... vector) {
        final int dim = vector[0].getSize();


        if (vector.length != dim - 1) {
            throw new RuntimeException("Vector product requires n-1 vectors where n is dimension of vectors");
        }
        for (int i = 1; i < vector.length; i++) {
            if (vector[i].getSize() != dim) {
                throw new RuntimeException("Vectors dimensions do not match!");
            }
        }

        SquareMatrixF mulMatrix = new SquareMatrixF(dim);
        for (int x = 0; x < dim; x++) {
            mulMatrix.set(x, 0, 1);
        }
        for (int y = 1; y < dim; y++) {
            for (int x = 0; x < dim; x++) {
                mulMatrix.set(x, y, vector[y - 1].get(x));
            }
        }

        VectorF returns = new VectorF(dim);
        SquareMatrixF[] vectorVals = mulMatrix.reduce();
        for (int i = 0; i < dim; i += 2) {
            returns.set(i, vectorVals[i].determinant());
        }
        for (int i = 1; i < dim; i += 2) {
            returns.set(i, -vectorVals[i].determinant());
        }
        return returns;
    }

    public String toString() {
        if (getSize() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sb.append(' ').append(arr[i]);
        }
        return sb.append('}').toString();
    }
}
