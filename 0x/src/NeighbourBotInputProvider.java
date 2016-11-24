import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by m295- on 19.11.2016.
 */
public class NeighbourBotInputProvider extends RandomInputProvider implements IInputProvider {
    private HashSet<Point> myFreePoints = new HashSet<>();

    public Point getMove(IField field) {
        ArrayList<Point> removePoints=new ArrayList<Point>();
        for (Point myPt: myFreePoints)
            for(int dx=-1;dx<=1;dx++)
                for(int dy=-1;dy<=1;dy++)
                    if(canMoveHere)

        super.getMove(field);
    }
    boolean canMoveHere(Point point, IField field)
    {
        if(point.getX()>==&&point.getY()>=0&&point)
    }
}

