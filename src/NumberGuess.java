import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;

public class NumberGuess {
    public static int main() {
        Random r = new Random();
        Scanner sc = new Scanner(in);
        int CPU = r.nextInt(1000);
        System.out.println("The goal of this game is to guess the number that the computer generates, you have 10 guesses to get it");
        System.out.println("Guess a number from 1-1000");
        int[] userGuesses = new int[10];
        for( int guesses = 0; guesses < 10; guesses++){
            int user = sc.nextInt();
            userGuesses[guesses] = user;
            if(user == CPU){
                System.out.println("You guessed it!");
                System.out.println("It took you " + guesses + " guesses to get it");
                System.out.println("Your guesses were " + Arrays.toString(userGuesses));
                return 0;
            }
            if(CPU > user){
                System.out.println("Guess a higher number");
            }
            if(CPU < user){
                System.out.println("Guess a lower number");
            }
        }
        System.out.println("You didn't get it :(");
        System.out.println("The number was " + CPU);
        return 1;
    }
}
