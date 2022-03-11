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


        char[][] grid = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-',}};
        int[][] CPUgrid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        out.println("If you want to pick a symbol, press y");
        if (sc.next().equalsIgnoreCase("Y")) {
            out.println("Enter the character you want to use, note that input may only be one character");
            out.println("You may not use '-' as your character");
            String str = sc.next();
            symbol = str.charAt(0);
            if (symbol == '-') {
                symbol = 'x';
                out.println("I warned you...Your symbol is now the default 'x'");
            }
        }
        for(int i = 0; i < 9; i++) {
            userGuess(grid, CPUgrid, symbol);
            out.println(Arrays.deepToString(userGuess(grid, CPUgrid, symbol)));
            if(!checkWin(CPUgrid)) break;
            out.println("CPU turn");
            CPUblock(grid, CPUgrid);
            if(!checkWin(CPUgrid)) break;

        }
        return false;
    }

    private static boolean checkWin(int[][] grid) {
        if     (grid[1][1] == 2 && grid[1][2] == 2 && grid[1][3] == 2) return true;
        else if(grid[2][1] == 2 && grid[2][2] == 2 && grid[2][3] == 2) return true;
        else if(grid[3][1] == 2 && grid[3][2] == 2 && grid[3][3] == 2) return true;
        else if(grid[1][1] == 2 && grid[2][1] == 2 && grid[3][1] == 2) return true;
        else if(grid[1][2] == 2 && grid[2][2] == 2 && grid[3][2] == 2) return true;
        else if(grid[1][3] == 2 && grid[2][3] == 2 && grid[3][3] == 2) return true;
        else if(grid[1][1] == 2 && grid[2][2] == 2 && grid[3][3] == 2) return true;
        else if(grid[1][3] == 2 && grid[2][2] == 2 && grid[3][1] == 2) return true;
        else if(grid[1][1] == 1 && grid[1][2] == 1 && grid[1][3] == 1) return true;
        else if(grid[2][1] == 1 && grid[2][2] == 1 && grid[2][3] == 1) return true;
        else if(grid[3][1] == 1 && grid[3][2] == 1 && grid[3][3] == 1) return true;
        else if(grid[1][1] == 1 && grid[2][1] == 1 && grid[3][1] == 1) return true;
        else if(grid[1][2] == 1 && grid[2][2] == 1 && grid[3][2] == 1) return true;
        else if(grid[1][3] == 1 && grid[2][3] == 1 && grid[3][3] == 1) return true;
        else if(grid[1][1] == 1 && grid[2][2] == 1 && grid[3][3] == 1) return true;
        else if(grid[1][3] == 1 && grid[2][2] == 1 && grid[3][1] == 1) return true;
        else return false;
    }

    /**
     * Finds all the moves that are possible on the board and determines if they are good moves or not
     * @param charGrid {char} - Passes the char grid to the computer so it can be updated
     * @param grid {char} - Passes the char grid to the computer so it can be updated
     */

    public static void CPUblock(char[][] charGrid, int[][] grid) {
        Random rd = new Random();
        List<String> spaces= new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i][j] == 0) spaces.add(String.valueOf(i) + j);
            }
        }
        //1 row protection
        if     (grid[1][1] == 2 && grid[1][2] == 2 && grid[1][3] == 0) grid[1][3] = 2;
        else if(grid[1][1] == 2 && grid[1][3] == 2 && grid[1][2] == 0) grid[1][2] = 2;
        else if(grid[1][2] == 2 && grid[1][3] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        //2 row protection
        else if(grid[2][1] == 2 && grid[2][2] == 2 && grid[2][3] == 0) grid[2][3] = 2;
        else if(grid[2][1] == 2 && grid[2][3] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[2][2] == 2 && grid[2][3] == 2 && grid[2][1] == 0) grid[2][1] = 2;
        //3 row protection
        else if(grid[3][1] == 2 && grid[3][2] == 2 && grid[3][3] == 0) grid[3][3] = 2;
        else if(grid[3][1] == 2 && grid[3][3] == 2 && grid[3][2] == 0) grid[3][2] = 2;
        else if(grid[3][2] == 2 && grid[3][3] == 2 && grid[3][1] == 0) grid[3][1] = 2;

        //A column protection
        else if(grid[1][1] == 2 && grid[2][1] == 2 && grid[3][1] == 0) grid[3][1] = 2;
        else if(grid[1][1] == 2 && grid[3][1] == 2 && grid[2][1] == 0) grid[2][1] = 2;
        else if(grid[2][1] == 2 && grid[3][1] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        //B column protection
        else if(grid[1][2] == 2 && grid[2][2] == 2 && grid[3][2] == 0) grid[3][2] = 2;
        else if(grid[1][2] == 2 && grid[3][2] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[2][2] == 2 && grid[3][2] == 2 && grid[1][2] == 0) grid[1][2] = 2;
        //C column protection
        else if(grid[1][3] == 2 && grid[2][3] == 2 && grid[3][3] == 0) grid[3][3] = 2;
        else if(grid[1][3] == 2 && grid[3][3] == 2 && grid[2][3] == 0) grid[2][3] = 2;
        else if(grid[2][3] == 2 && grid[3][3] == 2 && grid[1][3] == 0) grid[1][3] = 2;
        //L-R diagonal protection
        else if(grid[1][1] == 2 && grid[2][2] == 2 && grid[3][3] == 0) grid[3][3] = 2;
        else if(grid[1][1] == 2 && grid[3][3] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[3][3] == 2 && grid[2][2] == 2 && grid[1][1] == 0) grid[1][1] = 2;
        //R-L diagonal protection
        else if(grid[1][3] == 2 && grid[2][2] == 2 && grid[3][1] == 0) grid[3][1] = 2;
        else if(grid[1][3] == 2 && grid[3][1] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[3][1] == 2 && grid[2][2] == 2 && grid[1][3] == 0) grid[1][3] = 2;
        else{
            CPUBrain(grid, spaces);
        }
    }

    private static void CPUBrain(int[][] grid, List<String> spaces) {

            //1 row move
        if     (grid[1][1] == 2 && grid[1][2] == 2 && grid[1][3] == 0) grid[1][3] = 2;
        else if(grid[1][1] == 2 && grid[1][3] == 2 && grid[1][2] == 0) grid[1][2] = 2;
        else if(grid[1][2] == 2 && grid[1][3] == 2 && grid[1][1] == 0) grid[1][1] = 2;
            //2 row move
        else if(grid[2][1] == 2 && grid[2][2] == 2 && grid[2][3] == 0) grid[2][3] = 2;
        else if(grid[2][1] == 2 && grid[2][3] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[2][2] == 2 && grid[2][3] == 2 && grid[2][1] == 0) grid[2][1] = 2;
            //3 row protection
        else if(grid[3][1] == 2 && grid[3][2] == 2 && grid[3][3] == 0) grid[3][3] = 2;
        else if(grid[3][1] == 2 && grid[3][3] == 2 && grid[3][2] == 0) grid[3][2] = 2;
        else if(grid[3][2] == 2 && grid[3][3] == 2 && grid[3][1] == 0) grid[3][1] = 2;
        //A column move
        else if(grid[1][1] == 2 && grid[2][1] == 2 && grid[3][1] == 0) grid[3][1] = 2;
        else if(grid[1][1] == 2 && grid[3][1] == 2 && grid[2][1] == 0) grid[2][1] = 2;
        else if(grid[2][1] == 2 && grid[3][1] == 2 && grid[1][1] == 0) grid[1][1] = 2;
            //B column move
        else if(grid[1][2] == 2 && grid[2][2] == 2 && grid[3][2] == 0) grid[3][2] = 2;
        else if(grid[1][2] == 2 && grid[3][2] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[2][2] == 2 && grid[3][2] == 2 && grid[1][2] == 0) grid[1][2] = 2;
            //C column move
        else if(grid[1][3] == 2 && grid[2][3] == 2 && grid[3][3] == 0) grid[3][3] = 2;
        else if(grid[1][3] == 2 && grid[3][3] == 2 && grid[2][3] == 0) grid[2][3] = 2;
        else if(grid[2][3] == 2 && grid[3][3] == 2 && grid[1][3] == 0) grid[1][3] = 2;
            //L-R diagonal move
        else if(grid[1][1] == 2 && grid[2][2] == 2 && grid[3][3] == 0) grid[3][3] = 2;
        else if(grid[1][1] == 2 && grid[3][3] == 2 && grid[2][3] == 0) grid[2][2] = 2;
        else if(grid[3][3] == 2 && grid[2][2] == 2 && grid[1][1] == 0) grid[1][1] = 2;
            //R-L diagonal move
        else if(grid[1][3] == 2 && grid[2][2] == 2 && grid[3][1] == 0) grid[3][1] = 2;
        else if(grid[1][3] == 2 && grid[3][1] == 2 && grid[2][2] == 0) grid[2][2] = 2;
        else if(grid[3][1] == 2 && grid[2][2] == 2 && grid[1][3] == 0) grid[1][3] = 2;
        else{
            Random rd = new Random();
            String rand = spaces.get(rd.nextInt(spaces.size()));
            grid[rand.charAt(0)][rand.charAt(1)] = 2;
        }
    }


    private static char[][] userGuess(char[][] grid, int[][] CPUgrid, char symbol){
        boolean check;
        int let2num = 0;
        char let = 'A';
        int num = 1;
        Scanner sc = new Scanner(in);
        out.println("Enter the CAPITAL letter first, A-C");
        let = sc.next().charAt(0);
        out.println("Now the number, 1-3");
        num = sc.nextInt();
        check = parseInput(let, num, CPUgrid, let2num);
        while(!check) {
            invalid(let, num);
            check = parseInput(let, num, CPUgrid, let2num);
        }
        //update grid
        grid[num][let2num] = (symbol);
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
        return grid[num][let2num] != 1;
    }

    public static void invalid(char let, int num){
        Scanner sc = new Scanner(in);
        out.println("That is an invalid input");
        out.println("Enter the letter first, A-C");
        let = sc.next().charAt(0);
        out.println("Now the number, 1-3");
        num = sc.nextInt();
    }
}
