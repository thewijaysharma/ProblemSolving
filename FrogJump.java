package ProblemSolving;

import java.util.Arrays;

public class FrogJump {


    public static int frogJump(int n, int heights[]) {

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int first = dp[i-1] + Math.abs(heights[i] - heights[i - 1]);
            int second = Integer.MAX_VALUE;
            if(i>1){
                second = dp[i-2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(first, second);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        frogJump(6, new int[]{8,7,1,3,9,2});
    }

}
