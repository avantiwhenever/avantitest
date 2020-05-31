package epi.dp;

import java.util.Arrays;
import java.util.List;

public class Count2DTraversal {
    /*
    COUNT THE NUMBER OF WAYS TO TRAVERSE A 2D ARRAY

    In this problem you are to count the number of
    ways of starting at the top-left comer
    of a 2D array and getting to the bottom-right comer.
    All moves must either go right or down.
    For example, we show three ways in a 5 X 5 2D array in Figure 17.5.
    (As we will see, there are a total of 70 possible ways for this example.)

    Write a program that counts how many ways you can go from the top-left to the
    bottom-right in a 2D array.
    Hint: If i > 0 and j > 0, you can get to (i, j) from (i-1, j) or (j-1, i).

    */

    public static void main(String args[]) {
        printResult(1,2);
        printResult(2, 5);
        printResult(5, 5);
        printResult(12, 10);
    }

    public static void printResult(int n, int m) {
        int result =  numberOfWays(n, m);
        System.out.println("To generate numberOfWays: with n = " + n
                + ", and m = " + m + " , result is : "+ result);
    }

    public static int numberOfWays (int n, int m) {
        return computeNumberOfWaysToXY(n - 1, m - 1, new int [n] [m] ) ;
    }

    private static int computeNumberOfWaysToXY(int x, int y,
                                               int[][] numberOfWays) {
        if (x == 0 || y == 0) {
            return 1;
        }
        if (numberOfWays[x][y] == 0) {
            int waysTop = x == 0 ? 0 : computeNumberOfWaysToXY(x - 1, y, numberOfWays);
            int waysLeft = x == 0 ? 0 : computeNumberOfWaysToXY(x, y - 1, numberOfWays);
            numberOfWays[x][y] = waysTop + waysLeft;
        }
        return numberOfWays[x][y];
    }
}
