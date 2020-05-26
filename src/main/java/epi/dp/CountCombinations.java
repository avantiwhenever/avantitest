package epi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountCombinations {

    //COUNT THE NUMBER OF SCORE COMBINATIONS

    /*
    In an American football game,
    a play can lead to 2 points (safety),
    3 points (field goal),
    or 7 points (touchdown, assuming the extra point).
    Many different combinations of
    2, 3, and 7 point plays can make up a final score.
    For example, four combinations of
    plays yield a score of 12:
    • 6 safeties (2x6 = 12),
    • 3 safeties and 2 field goals (2x3 + 3x2 = 12),
    • 1safety,1 field goal and 1 touchdown (2xl + 3xl + 7xl = 12), and
    • 4 field goals (3x4 = 12).
    Write a program that takes a final score and scores for individual plays,
     and returns
    the number of combinations of plays that result in the final score.
    Hint: Count the number of combinations in which there are 0 Wo plays,
    then 1 Wo plays, etc.
    */

    public static void main(String args[]) {
        printResult(1, Arrays.asList(2,3,7));
        printResult(7, Arrays.asList(2,3,7));
        printResult(9, Arrays.asList(2,3,7));
        printResult(12, Arrays.asList(2,3,7));
    }

    public static void printResult(int finalScore, List<Integer> list) {
        int result =  numCombinationsForFinalScore(finalScore, list);
        System.out.println("To generate finalScore: " + finalScore + ", for list " + list +
                " , result is : "+ result);
    }

    public static int numCombinationsForFinalScore(
            int finalScore , List<Integer> individualPlayScores) {
        int[][] numCombinationsForScore = new int[individualPlayScores.size()][finalScore + 1];
        for (int i = 0; i < individualPlayScores.size(); ++i) {
            numCombinationsForScore[i][0] = 1 ; // One way to reach (9.
            for (int j = 1; j <= finalScore; ++j) {
                int withoutThisPlay
                        = i - 1 >= 0 ? numCombinationsForScore[i - 1][j] : 0;
                int withThisPlay
                        = j >= individualPlayScores.get(i)
                        ? numCombinationsForScore[i][j - individualPlayScores.get(i)]
                        : 0 ;
                numCombinationsForScore[i][j] = withoutThisPlay + withThisPlay;
            }
        }
        return numCombinationsForScore[individualPlayScores.size() - 1][finalScore];
    }

    /*
    The time complexity is 0(sn) (two loops, one to s, the other to n) and the space
complexity is0(sn) (the size of the 2D array).
     */
}
