/**
 * Created by Drobor on 19.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        GameRunner game = new GameRunner();
        game.setupGame();
        String input = "";
        while (!input.equals("bench") && !input.equals("play")) {
            System.out.println("type \"bench\" to test players multiple times or \"play\" to run the game once");
        }
        if (input.equals("bench")) {
            game.testPlayers(10000);
        } else {
            game.runGame(false);
        }
    }

}
