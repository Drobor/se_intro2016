/**
 * Created by Drobor on 19.11.2016.
 */
public class Player {
    private char playerChar;
    private IInputProvider inputProvider;
    private String name;

    public Player(char playerChar, IInputProvider IInputProvider, String name) {
        this.playerChar = playerChar;
        this.inputProvider = IInputProvider;
        this.name = name;
    }

    public Point getMove(IField field) {
        return inputProvider.getMove(field);
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + "(" + playerChar + ")";
    }
}
