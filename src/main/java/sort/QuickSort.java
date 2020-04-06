package sort;

import java.util.Arrays;

public class QuickSort {
    /*
    https://www.interviewbit.com/tutorial/merge-sort-algorithm/
    https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm
     */
    public static void main(String args[]) {
        int[][] testCases = {{3, 2, -2, 5, -3}, {1, 2, 3, -4}, {1, 1, 1}, {1, 2}, {2}, {}};
        for (int[] testCase : testCases)
            printResult(testCase);
    }

    private static void printResult(int[] piles) {
        System.out.print(Arrays.toString(piles) + " after quickSort = ");
        quickSort(piles);
        System.out.println(Arrays.toString(piles));
    }

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int partition = partition(nums, start, end);
            quickSort(nums, start, partition-1);
            quickSort(nums, partition+1, end);
        }
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = (start-1);
        for (int j = start; j<end; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        int swapIndex = i+1;
        swap(nums, swapIndex, end);
        return swapIndex;
    }

    private static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}