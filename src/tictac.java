/*
Sai Matukumalli
TicTacToe
3/2/2022
Runs tictactoe and returns if the user won or lost

 */


import java.util.*;

import static java.lang.System.*;
import static java.util.Arrays.deepToString;

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


        char[][] grid = {{'-', '|', '-', '|', '-'},
                         {'-', '|', '-', '|', '-'},
                         {'-', '|', '-', '|', '-',}};
        int[][] CPUgrid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        out.println("If you want to pick a symbol, press y");
        if (sc.next().equalsIgnoreCase("Y")) {
            out.println("Enter the character you want to use, note that input may only be one character");
            out.println("You may not use '-' or 'o' as your character");
            String str = sc.next();
            symbol = str.charAt(0);
            if (symbol == '-' || symbol == 'o') {
                symbol = 'x';
                out.println("I warned you...Your symbol is now the default 'x'");
            }
        }
        for(int i = 0; i < 9; i++) {
            out.println("User turn");
            out.println(deepToString(userGuess(grid, CPUgrid, symbol)));
            if(checkWin(CPUgrid)) break;
            out.println("CPU turn");
            CPUblock(grid, CPUgrid, symbol);
            out.println(deepToString(grid));
            if(checkWin(CPUgrid)) break;
        }
        return false;
    }

    @SuppressWarnings("RedundantIfStatement")
    private static boolean checkWin(int[][] grid) {
        if     (grid[0][0] == 2 && grid[0][1] == 2 && grid[0][2] == 2) return true;
        else if(grid[1][0] == 2 && grid[1][1] == 2 && grid[1][2] == 2) return true;
        else if(grid[2][0] == 2 && grid[2][1] == 2 && grid[2][2] == 2) return true;
        else if(grid[0][0] == 2 && grid[1][0] == 2 && grid[2][0] == 2) return true;
        else if(grid[0][1] == 2 && grid[1][1] == 2 && grid[2][1] == 2) return true;
        else if(grid[0][2] == 2 && grid[1][2] == 2 && grid[2][2] == 2) return true;
        else if(grid[0][0] == 2 && grid[1][1] == 2 && grid[2][2] == 2) return true;
        else if(grid[0][2] == 2 && grid[1][1] == 2 && grid[2][0] == 2) return true;
        else if(grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1) return true;
        else if(grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1) return true;
        else if(grid[2][0] == 1 && grid[2][1] == 1 && grid[2][2] == 1) return true;
        else if(grid[0][0] == 1 && grid[1][0] == 1 && grid[2][0] == 1) return true;
        else if(grid[0][1] == 1 && grid[1][1] == 1 && grid[2][1] == 1) return true;
        else if(grid[0][2] == 1 && grid[1][2] == 1 && grid[2][2] == 1) return true;
        else if(grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1) return true;
        else if(grid[0][2] == 1 && grid[1][1] == 1 && grid[2][0] == 1) return true;
        else return false;
    }

    /**
     * Finds all the moves that are possible on the board and determines if they are good moves or not
     * @param charGrid {char} - Passes the char grid to the computer so it can be updated
     * @param grid {char} - Passes the char grid to the computer so it can be updated
     */

    public static void CPUblock(char[][] charGrid, int[][] grid, char symbol) {
        Random rd = new Random();
        List<String> spaces= new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i][j] == 0) spaces.add(String.valueOf(i) + j);
            }
        }
        //1 row protection
        if     (grid[0][0] == 2 && grid[0][1] == 2 && grid[0][2] == 0) grid[0][2] = 2;
        else if(grid[0][0] == 2 && grid[0][2] == 2 && grid[0][1] == 0) grid[0][1] = 2;
        else if(grid[0][1] == 2 && grid[0][2] == 2 && grid[0][0] == 0) grid[0][0] = 2;
        //2 row protection
        else if(grid[1][0] == 2 && grid[1][1] == 2 && grid[1][2] == 0) grid[1][2] = 2;
        else if(grid[1][0] == 2 && grid[1][2] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        else if(grid[1][1] == 2 && grid[1][2] == 2 && grid[1][0] == 0) grid[1][0] = 2;
        //3 row protection
        else if(grid[2][0] == 2 && grid[2][1] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[2][0] == 2 && grid[2][2] == 2 && grid[2][1] == 0) grid[2][1] = 2;
        else if(grid[2][1] == 2 && grid[2][2] == 2 && grid[2][0] == 0) grid[2][0] = 2;

        //A column protection
        else if(grid[0][0] == 2 && grid[1][0] == 2 && grid[2][0] == 0) grid[2][0] = 2;
        else if(grid[0][0] == 2 && grid[2][0] == 2 && grid[1][0] == 0) grid[1][0] = 2;
        else if(grid[1][0] == 2 && grid[2][0] == 2 && grid[0][0] == 0) grid[0][0] = 2;
        //B column protection
        else if(grid[0][1] == 2 && grid[1][1] == 2 && grid[2][1] == 0) grid[2][1] = 2;
        else if(grid[0][1] == 2 && grid[2][1] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        else if(grid[1][1] == 2 && grid[2][1] == 2 && grid[0][1] == 0) grid[0][1] = 2;
        //C column protection
        else if(grid[0][2] == 2 && grid[1][2] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[0][2] == 2 && grid[2][2] == 2 && grid[1][2] == 0) grid[1][2] = 2;
        else if(grid[1][2] == 2 && grid[2][2] == 2 && grid[0][2] == 0) grid[0][2] = 2;
        //L-R diagonal protection
        else if(grid[0][0] == 2 && grid[1][1] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[0][0] == 2 && grid[2][2] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        else if(grid[2][2] == 2 && grid[1][1] == 2 && grid[0][0] == 0) grid[0][0] = 2;
        //R-L diagonal protection
        else if(grid[0][2] == 2 && grid[1][1] == 2 && grid[2][0] == 0) grid[2][0] = 2;
        else if(grid[0][2] == 2 && grid[2][0] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        else if(grid[2][0] == 2 && grid[1][1] == 2 && grid[0][2] == 0) grid[0][2] = 2;
        else{
            CPUBrain(grid, spaces);
            for (int row = 0; row < 5; row+=2) {
                for (int col = 0; col < 2; col++) {
                    if(grid[row][col] == 1) charGrid[row][col] = symbol;
                    else if(grid[row][col] == 2) charGrid[row][col] = 'o';
                }
            }
        }
    }

    private static void CPUBrain(int[][] grid, List<String> spaces) {

            //1 row move
        if     (grid[0][0] == 2 && grid[0][1] == 2 && grid[0][2] == 0) grid[0][2] = 2;
        else if(grid[0][0] == 2 && grid[0][2] == 2 && grid[0][1] == 0) grid[0][1] = 2;
        else if(grid[0][1] == 2 && grid[0][2] == 2 && grid[0][0] == 0) grid[0][0] = 2;
            //2 row move
        else if(grid[1][0] == 2 && grid[1][1] == 2 && grid[1][2] == 0) grid[1][2] = 2;
        else if(grid[1][0] == 2 && grid[1][2] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        else if(grid[1][1] == 2 && grid[1][2] == 2 && grid[1][0] == 0) grid[1][0] = 2;
            //3 row protection
        else if(grid[2][0] == 2 && grid[2][1] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[2][0] == 2 && grid[2][2] == 2 && grid[2][1] == 0) grid[2][1] = 2;
        else if(grid[2][1] == 2 && grid[2][2] == 2 && grid[2][0] == 0) grid[2][0] = 2;
        //A column move
        else if(grid[0][0] == 2 && grid[1][0] == 2 && grid[2][0] == 0) grid[2][0] = 2;
        else if(grid[0][0] == 2 && grid[2][0] == 2 && grid[1][0] == 0) grid[1][0] = 2;
        else if(grid[1][0] == 2 && grid[2][0] == 2 && grid[0][0] == 0) grid[0][0] = 2;
            //B column move
        else if(grid[0][1] == 2 && grid[1][1] == 2 && grid[2][1] == 0) grid[2][1] = 2;
        else if(grid[0][1] == 2 && grid[2][1] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        else if(grid[1][1] == 2 && grid[2][1] == 2 && grid[0][1] == 0) grid[0][1] = 2;
            //C column move
        else if(grid[0][2] == 2 && grid[1][2] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[0][2] == 2 && grid[2][2] == 2 && grid[1][2] == 0) grid[1][2] = 2;
        else if(grid[1][2] == 2 && grid[2][2] == 2 && grid[0][2] == 0) grid[0][2] = 2;
            //L-R diagonal move
        else if(grid[0][0] == 2 && grid[1][1] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[0][0] == 2 && grid[2][2] == 2 && grid[1][2] == 0) grid[1][1] = 2;
        else if(grid[2][2] == 2 && grid[1][1] == 2 && grid[0][0] == 0) grid[0][0] = 2;
            //R-L diagonal move
        else if(grid[0][2] == 2 && grid[1][1] == 2 && grid[2][0] == 0) grid[2][0] = 2;
        else if(grid[0][2] == 2 && grid[2][0] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        else if(grid[2][0] == 2 && grid[1][1] == 2 && grid[0][2] == 0) grid[0][2] = 2;
        else{
            Random rd = new Random();
            int a = rd.nextInt(spaces.size()-1);
            String rand = spaces.get(a);
            out.println(rand);
            out.println(deepToString(grid));
            int row = rand.charAt(0);
            int col = rand.charAt(1);
            out.println(row + "col" + col);
            grid[row][col] = 2;
            out.println(deepToString(grid));
        }
    }


    private static char[][] userGuess(char[][] grid, int[][] CPUgrid, char symbol){
        boolean check;
        int let2num = 0;
        char let = 'A';
        int num = 1;
        Scanner sc = new Scanner(in);
        out.println("Enter the CAPITAL letter first, A-C");
        let = sc.nextLine().trim().charAt(0);
        out.println("Now the number, 1-3");
        num = sc.nextInt();
        check = parseInput(let, num, CPUgrid, let2num);
        while(!check) {
            check = parseInput(CPUgrid, let2num, check);
        }
        //update grid
        grid[num][let2num] = (symbol);
        CPUgrid[num][let2num] = 1;
        return grid;
    }

    private static boolean parseInput(int[][] grid, int let2num, boolean check) {
        String[] values = invalid();
        char let = (values[0].charAt(0));
        int num = Integer.parseInt(values[1]);
        if (!((let == 'A') || (let == 'B') || (let == 'C'))) return false;
        switch (let) {
        case 'A' -> let2num = 0;
        case 'B' -> let2num = 1;
        case 'C' -> let2num = 2;
        }
        if (!(num == 1 || num == 2 || num == 3)) return false;
        return grid[num][let2num] != 1;

    }

    private static boolean parseInput(char let, int num, int[][] grid, int let2num){

        if (!((let == 'A') || (let == 'B') || (let == 'C'))) return false;
        switch (let) {
        case 'A' -> let2num = 0;
        case 'B' -> let2num = 1;
        case 'C' -> let2num = 2;
        }
        if (!(num == 1 || num == 2 || num == 3)) return false;
        return grid[num][let2num] != 1;
    }

    public static String[] invalid(){
        Scanner sc = new Scanner(in);
        out.println("That is an invalid input");
        out.println("Enter the letter first, A-C");
        char lett = sc.next().charAt(0);
        out.println("Now the number, 1-3");
        int numb = sc.nextInt();
        return new String[]{Character.toString(lett), Integer.toString(numb)};
    }
}
