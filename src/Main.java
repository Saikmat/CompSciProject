import static java.lang.System.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(in);

    public static void main(String[] args){
        out.println("Welcome to console games");
        int options;
        boolean flag;
        int count = 0;
        do {
            options = intro();
            flag = games.main(options);
            count++;
        } while(!flag);

        if(games.main(options)) out.println("Wow you played " + count + "rounds of games, that's a lot");
        else out.println("Thanks for playing, hope to see you back soon");

    }

    public static int intro() {
        System.out.println("""
                if you want to play a game press 1
                if you want to explore the games, press 2
                if you want a compliment, press 3(be warned the computer isn't always nice)
                """);

        return sc.nextInt();
    }
}

