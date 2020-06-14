package epi.array;

import java.util.Arrays;

public class MergeTwoArrays {

    public static void main(String a[]) {
        System.out.println(Arrays.toString(mergeTwoArraysExtraMemory(new int[] {1,2,3,4,5,6}, 3)));
        System.out.println(Arrays.toString(mergeTwoArraysExtraMemory(new int[] {1,2,3,4,5,6}, 3)));
    }

    private static int[] mergeTwoArraysExtraMemory(int[] arr, int n) {
        int[] result = new int[2*n];
        if (arr.length != n *2) {
            return result;
        }
        int start1 = 0, start2 = n;
        int end1 = n-1, end2 = 2*n;
        int count = 0;
        for (int i=start1, j = start2; i<=end1 && j<=end2; i++, j++) {
            result[count++] = arr[i];
            result[count++] = arr[j];
        }
        return result;
    }

    private static int[] mergeTwoArraysInPlace(int[] arr, int n) {
        if (arr.length != n *2) {
            return null;
        }
        int start1 = 0, start2 = n;
        int end1 = n-1, end2 = 2*n;
        int count = 0;
        arr[count++] = arr[0];
        int prev = 0;
        for (int i=start1+1, j = start2; i<=end1 && j<=end2; i++, j++) {
            prev = arr[i];
            if (count%2 == 0) {
                arr[count++] = arr[j];
            } else {
                arr[count++] = prev;
            }
        }
        return arr;
    }
}