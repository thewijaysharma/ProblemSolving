package ProblemSolving;

import java.util.Arrays;

public class MinCoinChange {

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        System.out.println("Ans is : "+coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i<coins.length; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = -1;
            }
        }

        int ans =  getCoins(coins, coins.length-1, amount, dp);
        return ans == 2e9 ? -1 : ans;
    }

    static int getCoins(int[] coins, int index, int amount, int[][] dp ){

        if(amount == 0){
            return 0;
        }

        if(index == 0){
            return amount % coins[index] == 0 ? amount/coins[index] : (int) 2e9;
        }

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }

        if(amount < coins[index]){
            return getCoins(coins, index-1, amount, dp);
        }

        int taken = 1 + getCoins(coins, index, amount-coins[index], dp);
        int notTaken = getCoins(coins, index-1, amount, dp);

        dp[index][amount] = Integer.min(taken, notTaken);
        return dp[index][amount];
    }

}
