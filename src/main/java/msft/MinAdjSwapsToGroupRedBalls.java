package msft;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/discuss/interview-question/414660/

https://leetcode.com/discuss/interview-question/125154/
Given a string contains only "B"s and "G"s indicated a sequence of students, while "B" means a boy and "G" means a girl. Write a function called minSwaps(students, k) to calculate the minimum swaps need to make k girls sitting together. Note that you could only swap two students if they are adjacent.

Example 1:

Input: students = "BGGBBG", k = 3
Output: 2
Example 2:

Input: students = "BGGBGBGBBGGG", k = 4
Output: 2

 */
public class MinAdjSwapsToGroupRedBalls {

    public static void main(String[] args) {
        printResult("RRRWRR");
        printResult("WWWRWWW");
        printResult("WRRWRW");
        printResult("WWWRWWWRWR");
        printResult("WWW");
    }

    private static void printResult(String givenString) {
        System.out.println("Given string - " + givenString +
                ". MinAdjSwapsToGroupRedBalls - " + getMinAdjSwapsToGroupRedBalls(givenString));
    }

    private static int getMinAdjSwapsToGroupRedBalls(String s) {
        List<Integer> redIndices = getRedIndices(s);
        int mid = redIndices.size() / 2;
        int minSwaps = 0;
        for (int i = 0; i < redIndices.size(); i++) {
            // number of swaps for each R is the distance to mid, minus the number of R's between them
            minSwaps += Math.abs(redIndices.get(mid) - redIndices.get(i)) - Math.abs(mid - i);
        }
        return minSwaps;
    }

    private static List<Integer> getRedIndices(String s) {
        List<Integer> indices = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                indices.add(i);
            }
        }
        return indices;
    }
}
