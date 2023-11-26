package ProblemSolving;

import java.util.Arrays;

class PaintHouse {
    public int minCost(int[][] costs) {

        int[][] dp = new int[costs.length][4];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return getMinCost(0, 3, costs, dp);

    }

    private int getMinCost(int curr, int prevColor, int[][] costs, int[][] dp){

        if(curr ==  costs.length){
            return 0;
        }

        if(dp[curr][prevColor] != -1){
            return dp[curr][prevColor];
        }

        int first = (int)1e8;
        int second = (int)1e8;
        int third = (int)1e8;


        if(prevColor != 0){
            first = costs[curr][0] + getMinCost(curr+1, 0, costs, dp);
        }
        if(prevColor != 1){
            second = costs[curr][1] + getMinCost(curr+1, 1, costs, dp);
        }
        if(prevColor != 2){
            third = costs[curr][2] + getMinCost(curr+1, 2, costs, dp);
        }

        dp[curr][prevColor] = Math.min(Math.min(first, second), third);

        return dp[curr][prevColor];

    }
}