package sort;

import java.util.Arrays;

public class MergeSort {
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
        System.out.println(Arrays.toString(piles) + " mergeSort = ");
        mergeSort(piles);
        System.out.println(Arrays.toString(piles));
    }

    private static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
    }

    private static void mergeSort (int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j<= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (i = start; i<=end; i++) {
            nums[i] = temp[i-start];
        }
    }
}