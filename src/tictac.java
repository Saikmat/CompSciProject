/*
Sai Matukumalli
TicTacToe
3/2/2022
Runs tictactoe and returns if the user won or lost

 */

import java.util.*;

import static java.lang.System.*;

class tictac {
    public static boolean main() {
        Scanner sc = new Scanner(in);
        char symbol = 'x';
        out.println("This is a game of standard 3x3 tic-tac-toe \nGet 3 in a row to win, good luck");
        out.println("To enter your guess, you will enter a \"Coordinate\", where A-C is the row and 1-3 is the column");
        out.println("Here is the board, dashes will be replaced with 'x', or if you want another symbol that you can enter later, computer turns will be 'o' always");
        out.println("""
                |-|-|-|
                |-|-|-|
                |-|-|-|
                """);


        String[][] grid = {{"|", "-|", "-|", "-|"}, {"|", "-|", "-|", "-|"}, {"|", "-|", "-|", "-|"}};
        int[][] CPUgrid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        out.println("If you want to pick a symbol, press y");
        if (sc.next().equalsIgnoreCase("Y")) {
            out.println("Enter the character you want to use, note that input may only be one character");
            out.println("You may not use '-' as your character");
            String str = sc.next();
            symbol = str.charAt(1);
            if (symbol == '-') {
                symbol = 'x';
                out.println("I warned you...Your symbol is now the default 'x'");
            }
        }
        for(int i = 0; i < 9; i++) {
            checkGuess(grid, CPUgrid, symbol);
            out.println(Arrays.deepToString(checkGuess(grid, CPUgrid, symbol)));
            out.println("CPU turn");
            CPUturn(grid, CPUgrid);

        }
        return false;
    }

    public static void CPUturn(String[][] grid, int[][] CPUgrid) {

    }

    private static String[][] checkGuess(String[][] grid, int[][] CPUgrid, char symbol){
        boolean check;
        int let2num = -1;
        char let = 'A';
        int num = 1;
        boolean charCheck = false;
        Scanner sc = new Scanner(in);
        out.println("Enter the CAPITAL letter first, A-C");
        let = sc.next().charAt(0);
        out.println("Now the number, 1-3");

        num = sc.nextInt();

        check = parseInput(let, num, CPUgrid, let2num);

        while(!check) {
            userInput(let, num);
            check = parseInput(let, num, CPUgrid, let2num);
        }


        //update grid
        grid[num][let2num] = String.valueOf(symbol) + "|";
        CPUgrid[num][let2num] = 1;
        return grid;
    }
    private static boolean parseInput(char let, int num, int[][] grid, int let2num){

        if (!((let == 'A') || (let == 'B') || (let == 'C'))) return false;
        switch (let) {
        case 'A' -> let2num = 0;
        case 'B' -> let2num = 1;
        case 'C' -> let2num = 2;
        }
        if (!(num == 1 || num == 2 || num == 3)) return false;
        if (grid[num][let2num] == 1) return false;

        return true;
    }

    public static void userInput(char let, int num){
        Scanner sc = new Scanner(in);
        out.println("That is an invalid input");
        out.println("Enter the letter first, A-C");
        let = sc.next().charAt(0);
        out.println("Now the number, 1-3");
        num = sc.nextInt();
    }
}
