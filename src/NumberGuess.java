import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;

public class NumberGuess {
    public static boolean main() {
        Random r = new Random();
        Scanner sc = new Scanner(in);
        int CPU = r.nextInt(1000);
        System.out.println("The goal of this game is to guess the number that the computer generates, you have 7 guesses to get it");
        System.out.println("Guess a number from 1-1000");
        for( int guesses = 0; guesses < 7; guesses++){
            int user = sc.nextInt();
            if(user == CPU){
                System.out.println("You guessed it!");
                System.out.println("It took you " + guesses + " guesses to get it");
                return true;
            }
            if((guesses > 4) && CPU > user) System.out.println("Guess a higher number");
            if((guesses > 4) && CPU < user) System.out.println("Guess a lower number");
        }
        System.out.println("You didn't get it :(");
        return false;
    }
}
