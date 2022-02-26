import java.util.*;

class wordle {
    public static String user(String current, String word, String[] letters) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nThe current guess is: " + current);
        System.out.print("Letters that are in the word but not in the correct spot are");
        System.out.println(Arrays.toString(letters));
        System.out.print("What is your guess? ");
        return input.next();
    }
    public static String correctChoice(String wordy, String choice, String current, String[] letters) {
        Word word = new Word();
        int size = choice.length();
        if (size !=5) {
            System.out.print("Invalid Guess!\n");
            return current;
        }
        if (!word.validGuess(choice) && !word.validGuess1(choice)) {
            System.out.print("Invalid Guess!\n");
            return current;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String l1 = choice.substring(i, i + 1);
                String l2 = wordy.substring(j, j + 1);
                if (l1.equals(l2) && j == i) {
                    System.out.println("\n" + l1 + " is included and in the correct spot");
                    current = current.substring(0, i) + l1 + current.substring(i + 1);
                } else if (l1.equals(l2) && j != i) {
                    System.out.println("\n" + l1 + " is included but not in the correct spot");
                    letters[letters.length] = (l1);
                }
            }
        }

        return current;
    }
    public static String wordChoice() {
        Random r = new Random();
        Word word = new Word();
        int size = word.length();
        int n = r.nextInt(size);
        return word.wordChoice(n);
    }
    public static boolean main() {
        System.out.print("Hangman Wordle!\nYou have 8 guesses!\nWords have 5 unique letters!\nAll words are lowercase!\nTry to fill in the word!\n");
        String current = "_____";
        String choices = "";
        String[] letters = {};
        String word = wordChoice();
        int guesses = 0;
        for (int i = 0; i < 8; i++) {
            String choice = user(current, word, letters);
            choices = choices + "\n" + choice + "";
            System.out.print("\nThe previous choices were: \n" + choices + "\n");
            current = correctChoice(word, choice, current, letters);
            if (current.equals(word)) {
                System.out.print("You Win!");
                i = 8;
                return true;
            }
            if (i == 6) {
                System.out.println("One guess remaining!");
            }
            guesses = i;
        }
        if (guesses == 7) {
            System.out.print("You Lost! The word was " + word);
            return false;
        }
        return false;
    }
}