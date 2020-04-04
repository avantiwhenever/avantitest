package msft;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/discuss/interview-question/525977/
 */
public class LargestNumberXWhichOccursXtimes {

    public static void main(String[] args) {
        printResult(new int[] { 3, 8, 2, 3, 3, 2 }); // 3
        printResult(new int[] { 1, 1 }); // 0
        printResult(new int[] { 7,1,2,8,2 }); // 2
        printResult(new int[] { 3,1,4,1,5 }); //0
        printResult(new int[] { 5,5,5,5,5 }); // 5
        printResult(new int[] { 3, 0, 2, 1, 2 }); // 2
    }

    private static void printResult(int[] numbers) {
        System.out.print("Integer list- [");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
        System.out.println("]");
        System.out.println("Max number X that occurs X times- " + getLargestNum(numbers));
        System.out.println();
    }

    public static int getLargestNum(int[] numbers) {
        Map<Integer, Integer> recordMap = new HashMap<>();
        for (int number : numbers) {
            recordMap.put(number, recordMap.getOrDefault(number, 0) + 1);
        }

        int maxNum = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entity : recordMap.entrySet()) {
            if (entity.getKey().equals(entity.getValue()) && maxNum < entity.getKey()) {
                maxNum = entity.getKey();
            }
        }

        return maxNum == Integer.MIN_VALUE ? 0 : maxNum;
    }
}
