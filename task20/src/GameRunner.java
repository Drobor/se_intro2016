import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by m295- on 24.11.2016.
 */
public class GameRunner {
    private Game game;
    private Scanner sc = new Scanner(System.in);
    private IGameLogger logger;

    public void testPlayers(int matchesCount) {
        int draws = 0;
        HashMap<Player, Integer> victorysCount = new HashMap<>();
        for (int i = 0; i < matchesCount; i++) {
            this.game.clearField();
            TurnResult turn;
            for (turn = game.makeTurn(); !turn.getGameState().gameEnded(); turn = game.makeTurn()) {
                this.logger.log(this.game.getField(), turn);
            }
            if (turn.getGameState().getIsDraw()) {
                draws++;
            } else {
                Player winner = turn.getGameState().getWinner();
                if (victorysCount.containsKey(winner)) {
                    victorysCount.put(winner, victorysCount.get(winner) + 1);
                } else {
                    victorysCount.put(winner, 1);
                }
            }
        }
        System.out.println("Draws:" + draws);
        for (Map.Entry<Player, Integer> score : victorysCount.entrySet()) {
            System.out.println("Player " + score.getKey().toString() + " won " + score.getValue() + " times");
        }
        System.out.println();
    }

    public void runGame(boolean awaitEachTurn) {
        this.game.clearField();
        TurnResult turn;
        for (turn = this.game.makeTurn(); !turn.getGameState().getIsDraw() && turn.getGameState().getWinner() == null; turn = this.game.makeTurn()) {
            this.logger.log(this.game.getField(), turn);
            if (awaitEachTurn) {
                try {
                    for (int c = System.in.read(); c != 10 && c != 13; c = System.in.read()) {
                    }
                } catch (Exception ex) {
                    //Should do something here. Though nothing should be fine. Hopefully
                }
            }
        }
        this.logger.log(this.game.getField(), turn);
        if (awaitEachTurn) {
            try {
                for (int c = System.in.read(); c != 10 && c != 13; c = System.in.read()) {
                }
            } catch (Exception ex) {
                //Should do something here. Though nothing should be fine. Hopefully
            }
        }
    }

    public void setupGame() {
        Point fieldSize = getFieldSize();
        IVictoryChecker ruleSet = getRuleSet();

        this.game = new Game(fieldSize.getX(), fieldSize.getY(), ruleSet);
        this.logger = getLogger();

        for (boolean atLeastOnePlayer = false; !atLeastOnePlayer; ) {
            for (IInputProvider player = getPlayer(); player != null; player = getPlayer()) {
                this.game.createPlayer(player, getPlayerName());
                atLeastOnePlayer = true;
            }
        }
    }

    public void createDefaultBench() {
        this.game = new Game(3, 3, new RowVictoryChecker(3, true));
        this.logger = new DummyLogger();
        this.game.createPlayer(new RandomBotInputProvider(), "bot1", 'x');
        this.game.createPlayer(new RandomBotInputProvider(), "bot2", 'o');
    }

    private IVictoryChecker getRuleSet() {
        System.out.println("Type \"ticktacktoe\" for ticktacktoe rule set\nor\n\"connected\" for rule set in which winner is a player who has largest connected area of points");
        String temp = this.sc.nextLine().trim().toLowerCase();
        if (temp.equals("ticktacktoe")) {
            System.out.println("type in row length required for victory");
            int rowLength = Integer.parseInt(this.sc.nextLine());
            System.out.println("type \"true\" to accept diagonal rows as victory diagonals \nor\n \"false\" to ignore diagonals");
            boolean diagonals = Boolean.parseBoolean(this.sc.nextLine());
            return new RowVictoryChecker(rowLength, diagonals);
        } else if (temp.equals("connected")) {
            return new MostConnectedVictoryChecker();
        }
        System.out.println("wrong input. Repeat");
        return getRuleSet();
    }

    private Point getFieldSize() {
        System.out.println("type in field width and height in one line divided with space");
        int width = this.sc.nextInt();
        int height = Integer.parseInt(this.sc.nextLine().trim());
        return new Point(width, height);
    }

    private IInputProvider getPlayer() {
        System.out.println("type in \"random\" to add bot who will commit turns randomly \nor\n\"close\" to add bot who will try to commit turns on cells close to his already owned cells\nor\n\"human\" to add human player\nor\n\"enough\" to stop adding players and start the game");
        String temp = this.sc.nextLine().trim().toLowerCase();
        if (temp.equals("random")) // switch .. case should have been here
        {
            return new RandomBotInputProvider();
        }
        if (temp.equals("close")) {
            return new NeighbourBotInputProvider();
        }
        if (temp.equals("human")) {
            return new ConsoleInputProvider();
        }
        if (temp.equals("enough")) {
            return null;
        }
        System.out.println("wrong input. Repeat");
        return getPlayer();
    }

    private String getPlayerName() {
        System.out.println("enter player name");
        return this.sc.nextLine();
    }

    private IGameLogger getLogger() {
        System.out.println("type in \"t\" to print all turns \nor\n\"f\" to print field after each turn\nor\n\"tf\" to print both turns and field after turn\nor\n\"none\" to print nothing at all (this doesn't affect human player output)");
        String temp = this.sc.nextLine().trim().toLowerCase();
        if (temp.equals("t")) // switch .. case should have been here
        {
            return new ConsoleTurnLogger();
        }
        if (temp.equals("f")) {
            return new ConsoleFieldLogger();
        }
        if (temp.equals("tf")) {
            return new ConsoleFieldTurnLogger();
        }
        if (temp.equals("none")) {
            return new DummyLogger();
        }
        System.out.println("wrong input. Repeat");
        return getLogger();
    }
}
