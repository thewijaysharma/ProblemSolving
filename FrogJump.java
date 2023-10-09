package ProblemSolving;

import java.util.Arrays;

public class FrogJump {


    public static int frogJump(int n, int heights[]) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int e = findMinEnergy(heights.length-1, heights, dp);
        System.out.println("Energy is :"+e);

        return e;
    }

    static int findMinEnergy(int index, int[] heights, int[] dp) {
        if (index == 0) {
            return 0;
        }

        if(dp[index] != -1) return dp[index];

        int right = Integer.MAX_VALUE;

        if (index - 2 >= 0) {
            right = Math.abs(heights[index] - heights[index - 2]) + findMinEnergy(index-2,  heights, dp);
        }

        int left = Math.abs(heights[index] - heights[index-1]) + findMinEnergy(index -1, heights, dp);

        dp[index] = Integer.min(right, left);
        return dp[index];
    }

    public static void main(String[] args) {
        frogJump(6, new int[]{8,7,1,3,9,2});
    }

}
