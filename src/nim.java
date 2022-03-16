import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class nim {
    /**
     * Runs the Nim game
     * @return{int} 0 if the user wins and 1 if the user loses
     */
    static int nim() {
        Random r = new Random();
        Scanner sc = new Scanner(in);
        out.println("""
            A game of nim starts with a randomly generated number of stones
            To play, you may remove anywhere from 1-3 stones on your turn
            This game will be played as misere, meaning that the player to draw last will lose
            This means that to win, all you have to do is make the computer draw the last stone
            Good luck, the computer is smart :)
            """);
        int stones = r.nextInt(16) + 15;
        do {
            int CPUdraw = nimCPUTurn(stones);
            stones -= CPUdraw;

            if (stones > 0){
                stones -= nimUserTurn(stones);
            }
            else {
                out.println("You win");
                return 0;
            }
        } while (stones > 0);
        return 1;
    }

    /**
     * Takes user Input for how many stones the user wants to draw, with checking to make sure that only the correct number of stones are drawn.
     * @param stones{int} - The number of stones currently present
     * @return{int} - The number of stones that the user chooses to draw
     */

    private static int nimUserTurn(int stones) {
        Scanner sc = new Scanner(in);
        int user;
        do {
            out.println("There are " + stones + " Stones");
            out.println("Enter the number of stones you would like to draw");
            user = sc.nextInt();
            if ((user > 3 || user < 1) || user > stones) {
                out.println("That value is not between 1 and 3, or is greater than available stones, try again");
            }
        } while (user > 3 || user < 0);
        return user;
    }

    /**
     * Finds the optimal number of stones that the computer must draw to win
     * @param stones{int} - The number of stones currently present
     * @return{int} - The number of stones that the CPU should draw to win.
     */
    private static int nimCPUTurn(int stones) {
        Random r = new Random();
        return switch (stones) {
            case 1, 2, 6, 10, 14, 18, 22, 26, 30 -> 1;
            case 3, 7, 11, 15, 19, 23, 27 -> 2;
            case 4, 8, 12, 16, 20, 24, 28 -> 3;
            default -> r.nextInt(4);
        };
    }
}