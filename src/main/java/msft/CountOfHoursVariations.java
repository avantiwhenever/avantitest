package msft;

import java.util.HashSet;
import java.util.Set;

public class CountOfHoursVariations {
    /*
    https://leetcode.com/discuss/interview-question/645626/
    Given a generic digital clock, having h number of hours and m number of minutes,
    the task is to find how many times the clock shows identical time.
    The parameters were 4 integers A,B,C,D.
    The valid time should be somewhere between 00:00 and 24:00.
    If the integers don't fulfil the requirements the function should return 0.

Restrictions: A,B,C,D are integers between [0,9]

public static int solve(int A, int B, int C, int D) {
//return the count of how many variants are there to combine the four integers so its a valid hour
// from 00:00 to 24:00
}
Testcase#1 (1,0,0,2) => (00:12) (00:21) (01: 02) (01:20) (02:10) (02:01) (10:02) (10:20) (12:00) (20:01) (20:10) (21:00) => should return 12
Testcase#2 (2,1,2,1) => should return 6
Testcase#3 (1,4,8,2) => should return 5
Testcase#4 (4,4,4,4) => should return 0
     */

    public static void main(String arg[]) {
        solve();
    }

    public static void solve() {
        int[][] testcases = { { 1, 0, 0, 2 }, { 2, 1, 2, 1 }, { 1, 4, 8, 2 }, { 4, 4, 4, 4 } };
        for (int[] array : testcases) {
            Set times = new HashSet();
            permutations(times, array, 4);
            System.out.println("Total = " + times.size());
        }
    }

    public static void permutations(Set<String> uniqTimes, int[] array, int size) {
        if (size == 1) {
            // calculate the valid combo
            int h = array[0] * 10 + array[1];
            int m = array[2] * 10 + array[3];
            if (h <= 23 && m <= 59) {
                uniqTimes.add(h+":"+m);
            }
        }
        for (int i = 0; i < size; i++) {
            permutations(uniqTimes, array, size - 1);
            if (size % 2 == 1) {
                //if there are 1 or 3 elements
                swap(array, 0, size - 1);
            } else {
                // if there are 2 or 4 elements0
                swap(array, i, size - 1);
            }
        }
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
