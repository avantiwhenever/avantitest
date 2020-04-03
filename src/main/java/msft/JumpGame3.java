package msft;

public class JumpGame3 {
    /*
     * https://leetcode.com/discuss/interview-question/451482/ Same as -
     * https://leetcode.com/problems/jump-game-iii/
     */
    public static void main(String[] args) {
        printResult(new int[] { 3, 4, 2, 3, 0, 3, 1, 2, 1 }, 7); // left -> left -> right
        printResult(new int[] { 0 }, 0); //
        printResult(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 5); // index 5 -> index 4 -> index 1 -> index 3
        printResult(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 0); // index 0 -> index 4 -> index 1 -> index 3
        printResult(new int[] { 3, 0, 2, 1, 2 }, 2); // There is no way to reach at index 1 with value 0.
    }

    private static void printResult(int[] integers, int startPosition) {
        System.out.print("Integer list- [");
        for (int number : integers) {
            System.out.print(number + ", ");
        }
        System.out.println("]. Start position is " + startPosition);
        System.out.println("Is it possible to reach value 0 ? - " + canReach(integers, startPosition));
        System.out.println();
    }

    private static boolean canReach(int[] arr, int start) {
        if (start > arr.length - 1 || start < 0)
            return false;
        if (arr[start] == 0)
            return true;
        int step = arr[start];
        arr[start] += arr.length;
        return canReach(arr, start - step) || canReach(arr, start + step);
    }
}
