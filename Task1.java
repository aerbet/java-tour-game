import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static Random rnd = new Random();
    public static char[] encodedWord;
    public static int points = 0;
    public static int tries = 3;
    public static int tourCount = 3;
    
    public static void main(String[] args) {
        tourLaunch();
    }

    public static void tourLaunch() {
        String[] words = selectCategory();
        String word = selectWord(words);
        print(word);
        getEncodedWord(word);
        
        while (checkEncodedWord()) { 
            char letter = chooseLetter();

            if (replaceLetter(letter, word)) {
                print("Letter is not exist.\nTries left: " + tries);
            }
            if (tries == 0) {
                break;
            }
            print(Arrays.toString(encodedWord));
        }
        
        print("\nGame Over");
        print("Word: " + word);
        print("Points: " + points);
    }

    public static boolean checkEncodedWord() {
        for (char c : encodedWord) {
            if (c == '*') {
                return true;
            }
        }
        return false;
    }

    public static boolean replaceLetter(char letter, String word) {
        String str = String.valueOf(letter);
        boolean isCorrect = true;
        tries--;
        for (int i = 0; i < word.length(); i++) {
            if (str.equalsIgnoreCase(String.valueOf(word.charAt(i)))) {
                encodedWord[i] = word.charAt(i);
                isCorrect = false;
                points++;
                tries = 3;
            }
        }

        return isCorrect;
    }

    public static char chooseLetter() {
        Scanner sc = new Scanner(System.in);
        String str;

        while (true) { 
            print("Enter letter: ");
            str = sc.nextLine().strip();

            if (!str.isEmpty()) {
                break;
            }

            print("Letter can not be empty / Try again");
        }

        return str.charAt(0);
    }

    public static void getEncodedWord(String word) {
        encodedWord = new char[word.length()];

        Arrays.fill(encodedWord, '*');
    }

    public static String selectWord(String[] arr) {
        return arr[rnd.nextInt(arr.length)];
    }

    public static String[] selectCategory() {
        String[] categories = {"Animals", "Cities", "Fruits", "Cars"};

        switch (rnd.nextInt(categories.length)) { 
            case 0:
                print("Category: " + categories[0]);
                return new String[] {"Elephant", "Cat", "Giraffe"};
            case 1:
                print("Category: " + categories[1]);
                return new String[] {"Bishkek", "Karakol", "Moscow"};
            case 2:
                print("Category: " + categories[2]);
                return new String[] {"Pineapple", "Mango", "Banana"};
            case 3:
                print("Category: " + categories[3]);
                return new String[] {"Toyota", "BMW", "Mercedes"};
            default:
                throw new AssertionError();
        }

    }

    public static void print(String str) {
        System.out.println(str);
    }





    
}