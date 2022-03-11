import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

class main {
    public static void main() {
        Scanner sc = new Scanner(in);
        System.out.println("This is nim, press 1 if you want to know how to play");
        if(sc.next().equalsIgnoreCase("y")) out.println("""
                A game of nim starts with a randomly generated number of stones
                To play, you may remove anywhere from 1-3 stones on your turn
                This game will be played as misere, meaning that the player to draw last will lose
                This means that to win, all you have to do is make the computer draw the last stone
                Good luck, the computer is smart :)
                """);
    }
}
class nim {

    static boolean main() {
        Random r = new Random();
        out.println("To play nim, simply have the computer pick the last set of stones, you may pull 1, 2, or 3 stones. Beware, the computer is smart");
        int stones = r.nextInt(16) + 15;
        do {
            stones -= nimCPUTurn(stones);
            if (stones > 0) stones -= nimUserTurn(stones);
            else {
                out.println("You win");
                return true;
            }
        } while (stones > 0);
        return false;
    }

    private static int nimUserTurn(int stones) {
        Scanner sc = new Scanner(in);
        int user;
        do {
            user = sc.nextInt();
            if ((user > 3 || user < 1) || user > stones) {
                out.println("That value is not between 1 and 3, or is greater than available stones, try again");
            }
        } while (user > 3 || user < 0);
        return user;
    }

    private static int nimCPUTurn(int stones) {
        Random r = new Random();
        int CPU = r.nextInt(4);
        return switch (stones) {
            case 1, 2, 6, 10, 14, 18, 22, 26, 30 -> 1;
            case 3, 7, 11, 15, 19, 23, 27 -> 2;
            case 4, 8, 12, 16, 20, 24, 28 -> 3;
            default -> CPU;
        };
    }
}