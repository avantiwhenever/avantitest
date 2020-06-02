package epi.dp;

import java.util.Arrays;
import java.util.List;

public class CoinPickForMaxGain {

    /*
    In the pick-up-coins game, an even number of coins are placed in a line, as in Fig¬
ure 17.11. Two players take turns at choosing one coin each—they can only choose
from the two coins at the ends of the line. The game ends when all the coins have
been picked up. The player whose coins have the higher total value wins. A player
cannot pass his turn.

Design an efficient algorithm for computing the maximum total value for the starting
player in the pick-up-coins game.
Hint: Relate the best play for the first player to the best play for the second player.

    For the coins (10, 25,5,1,10, 5), the optimum revenue for the firstplayer is31. Some
of subproblems encountered include computing the optimum revenue for (10,25)
(which is 25), (5,1) (which is 5), and (5,1,10,5) (which is 15).
     */

    public static void main(String args[]) {
        printResult(Arrays.asList(10, 25, 5, 1, 10, 5));
    }

    private static void printResult(List<Integer> list) {
        System.out.println("For give list :" + list +
                ", getting revenue/gain for A/B : " + pickUpCoins(list));
    }

    private static int pickUpCoins(List<Integer> coins) {
        return computeMaximumRevenueForRange(coins, 0, coins.size() - 1,
                new int[coins.size()][coins.size()]);
    }

    /*
    There are 0(n^2) possible arguments for R(a,b), where n is the number of coins, and
    the time spent to compute R from previously computed values is 0(1). Hence, R can
    be computed in 0(n^2) time.
     */
    private static int computeMaximumRevenueForRange(
            List<Integer> coins, int a, int b, int[][] maximumRevenueForRange) {
        if (a > b)
            // No coins left.
            return 0;

        if (maximumRevenueForRange[a][b] == 0) {
            int maximumRevenueA = coins.get(a)
                    +
                    Math.min(
                            computeMaximumRevenueForRange(coins, a + 2, b, maximumRevenueForRange),
                            computeMaximumRevenueForRange(coins, a + 1, b - 1, maximumRevenueForRange)
                    );
            int maximumRevenueB = coins.get(b)
                    +
                    Math.min(
                            computeMaximumRevenueForRange(coins, a + 1, b - 1, maximumRevenueForRange),
                            computeMaximumRevenueForRange(coins, a, b - 2, maximumRevenueForRange)
                    );
            System.out.println("Max Rev A : " + maximumRevenueA + ", Max Rev B : " + maximumRevenueB);
            maximumRevenueForRange[a][b] = Math.max(maximumRevenueA, maximumRevenueB);
        }
        return maximumRevenueForRange[a][b];
    }
}
