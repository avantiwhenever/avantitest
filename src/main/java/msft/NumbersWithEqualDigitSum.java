package msft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumbersWithEqualDigitSum {

    public static void main(String[] args) {
        printResult(new int[] {51, 71, 17, 42, 33, 44, 24, 62});
        printResult(new int[] {51, 71, 17, 42});
        printResult(new int[] {42, 33, 60});
        printResult(new int[] {51, 32, 43});
    }

    private static void printResult (int[] nums) {
        System.out.println("Printing maxSumOfTwoDigits of two digits "
                + Arrays.toString(nums) + " =" + maxSumOfTwoDigits(nums));
    }

    private static int maxSumOfTwoDigits(int[] nums) {
        int len = nums.length;
        int result = -1;
        if (len <=1) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int sumOfDigits = getSumOfDigits(nums[i]);
            if (!map.containsKey(sumOfDigits)) {
                map.put(sumOfDigits, nums[i]);
            } else {
                int sumOfDigitNum = map.get(sumOfDigits);
                result = Math.max(result, sumOfDigitNum + nums[i]);
                map.put(sumOfDigits, Math.max(nums[i], sumOfDigitNum));
            }
        }
        return result;

    }

    private static int getSumOfDigits(int num) {
        int absoluteNumber = Math.abs(num);
        int result = 0;
        while (absoluteNumber != 0) {
            result += absoluteNumber % 10;
            absoluteNumber = absoluteNumber / 10;
        }
        return result;
    }
}
