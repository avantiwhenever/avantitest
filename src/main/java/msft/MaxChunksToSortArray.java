package msft;

import java.util.Arrays;

/*
 * https://leetcode.com/discuss/interview-question/524146/
 */
public class MaxChunksToSortArray {
    public static void main(String[] args) {
        printResult(new int[] { 2, 4, 1, 6, 5, 9, 7 });
        printResult(new int[] { 4, 3, 2, 6, 1 });
        printResult(new int[] { 2, 1, 6, 4, 3, 7 });
    }

    private static void printResult(int[] numbers) {
        System.out.print("Integer list- [");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
        System.out.println("]");
        System.out.println("Max chunks- " + solve(numbers));
        System.out.println();
    }


    // Can cause overflow for large nums
    private static int solve(int[] nums) {
        int res = 0, copySum = 0, oriSum = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);

        Arrays.sort(copy);

        for (int i = 0; i < nums.length; i++) {
            copySum += copy[i];
            oriSum += nums[i];
            if (copySum == oriSum)
                res++;
        }
        return res;
    }
}