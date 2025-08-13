import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static Scanner sc = new Scanner(System.in);
    public static Random rnd = new Random();
    public static String[] categories = {
        "Animals", 
        "Cities", 
        "Fruits", 
        "Cars", 
        "Colors", 
        "Countries", 
        "Sports", 
        "ProgrammingLanguages", 
        "Planets"
    };
    public static String[][] categoriesWord = {
        {"Elephant", "Cat", "Giraffe", "Lion", "Tiger", "Dog", "Bear", "Wolf", "Fox", "Horse"},
        {"Bishkek", "Karakol", "Moscow", "London", "Paris", "Berlin", "Tokyo", "New York", "Dubai", "Rome"},
        {"Pineapple", "Mango", "Banana", "Apple", "Orange", "Grapes", "Strawberry", "Cherry", "Watermelon", "Kiwi"},
        {"Toyota", "BMW", "Mercedes", "Audi", "Honda", "Ford", "Lexus", "Nissan", "Chevrolet", "Volkswagen"},
        {"Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Orange", "Pink", "Brown"},
        {"Kyrgyzstan", "Russia", "USA", "Japan", "China", "Germany", "France", "Italy", "Brazil", "Canada"},
        {"Football", "Basketball", "Tennis", "Volleyball", "Hockey", "Swimming", "Baseball", "Boxing", "Cycling", "Skiing"},
        {"Java", "JavaScript", "Python", "C", "C++", "C#", "Ruby", "PHP", "Swift", "Go"},
        {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Moon"}
    };
    public static char[] encodedWord;
    public static int points = 0;
    public static int attemptPoints = 0;
    public static int tries = 3;
    public static int tourCount = 3;
    public static int gameIndex = 0;
    public static int[] scores = new int[3];
    public static int[] attempts = new int[3];
    
    public static void main(String[] args) {
        tourLaunch();
    }

    public static void tourLaunch() {
        for (int i = 0; i < tourCount; i++) {
            String[] words = selectCategory();
            String word = selectWord(words);
            deleteRepeating(words, word);
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
            print("\nTries left: " + tries);
            print("Points: " + attemptPoints);
            countScores(scores);
            countAttempts(attempts);
            attemptPoints = 0;
            gameIndex++;
            tries = 3;
        }

        int totalScore = 0;
        for (int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
        }

        drawTable(scores, attempts, totalScore);
    }

    public static void drawTable(int[] scores, int[] attempts, int totalScore) {
        System.out.printf(
            "%n---------------- %s ---------------%n" +
            "    %s   |       %s        | %-8s  %n" +
            "------------|--------------------|---------- %n" +
            "    - %d -   | %9d          |     %-4d  %n" +
            "    - %d -   | %9d          |     %-4d  %n" +
            "    - %d -   | %9d          |     %-4d  %n" +
            "------------|--------------------|---------- %n" +
            "    %-7s |        %-11d |     %-8d%n",
             "Finish game", "Round", "Score", "Attempts",
            1, scores[0], attempts[0],        
            2, scores[1], attempts[1],        
            3, scores[2], attempts[2],        
            "Total", totalScore, attempts[2]       
        );
    }

    public static int[] countAttempts(int[] attempts) {
        attempts[gameIndex] = tries;
        
        return attempts;
    }

    public static int[] countScores(int[] scores) {
        scores[gameIndex] = attemptPoints;

        return scores;
    }

    public static void deleteRepeating(String [] arr, String word) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word)) {
                arr[i] = "";
            }
        }
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
        
        for (int i = 0; i < word.length(); i++) {
            if (str.equalsIgnoreCase(String.valueOf(word.charAt(i)))) {
                encodedWord[i] = word.charAt(i);
                isCorrect = false;
                points++;
                attemptPoints++;
            }
        }

        if (isCorrect) {
            tries--;
        }

        return isCorrect;
    }

    public static char chooseLetter() {
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
        String word;

        do {
            word = arr[rnd.nextInt(arr.length)];
        } while (word.isEmpty());

        return word;
    }

    public static String[] selectCategory() {
        int index = rnd.nextInt(categoriesWord.length);
        print("\nCategory: " + categories[index]);
        return categoriesWord[index];
    }

    public static void print(String str) {
        System.out.println(str);
    }

}