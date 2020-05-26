package epi.array;

import java.util.Arrays;

public class evenOddEntries {

    /*
    Your input is an array of integers, and you have to reorder its entries so that
    the even entries appear first.
     */

    public static void main(String args[]) {
        int[] arr1 = new int[] {1,2,3,4,5,6,7,8};
        int[] arr2 = new int[] {1,3,6,9,16,3,6666,5,8};
        printResult(arr1);
        printResult(arr2);
    }

    public static void printResult(int[] arr) {
        System.out.println("Before arr "+ Arrays.toString(arr));
        moveEvenEntriesBefore(arr);
        System.out.println("After arr "+ Arrays.toString(arr));
    }

    public static void moveEvenEntriesBefore(int arr[]) {
        int nextEven = 0, nextOdd = arr.length-1;
        while (nextEven < nextOdd) {
            if (arr[nextEven] %2 == 0) {
                nextEven++;
                //keep the number where it it
            } else {
                //swap it at the odd space
                int temp = arr[nextEven];
                arr[nextEven] = arr[nextOdd];
                arr[nextOdd--] = temp;
            }
        }
    }
    /*
    space complexity is clearly 0(1)—a couple of variables that hold
    indices, and a temporary variable for performing the swap.
    We do a constant amount of processing per entry, so the time complexity is 0(n).
     */
}
