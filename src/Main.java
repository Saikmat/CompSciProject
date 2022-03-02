import static java.lang.System.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(in);

    public static void main(String[] args) {
        out.println("Welcome to console games");
        int options;
        boolean flag;
        do {
            options = intro();
            flag = games.main(options);
        } while(!flag);
        if(games.main(options)) out.println("Wow you played 10+ rounds of games, that's a lot");
        else out.println("Thanks for playing, hope to see you back soon");

    }

    public static int intro() {
        System.out.println("""
                if you want to play a game press 1
                if you want to explore the games, press 2
                if you want a compliment, press 3(be warned the computer isn't always nice)
                """);

        return sc.nextInt();
    }
}

class games {
    static Scanner sc = new Scanner(in);

    public static boolean main(int choice) {
        boolean winner = false;
        if (choice == 1) winner = playGame();
        else if (choice == 2) learnGame();
        else compliments();
        out.println("Do you want to choose a new game?<y for yes, n for no>");
        return sc.next().equalsIgnoreCase("y");
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


static class numberGuess {
    private static boolean main() {


        return true;
    }
}
    private static boolean hangman() {


        return true;
    }



    private static boolean tictac(){

        return true;
    }

    private static void compliments() {
        Random r = new Random();
        out.println("Compliments are hard to come by, here's some cheer for you :) ");
        String[] compliments = {"", ""};
        out.println(compliments[r.nextInt(compliments.length)-1]);
    }
}