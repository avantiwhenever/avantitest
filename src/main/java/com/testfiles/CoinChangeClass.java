package com.testfiles;

import java.util.Arrays;

public class CoinChangeClass {

    private static int coinChange(int []coins, int amount) {
        int max = amount + 1;
        int []dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1 ;i <=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j]<=i) {
                    System.out.println("===== "+ i +" " + j);
                    System.out.println("Comparing "+ dp[i] +" " + dp[i - coins[j]] + " with index "+ (i - coins[j]));
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        for (int d: dp) {
            System.out.print(d + " ");
        }
        System.out.println(" ");
        return dp[amount]>amount ? -1 : dp[amount];
    }

    public static void main(String args[]) {
        System.out.println(coinChange(new int[] { 1, 2, 5}, 11));
    }
}
