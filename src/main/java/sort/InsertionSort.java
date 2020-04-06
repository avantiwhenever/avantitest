package sort;

import java.util.Arrays;

public class InsertionSort {
    /*
    https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm
     */
    public static void main(String args[]) {
        int[][] testcases = { { 3, 2, -2, 5, -3 }, { 1, 2, 3, -4 }, { 1, 1, 1 } };
        for (int[] testcase : testcases)
            printResult(testcase);
    }

    private static void printResult(int[] piles) {
        System.out.println(Arrays.toString(piles) + " insertionSort = ");
        insertionSort(piles);
        System.out.println(Arrays.toString(piles));
    }

    private static void insertionSort(int[] nums){
        for (int i=0; i<nums.length; i++) {
            int itemToFindPlace = nums[i];
            int j = i;
            for (; j > 0 && nums[j-1] > itemToFindPlace; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = itemToFindPlace;
        }
    }
}
