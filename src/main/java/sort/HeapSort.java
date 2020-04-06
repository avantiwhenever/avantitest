package sort;

import java.util.Arrays;

public class HeapSort {
    /*
    https://www.geeksforgeeks.org/heap-sort/
    */
    public static void main(String args[]) {
        int[][] testCases = {{3, 2, -2, 5, -3}, {1, 2, 3, -4}, {1, 1, 1}, {1, 2}, {2}, {}};
        for (int[] testCase : testCases)
            printResult(testCase);
    }

    private static void printResult(int[] piles) {
        System.out.print(Arrays.toString(piles) + " after heapSort = ");
        heapSort(piles);
        System.out.println(Arrays.toString(piles));
    }

    private static void heapSort(int[] nums) {
        int n = nums.length;
        // Build heap (rearrange array)
        for (int i = n/2 -1; i>=0; i--) {
            heapify(nums, n, i);
        }
        // One by one extract an element from heap
        for (int i=n-1; i>0; i--) {
            // Move current root to end
            swap(nums, i, 0);
            // call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private static void heapify(int[] nums, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2
        // If left child is larger than root
        if (l<n && nums[l] > nums[largest]) {
            largest = l;
        }
        // If right child is larger than largest so far
        if (r<n && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }

    private static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}