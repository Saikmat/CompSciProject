import static java.lang.System.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(in);

    public static void main(String[] args) {
        int options = intro();
        int gameChoice = games.gamesMain(options);

    }

    private static int intro() {
        System.out.println("Welcome to console games" +
                "\n if you want to play a game press 1" +
                "if you want to explore the games, press 2" +
                "if you want a compliment, press 3(be warned the computer isn't always nice)");

        return sc.nextInt();
    }
}

class games{
    static Scanner sc = new Scanner(in);
    public static int gamesMain(int choice){
        if(choice == 1){
            out.println("I have a few game options, pick which you would like to play");
            out.println("Choose 1 for a wordle style game" +
                    "Choose 2 for number guessing" +
                    "Choose 3 for hangman" +
                    "Choose 4 for nim" +
                    "Choose 5 for tic tac toe"+
                    "Choose 0 to quit");
            return sc.nextInt();
        }
        else if(choice == 2){
            out.println("Choose 1 to learn about a wordle style game" +
                    "Choose 2 to learn about number guessing" +
                    "Choose 3 to learn about hangman" +
                    "Choose 4 to learn about nim" +
                    "Choose 5 to learn about tic tac toe" +
                    "Choose 0 to quit");
            return sc.nextInt();
        }
        else{
            compliments();
            return 0;
        }
    }

    private static void compliments() {
        Random r = new Random();
        out.println("Compliments are hard to come by, here's some cheer for you :) ");
        String[] compliments = {"", ""};
        out.println(compliments[r.nextInt(compliments.length)]);
    }
}