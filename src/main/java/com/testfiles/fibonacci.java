package com.testfiles;

public class fibonacci {

    public static void main(String[] args)
    {
        int num = 10;
        for (int i=0 ; i<=num; i++) {
            printResult(i);
        }
    }

    private static void printResult (int num) {
        System.out.println("Printing fibRec of number "+ num + " =" + fibRec(num));
        System.out.println("Printing fibMemoization of number " + num + " ="
                + fibMemoization(num, new int[num+1]));
        System.out.println("Printing fibBottomUpDynamicProgramming of number " + num + " ="
                + fibBottomUpDynamicProgramming(num));
        System.out.println("Printing fibBottomUpEasy of number " + num + " ="
                + fibBottomUpEasy(num));
    }

    private static int fibRec(int num) {
        if ( num <2) {
            return num;
        }
        return fibRec(num-1) + fibRec(num -2);
    }

    private static int fibMemoization(int num, int[] memo) {
        if (num < 2) {
            return num;
        }
        return memo[num] != 0 ? memo[num] : fibMemoization(num-1, memo) + fibMemoization(num-2, memo);
    }

    private static int fibBottomUpDynamicProgramming(int num) {
        if (num < 2) {
            return num;
        }
        int[] memo = new int[num+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i=2; i<num+1; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[num];
    }

    private static int fibBottomUpEasy(int num) {
        if (num < 2) {
            return num;
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        for (int i=2; i<num+1; i++) {
           c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
