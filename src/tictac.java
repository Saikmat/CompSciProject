import java.util.*;
import static java.lang.System.*;

class tictac {
    public static boolean main() {
        Scanner sc = new Scanner(in);
        char symbol = 'x';
        System.out.println("This is a game of standard 3x3 tic-tac-toe \nGet 3 in a row to win, good luck");
        System.out.println("To enter your guess, you will enter a \"Coordinate\", where A-C is the row and 1-3 is the column");
        System.out.println("Here is the board, dashes will be replaced with 'x', or if you want another symbol that you can enter later, computer turns will be 'o' always");
        System.out.println("""
                |-|-|-|
                |-|-|-|
                |-|-|-|
                """);


        String[][] grid = {{"|-", "-|", "-|"}, {"|", "-|", "-|", "-|"}, {"|", "-|", "-|", "-|"}};
        System.out.println("If you want to pick a symbol, press y");
        if(sc.next().equalsIgnoreCase("Y")){
            System.out.println("Enter the character you want to use, note that input may only be one character");
            String str = sc.next();
            symbol = str.charAt(1);
        }
        checkGuess(grid, symbol);



        return false;
    }

    private static String[][] checkGuess(String[][] grid, char symbol) {
        Scanner sc = new Scanner(in);
        boolean check;
        int let2num = -1;
        char let;
        int num;
        boolean charCheck = false;
        do {
            do {
                System.out.println("You go first, enter the letter first, A-C");
                let = sc.next().charAt(0);
                System.out.println("Now the number, 1-3");
                num = sc.nextInt();
                check = !(num == 1 || num == 2 || num == 3);
                switch (let) {
                    case 'A' -> let2num = 0;
                    case 'B' -> let2num = 1;
                    case 'C' -> let2num = 2;
                    default -> check = true;
                }
            } while (check);
            if (grid[num][let2num].equals("|-")) charCheck = true;
        } while(charCheck);


        grid[num][let2num] = String.valueOf(symbol);
        return grid;



    }
}
