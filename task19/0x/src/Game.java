import java.util.*;

public class Game {

    int curPlayer; //can i add new players after game starts?
    private ArrayList<Player> players = new ArrayList<Player>();
    private HashSet<Character> usedChars = new HashSet<Character>();
    private Field field;
    private IVictoryChecker victoryChecker;
    private char curAutoChar = '0';

    public Game(int fieldSizeX, int fieldSizeY, IVictoryChecker victoryChecker) {
        this.usedChars.add((char) 0);
        this.field = new Field(fieldSizeX, fieldSizeY);
        this.victoryChecker = victoryChecker;
    }

    public Player createPlayer(IInputProvider IInputProvider, String playerName, char playerChar) { //think about possible bug caused by weird unicode chars
        if (this.usedChars.add(playerChar)) {
            Player player = new Player(playerChar, IInputProvider, playerName);
            this.players.add(player);
            return player;
        } else
            return null;
    }

    public Player createPlayer(IInputProvider IInputProvider, String playerName) {
        if (this.curAutoChar > 30000)
            return null;
        if (this.curAutoChar == '9')
            this.curAutoChar = 'A';
        for (this.curAutoChar++; !this.usedChars.add(this.curAutoChar); this.curAutoChar++) ;
        Player player = new Player(this.curAutoChar, IInputProvider, playerName);
        this.players.add(player);
        return player;
    }

    public TurnResult makeTurn() {
        Player player = players.get(curPlayer);
        Point move = player.getMove(this.field.getSafeAccessField());
        boolean isMoveValid = false;
        if (!this.field.isEmpty(move.getX(), move.getY())) {
            this.players.remove(curPlayer);
        } else {
            curPlayer++;
            isMoveValid = true;
            this.field.set(move.getX(), move.getY(), player);
        }

        curPlayer %= this.players.size();
        return new TurnResult(player, move, isMoveValid, this.victoryChecker.check(field));
    }

    public IField getField() {
        return this.field.getSafeAccessField();
    }
}



