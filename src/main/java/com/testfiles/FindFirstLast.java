package com.testfiles;

public class FindFirstLast {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,7,7,7,7,8,9,9,9,9,10};
        System.out.println("Find the target from  : ");
        printArray(numbers);
        System.out.println("Returned result : ");
        printArray(searchFirstLastIndex(numbers, 7));
    }

    private static int[] searchFirstLastIndex(int[] numbers, int target) {
        int[] result = {-1,-1};
        int leftIndex = binarySearch(numbers, 0, numbers.length, target, true);
        if (leftIndex == numbers.length && target != numbers[leftIndex]) {
            return result;
        }
        int rightIndex = binarySearch(numbers, leftIndex, numbers.length, target, false);
        result[0] = leftIndex;
        result[1] = rightIndex-1;
        return result;
    }

    private static int binarySearch(int[] numbers,
                                    int lo, int high,
                                    int target, boolean left) {

        while(lo < high) {
            int mid = (high + lo) / 2;
            if (numbers[mid] > target ||
                    (left && target == numbers[mid])) {
                high = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }

    private static void printArray(int[] array) {
        for (int arr: array) {
            System.out.print(arr + " ");
        }
        System.out.println("");
    }

}
