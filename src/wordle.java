import java.util.Scanner;

import static java.lang.System.*;

class wordle {
    private static boolean main() {
        Scanner sc = new Scanner(in);
        out.println("This wordle can be played with 5-8 letter words, choose your preference");
        switch (sc.nextInt()){
            case 5: return wordle5(); break;
            case 6: return wordle6(); break;
            case 7: return wordle7(); break;
            case 8: return wordle8(); break;
            default: out.println("This is not a valid input"); break;
        }
    }
    public static boolean wordle5() {
        out.println("If your letter is correct and in the right spot, it will be printed on the next line with an underline");
        out.println("If your letter is correct but not in the right spot, it will be printed on the next line without an underline");
    }
    public static boolean wordle6(){

    }
    public static boolean wordle7(){

    }
    public static boolean wordle8(){

    }
}
