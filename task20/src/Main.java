import java.util.Scanner;

/**
 * Created by Drobor on 19.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        GameRunner game = new GameRunner();
        if (args.length >= 1 && args[0].trim().toLowerCase().equals("settings")) {
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
        } else {
            game.createDefaultBench();
            System.out.println("Program has started with default settings (classic ticktacktoe rules ,3x3 field, two random players, 100000 test runs).\nTo specify game settings please run the program with argument \"settings\"\n");
            game.testPlayers(100000);
        }
    }
}
