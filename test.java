public class test {
    public static void main(String[] args) {
        int[] rounds = {1, 2, 3};
        int[] scores = {13, 16, 15};
        int[] attempts = {3, 2, 1};
        int totalScore = 14;
        int totalAttempts = 6;

        System.out.printf(
            "----------------- %s ----------------%n" +
            "|   %s   |       %s        | %-8s |%n" +
            "|-----------|--------------------|----------|%n" +
            "|   - %d -   | %9d          |     %-4d |%n" +
            "|   - %d -   | %9d          |     %-4d |%n" +
            "|   - %d -   | %9d          |     %-4d |%n" +
            "|-----------|--------------------|----------|%n" +
            "    %-17s %-15d %-8d%n",
             "Finish game", "Round", "Score", "Attempts",
            rounds[0], scores[0], attempts[0],        
            rounds[1], scores[1], attempts[1],        
            rounds[2], scores[2], attempts[2],        
            "Total", totalScore, totalAttempts       
        );
    }
}
