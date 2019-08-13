package ProblemSolving;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class ClimbingTheLeaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        List<Integer> aliceScores = new ArrayList<>();

        int[][] ranks = new int[scores.length][2];

        int rank = 0;
        int prev = Integer.MAX_VALUE;

        for (int i = 0; i < scores.length; i++) {

            int current = scores[i];

            if (current < prev) {
                rank++;
            }

            ranks[i] = new int[]{current, rank};

            prev = current;

        }

        int n = scores.length;

        for (int aliceScore : alice) {
            int i = n - 1;

            while (i >= 0) {
                int current = ranks[i][0];

                if (aliceScore == current) {
                    aliceScores.add(ranks[i][1]);
                    n = i + 1;
                    break;
                } else if (aliceScore < current) {
                    aliceScores.add(ranks[i][1] + 1);
                    n = i + 1;
                    break;
                } else {

                    if(i == 0){
                        aliceScores.add(1);
                        break;
                    }else
                        i--;
                }

            }

        }

        int[] results = new int[aliceScores.size()];

        for (int i = 0; i < aliceScores.size(); i++) {
            results[i] = aliceScores.get(i);
        }

        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OutputFile.txt"));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

