import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


class games {
    static Scanner sc = new Scanner(in);

    /**
     * Runs the game selection
     * @param choice{int} - if the user chose to play a game(1), learn about a game(2), or get a compliment(3)
     * @return{boolean} - 0 if the user won, and 1 if the user lost
     */
    public static boolean game(int choice) {
        int winner;
        if (choice == 1){
            winner = playGame();
            if(winner == 0) {
                out.println("You win :)");
            } else if(winner == 1){
                out.println("You lost :{");
            }


        }
        else if (choice == 2) learnGame();
        else compliments();

        out.println("Do you want to choose again?<y for yes, n for no>");
        return sc.next().charAt(0) == ('y');
    }

    /**
     * Prints out what each of the games is, and how to play
     */
    private static void learnGame() {
        out.println("""
                Choose 1 to learn about a wordle style game
                Choose 2 to learn about number guessing
                Choose 3 to learn about nim
                Choose 0 to quit
                """);
        int choice = sc.nextInt();
        switch (choice) {
            case 0 -> out.println("Quitting");
            case 1 -> out.println("Wordle is...");
            case 2 -> out.println("Number guessing is...");
            case 3 -> out.println("Nim is...");
            //case 4 -> out.println("Tic Tac Toe is...");
            default -> out.println("Invalid choice");
        }
    }

    /**
     * Helper method to determine which method the user is to be sent to based on their input
     * @return{int} - 0 if the user won, and 1 if the user lost, 2 if the user quit
     */
    private static int playGame() {
        out.println("I have a few game options, pick which you would like to play");
        out.println("""
                Choose 1 for a wordle style game
                Choose 2 for number guessing
                Choose 3 for nim
                Choose 0 to quit""");
        switch (sc.nextInt()) {
            case 1: return Wordle.main();
            case 2: return NumberGuess.main();
            case 3: return nim.nim();
            //case 4: return TicTac.Tic();
            default: break;
        }
        out.println("You chose to quit");
        return 2;
    }

    /**
     * Generates a random number and prints out a compliment based on that number
     */
    private static void compliments() {
        Random r = new Random();
        out.println("Compliments are hard to come by, here's some cheer for you :) ");
        String[] compliments = {"Your smile is contagious.","    I bet you make babies smile.","    You have the best laugh.","    You light up the room.","    You have a great sense of humor.","    If cartoon bluebirds were real, a couple of 'em would be sitting on your shoulders singing right now.","    You're like sunshine on a rainy day.","    You bring out the best in other people.","    I bet you sweat glitter.","    Colors seem brighter when you're around.","    You're more fun than a ball pit filled with candy.","    Jokes are funnier when you tell them.","    You always know how to find that silver lining.","    You're a candle in the darkness.","    Being around you is like a happy little vacation.","    You're more fun than bubble wrap.","    You're like a breath of fresh air.","    You're someone's reason to smile.","    How do you keep being so funny and making everyone laugh?"};
        out.println(compliments[r.nextInt(compliments.length-1)]);
    }
}