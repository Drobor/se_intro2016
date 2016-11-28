public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        return "(" + Integer.toString(this.x) + "; " + Integer.toString(this.y) + ")";
    }


    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point pt = (Point) obj;
            return pt.x == this.x && pt.y == this.y;
        }
        return this == obj;
    }

    public int hashCode() {
        return Integer.hashCode(x) ^ Integer.hashCode(y);
    }

}