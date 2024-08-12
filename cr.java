
    import java.util.Random;

public class cr {
    static Random random = new Random();

    public static void main(String[] args) {
       
        String team1 = "Team A";
        String team2 = "Team B";

        String tossWinner = simulateToss(team1, team2);
        String tossLoser = tossWinner.equals(team1) ? team2 : team1;

        
        String[] team1Players = {
            "Player A1", "Player A2", "Player A3", "Player A4", "Player A5",
            "Player A6", "Player A7", "Player A8", "Player A9", "Player A10", "Player A11"
        };

        String[] team2Players = {
            "Player B1", "Player B2", "Player B3", "Player B4", "Player B5",
            "Player B6", "Player B7", "Player B8", "Player B9", "Player B10", "Player B11"
        };

  
        int overs = 20;
        int team1Score, team2Score;

        if (tossWinner.equals(team1)) {
            team1Score = simulateInnings(team1, team1Players, overs);
            team2Score = simulateInnings(team2, team2Players, overs);
        } else {
            team2Score = simulateInnings(team2, team2Players, overs);
            team1Score = simulateInnings(team1, team1Players, overs);
        }

        determineWinner(team1Score, team2Score, team1, team2);
    }

  
    private static String simulateToss(String team1, String team2) {
        String tossWinner = random.nextBoolean() ? team1 : team2;
        System.out.println("Toss won by " + tossWinner);
        return tossWinner;
    }

    private static int simulateInnings(String teamName, String[] players, int overs) {
        int totalRuns = 0;
        int totalWickets = 0;

        System.out.println("\n" + teamName + " Scorecard:");

        for (int i = 0; i < 11; i++) {
            if (totalWickets == 10) break;

            int ballsFaced = random.nextInt(30) + 1;  // Balls faced between 1 and 30
            int runsScored = random.nextInt(ballsFaced * 6 + 1);  // Runs scored between 0 and max possible
            boolean isOut = random.nextBoolean();

            totalRuns += runsScored;

            String status = isOut ? "Out" : "Not Out";
            if (isOut) totalWickets++;

            double strikeRate = (runsScored / (double) ballsFaced) * 100;

            System.out.printf( "%s - %d runs (%d balls, %.2f SR) - %s%n", players[i], runsScored, ballsFaced, strikeRate, status);
        }
        int i;

System.out.printf("Total: %d/%d in %d overs%n", totalRuns, totalWickets, overs);

         

        return totalRuns;
    }

  
    private static void determineWinner(int score1, int score2, String team1, String team2) {
        System.out.println("\nFinal Result:");
        if (score1 > score2) {
            System.out.println(team1 + " wins by " + (score1 - score2) + " runs!");
        } else if (score2 > score1) {
            System.out.println(team2 + " wins by " + (score2 - score1) + " runs!");
        } else {
            System.out.println("The match is a tie!");
        }
    }
}


