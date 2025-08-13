public class test {
    public static void main(String[] args) {
        int[] rounds = {1, 2, 3};
        int[] scores = {3, 6, 5};
        int[] attempts = {3, 2, 1};
        int totalScore = 14;
        int totalAttempts = 6;

        System.out.printf(
            "----------------- %s ----------------%n" +
            "|   %s   | %18s | %-8s |%n" +
            "|-----------|--------------------|----------|%n" +
            "|   - %d -   | %-18d | %-8d |%n" +
            "|   - %d -   | %-18d | %-8d |%n" +
            "|   - %d -   | %-18d | %-8d |%n" +
            "%n---%n%n" +
            "%-10s %-19d %-8d%n",
             "Finish game", "Round", "Score", "Attempts",
            rounds[0], scores[0], attempts[0],        
            rounds[1], scores[1], attempts[1],        
            rounds[2], scores[2], attempts[2],        
            "Total", totalScore, totalAttempts       
        );
    }
}
