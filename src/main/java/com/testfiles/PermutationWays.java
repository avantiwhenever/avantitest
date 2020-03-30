package com.testfiles;

import java.util.Arrays;

// child can go 1m 2m 3 step
public class PermutationWays {
    public static void main(String[] args)
    {
        int num = 10;
        for (int i=0 ; i<=num; i++) {
            printResult(i);
        }
    }

    private static void printResult (int num) {
        System.out.println("Printing countWaysRec of number "+ num + " =" + countWaysRec(num));
        int[] memo = new int[num+1];
        Arrays.fill(memo, -1);
        System.out.println("Printing countWaysMemoization of number " + num + " ="
                + countWaysMemoization(num, memo));
    }

    //complexity o(3^n) - not good
    private static int countWaysRec(int num) {
        if (num <0) {
            return 0;
        } else if (num == 0) {
            return 1;
        } else {
            return countWaysRec(num-1) + countWaysRec(num -2) + countWaysRec(num-3);
        }
    }

    private static int countWaysMemoization(int num, int [] memo) {
        if (num <0) {
            return 0;
        } else if (num == 0) {
            return 1;
        } else if (memo[num] != -1) {
            return memo[num];
        }
        else {
            memo[num] = countWaysRec(num-1) + countWaysRec(num -2) + countWaysRec(num-3);
            return memo[num];
        }
    }
}
