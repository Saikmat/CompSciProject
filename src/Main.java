import static java.lang.System.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(in);

    public static void main(String[] args) {
        int options = intro();
        if(games.main(options)) out.println("Wow you played 10+ rounds of games, that's a lot");
        else out.println("Thanks for playing, hope to see you back soon");

    }

    public static int intro() {
        System.out.println("Welcome to console games" +
                "\n if you want to play a game press 1" +
                "if you want to explore the games, press 2" +
                "if you want a compliment, press 3(be warned the computer isn't always nice)");

        return sc.nextInt();
    }
}

class games{
    static Scanner sc = new Scanner(in);
    public static void main(int choice){
        boolean user;

        if (choice == 1) {
        playGame();
        } else if (choice == 2) learnGame();
        else {
            compliments();
        }

    }

    private static void learnGame() {
        out.println("Choose 1 to learn about a wordle style game" +
                "Choose 2 to learn about number guessing" +
                "Choose 3 to learn about hangman" +
                "Choose 4 to learn about nim" +
                "Choose 5 to learn about tic tac toe" +
                "Choose 0 to quit");
        int choice = sc.nextInt();
        switch(choice){
            case 0: out.println("Quitting"); break;
            case 1: out.println("Wordle is..."); break;
            case 2: out.println("Number guessing is..."); break;
            case 3: out.println("Hangman is..."); break;
            case 4: out.println("Nim is..."); break;
            case 5: out.println("Tic Tac Toe is..."); break;
            default: out.println("Invalid choice");
        }
    }

    private static boolean playGame() {
        out.println("I have a few game options, pick which you would like to play");
        out.println("Choose 1 for a wordle style game" +
                "Choose 2 for number guessing" +
                "Choose 3 for hangman" +
                "Choose 4 for nim" +
                "Choose 5 for tic tac toe"+
                "Choose 0 to quit");
        switch(sc.nextInt()){
            case 1: return wordle();
            case 2: return numberGuess();
            case 3: return hangman();
            case 4: return nim();
            case 5: return tictac();
            default: break;
        }
        out.println("You chose to quit");
        return false;
    }

    private static boolean wordle() {

    }
    private static boolean numberGuess() {

    }
    private static boolean hangman(){

    }
    private static boolean nim(){
        Random r = new Random();
        out.println("To play nim, simply have the computer pick the last set of stones, you may pull 1, 2, or 3 stones. Beware, the computer is smart");
        int stones = r.nextInt(16)+15;
            do {
            stones -= nimCPUTurn(stones);
            if (stones > 0) stones -= nimUserTurn(stones);
            else {
                out.println("You win");
                return true;
            }
        } while(stones > 0);
        return false;
    }

    private static int nimUserTurn(int stones) {
        Scanner sc = new Scanner(in);
        int user;
        do {
            user = sc.nextInt();
            if (user > 3 || user < 1) {
                out.println("That value is not between 1 and 3, try again");
            }
        } while (user > 3 || user < 0);
        return user;
    }

    private static int nimCPUTurn(int stones){
        Random r = new Random();
        int CPU = r.nextInt();
        switch (stones){
            case 1:
            case 2:
            case 6:
                return 1;
            case 3:
            case 7:
                return 2;
            case 4:
            case 8:
                return 3;
            case 5:
            case 9:
            default:
                return CPU;

        }
    }

    private static boolean tictac(){

    }

    private static void compliments() {
        Random r = new Random();
        out.println("Compliments are hard to come by, here's some cheer for you :) ");
        String[] compliments = {"", ""};
        out.println(compliments[r.nextInt(compliments.length)-1]);
    }
}