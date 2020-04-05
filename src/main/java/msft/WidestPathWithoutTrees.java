package msft;

import java.util.Arrays;

/*
 * https://leetcode.com/discuss/interview-question/447448/
 */
public class WidestPathWithoutTrees {

    public static void main(String[] args) {
        printResult(new int[] { 5, 5, 5, 7, 7, 7 }, new int[] { 3, 4, 5, 1, 3, 7 }); // Return 2
        printResult(new int[] { 6, 10, 1, 4, 3 }, new int[] { 2, 5, 3, 1, 6 }); // Return 4
        printResult(new int[] { 4, 1, 5, 4 }, new int[] { 4, 5, 1, 3 }); // Return 3
    }

    private static void printResult(int[] integersX, int[] integersY) {
        System.out.print("Trees at - ");
        for (int i = 0; i < integersX.length; i++) {
            System.out.print("[" + integersX[i] + ", " + integersY[i] + "], ");
        }
        System.out.println();
        System.out.println("Width of the max path - " + findVerticalPath(integersX, integersY));
        System.out.println();
    }

    private static int findVerticalPath(int[] x, int[] y) {
        int maxWidth = 0;

        Arrays.sort(x);

        for (int i = 0; i < x.length - 1; i++) {
            maxWidth = Math.max(maxWidth, (x[i + 1] - x[i]));
        }
        return maxWidth;
    }
}