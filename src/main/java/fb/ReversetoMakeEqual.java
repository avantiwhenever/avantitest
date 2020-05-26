package fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReversetoMakeEqual {
    /*
    Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
    Signature
    bool areTheyEqual(int[] arr_a, int[] arr_b)
    Input
    All integers in array are in the range [0, 1,000,000,000].
    Output
    Return true if B can be made equal to A, return false otherwise.
    Example
    A = [1, 2, 3, 4]
    B = [1, 4, 3, 2]
    output = true
    After reversing the subarray of B from indices 1 to 3, array B will equal array A.
    */
    // Add any helper functions you may need here

    public static void main(String args[]) {
        String str = "Are the two arrays equal? = ";
        System.out.println(str + areTheyEqual(new int[]{1,2,3,4}, new int[]{2,1,3,4}));
        System.out.println(str + areTheyEqual2(new int[]{1,2,3,4}, new int[]{2,1,3,4}));
    }

    private static boolean areTheyEqual(int[] array_a, int[] array_b) {
        long time = System.nanoTime();
        Arrays.sort(array_a); //nlogn
        Arrays.sort(array_b); //nlogn
        boolean val =  Arrays.equals(array_a, array_b); //n
        System.out.println("Time taken by areTheyEqual : "  + (System.nanoTime() - time));
        return val;
        //nlog(n)
    }

    private static boolean areTheyEqual2(int[] array_a, int[] array_b) {
        long time = System.nanoTime();
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : array_a) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for(int a : array_b) {
            if (map.containsKey(a)) {
                int result = map.get(a);
                if (result == 1) {
                    map.remove(a);
                } else {
                    map.put(a, result-1);
                }
            } else {
                return false;
            }
        }
        System.out.println("Time taken by areTheyEqual2 : "  + (System.nanoTime() - time));
        return map.isEmpty();
    }

//    private static boolean areTheyEqual3(int[] array_a, int[] array_b) {
//
//    }
}
