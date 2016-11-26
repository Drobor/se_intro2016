import java.util.Scanner;

/**
 * Created by Drobor on 19.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        GameRunner game = new GameRunner();
        game.setupGame();
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (!input.equals("bench") && !input.equals("play")) {
            System.out.println("type \"bench\" to test players multiple times or \"play\" to run the game once");
            input = sc.nextLine();
        }
        if (input.equals("bench")) {
            System.out.println("type test runs count");
            game.testPlayers(sc.nextInt());
        } else {
            game.runGame(false);
        }
    }

}
