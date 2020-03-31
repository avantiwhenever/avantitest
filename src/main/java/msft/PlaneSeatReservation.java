package msft;
/*
https://leetcode.com/discuss/interview-question/492652/
https://leetcode.com/problems/cinema-seat-allocation/
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PlaneSeatReservation {

    private static final int seats2345 = (1<<2) | (1<<3) | (1<<4) | (1<<5);
    private static final int seats4567 = (1<<4) | (1<<5) | (1<<6) | (1<<7);
    private static final int seats6789 = (1<<6) | (1<<7) | (1<<8) | (1<<9);

    public static void main(String[] args) {
        printResult(3, new int[][] {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}});
        printResult(5, new int[][] {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}});
        printResult(8, new int[][] {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}});
        printResult(10, new int[][] {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}});
        printResult(2, new int[][] {{2,1},{1,8},{2,6}});
        printResult(4, new int[][] {{4,3},{1,4},{4,6},{1,7}});
    }

    private static void printResult (int n, int[][] reserved) {
        System.out.println("Printing getMax4familySeatReservations of string input : "
                + printArrayOfArray(reserved) + " = " + getMax4familySeatReservations(n, reserved));
    }

    private static String printArrayOfArray(int[][] reserved) {
        StringBuilder sb = new StringBuilder();
        for (int[] array : reserved) {
            sb.append(Arrays.toString(array));
        }
        return sb.toString();
    }

    private static int getMax4familySeatReservations(int n, int[][] reservedSeats) {
        Map<Integer, Integer> graph = new HashMap<>();
        for (int [] reserved : reservedSeats) {
            int row = reserved[0];
            int column = reserved[1];
            graph.put(row, graph.getOrDefault(row, 0) | (1<< column));
        }
        int max = 0;
        for (int row : graph.keySet()) {
            int reserved = graph.get(row);
            int count = 0;
            if ((seats2345 & reserved) == 0) {
                count++;
            }
            if ((seats6789 & reserved) == 0) {
                count++;
            }
            if ((seats4567 & reserved) == 0 && count == 0) {
                count = 1;
            }
            max = max + count;
        }
        return max + 2 * (n-graph.size());
    }
}