import java.util.List;

/**
 * Created by Drobor on 19.11.2016.
 */
public interface IField {
    Player get(int x, int y);
    List<Point> getEmptyCells();
    boolean isEmpty(int x, int y);
    boolean hasEmpty();
    int getSizeX();
    int getSizeY();
    String print();
}
