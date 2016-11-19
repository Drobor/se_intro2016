/**
 * Created by m295- on 19.11.2016.
 */
public class ConsoleInputProvider implements IInputProvider {
    public Point getMove(IField field) {
        for (int y = 0; y < field.getSizeY(); y++) {
            for (int x = 0; x < field.getSizeX(); x++) {
                Player curPlayer = field.get(x, y);
                if (curPlayer == null)
                    System.out.print("  ");
                else
                    System.out.print(curPlayer.getPlayerChar() + " ");
            }
            System.out.println();
        }
        System.out.println("Enter your turn coordinates (starting at zero) divided by space or newline");
        int x = readInt();
        int y = readInt();
        return new Point(x, y);
    }

    int readInt() {
        int x = 0;
        try {
            for (int c = System.in.read(); c != 10 && c != 13 && c != 32; c = System.in.read())
                x = x * 10 + c - 48;
        } catch (Exception ex) {
            System.out.println("wrong input");
            return -1;
        }
        return x;
    }
}
