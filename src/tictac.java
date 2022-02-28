import java.util.Scanner;

import static java.lang.System.in;

class tictac {
    public static boolean main() {
        Scanner sc = new Scanner(in);
        String symbol = "x";
        System.out.println("This is a game of standard 3x3 tic-tac-toe \nGet 3 in a row to win, good luck");
        System.out.println("To enter your guess, you will enter a \"Coordinate\", where A-C is the column and 1-3 is the row");
        System.out.println("Here is the board, dashes will be replaced with 'x', or if you want another symbol that you can enter later, computer turns will be 'o' always");
        System.out.println("""
                |-|-|-|
                |-|-|-|
                |-|-|-|
                """);
        String[][] grid = {{"|-|-|-|"}, {"|-|-|-|"}, {"|-|-|-|"}};
        System.out.println("If you want to pick a symbol, press y");
        if(sc.next().equalsIgnoreCase("Y")){
            System.out.println("Enter the character you want to use, note that input may only be one character");
            String str = sc.next();
            symbol = str.substring(0,1);
        }
        System.out.println("You go first, enter the letter first, A-C");
        String coordlett = sc.next();
        System.out.println("Now the number, 1-3");
        int coordnum = sc.nextInt();
        checkGuess(coordlett, coordnum, grid);
        return false;
    }

    private static void checkGuess(String let, int num, String[][] grid) {
        if(let.equalsIgnoreCase("A")) System.out.println("needs to be updated");
    }
}
