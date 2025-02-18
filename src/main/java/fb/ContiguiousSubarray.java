package fb;

import java.util.Arrays;
import java.util.Stack;

public class ContiguiousSubarray {

    private static int[] countSubarrays(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] cntLR = buildLeftToRight(nums);
        int[] cntRL = buildRightToLeft(nums);
        for(int i=0;i<length;i++) {
            res[i] = (cntLR[i] == -1 ? length - i : cntLR[i] - i) + (cntRL[i] == -1 ? i + 1 : i - cntRL[i]) - 1;
        }
        return res;
    }

    private static int[] buildRightToLeft(int[] nums) {
        int length = nums.length;
        Stack<Integer> stackRL = new Stack<>();
        int[] cntRL = new int[length];
        Arrays.fill(cntRL, -1);
        for(int i=length-1;i>=0;i--) {
            while(!stackRL.isEmpty() && nums[stackRL.peek()] < nums[i]) {
                cntRL[stackRL.pop()] = i;
            }
            stackRL.push(i);
        }
        return cntRL;
    }

    private static int[] buildLeftToRight(int[] nums) {
        Stack<Integer> stackLR = new Stack<>();
        int length = nums.length;
        int[] cntLR = new int[length];
        Arrays.fill(cntLR, -1);
        for(int i=0;i<length;i++) {
            while(!stackLR.isEmpty() && nums[stackLR.peek()] < nums[i]) {
                cntLR[stackLR.pop()] = i;
            }
            stackLR.push(i);
        }
        return cntLR;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }
    public void run() {
        int[] test_1 = {3, 4, 1, 6, 2};
        int[] expected_1 = {1, 3, 1, 5, 1};
        int[] output_1 = countSubarrays(test_1);
        check(expected_1, output_1);

        int[] test_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {1, 2, 6, 1, 3, 1};
        int[] output_2 = countSubarrays(test_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new ContiguiousSubarray().run();
    }

}
