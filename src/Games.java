import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;


class games {
    static Scanner sc = new Scanner(in);

    public static boolean main(int choice) {
        boolean winner = false;
        if (choice == 1) winner = playGame();
        else if (choice == 2) learnGame();
        else compliments();
        out.println("Do you want to choose a new game?<y for yes, n for no>");
        return sc.next().charAt(0) == ('y');
    }

    private static boolean learnGame() {
        out.println("""
                Choose 1 to learn about a wordle style game
                Choose 2 to learn about number guessing
                Choose 3 to learn about nim
                Choose 4 to learn about tic tac toe
                Choose 0 to quit
                """);
        int choice = sc.nextInt();
        switch (choice) {
            case 0 -> out.println("Quitting");
            case 1 -> out.println("Wordle is...");
            case 2 -> out.println("Number guessing is...");
            case 3 -> out.println("Hangman is...");
            case 4 -> out.println("Nim is...");
            case 5 -> out.println("Tic Tac Toe is...");
            default -> out.println("Invalid choice");
        }
        return true;
    }

    private static boolean playGame() {
        out.println("I have a few game options, pick which you would like to play");
        out.println("""
                Choose 1 for a wordle style game
                Choose 2 for number guessing
                Choose 3 for nim
                Choose 4 for tic tac toe
                Choose 0 to quit""");
        switch (sc.nextInt()) {
            case 1: return Wordle.main();
            case 2: return NumberGuess.main();
            case 3: return nim.main();
            case 4: return tictac.main();
            default: break;
        }
        out.println("You chose to quit");
        return false;
    }

    private static void compliments() {
        Random r = new Random();
        out.println("Compliments are hard to come by, here's some cheer for you :) ");
        String[] compliments = {"", ""};
        out.println(compliments[r.nextInt(compliments.length)-1]);
    }
}