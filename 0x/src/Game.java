import java.util.*;

public class Game {

    int curPlayer; //can i add new players after game starts?
    private ArrayList<Player> players = new ArrayList<Player>();
    private HashSet<Character> usedChars = new HashSet<Character>();
    private Field field;
    private IVictoryChecker victoryChecker;
    private char curAutoChar = '0';

    public Game(int fieldSizeX, int fieldSizeY, IVictoryChecker victoryChecker) {
        usedChars.add((char) 0);
        field = new Field(fieldSizeX, fieldSizeY);
        this.victoryChecker = victoryChecker;
    }

    public Player createPlayer(IInputProvider IInputProvider, String playerName, char playerChar) { //think about possible bug caused by weird unicode chars
        if (usedChars.add(playerChar)) {
            Player player = new Player(playerChar, IInputProvider, playerName);
            players.add(player);
            return player;
        } else
            return null;
    }

    public Player createPlayer(IInputProvider IInputProvider, String playerName) {
        if (curAutoChar > 30000)
            return null;
        if (curAutoChar == '9')
            curAutoChar = 'A';
        for (curAutoChar++; !usedChars.add(curAutoChar); curAutoChar++) ;
        Player player = new Player(curAutoChar, IInputProvider, playerName);
        players.add(player);
        return player;
    }

    public TurnResult makeTurn() {
        Player player = players.get(curPlayer);
        Point move = player.getMove(field.getSafeAccessField());
        boolean isMoveValid = false;
        if (!field.isEmpty(move.getX(), move.getY())) {
            players.remove(curPlayer);
        } else {
            curPlayer++;
            isMoveValid = true;
            field.set(move.getX(), move.getY(), player);
        }

        curPlayer %= players.size();
        return new TurnResult(player, move, isMoveValid, victoryChecker.check(field));
    }

    public IField getField() {
        return field.getSafeAccessField();
    }
}



