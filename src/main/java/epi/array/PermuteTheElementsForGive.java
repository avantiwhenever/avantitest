package epi.array;

import java.util.*;

public class PermuteTheElementsForGive {
    // PERMUTE THE ELEMENTS OF AN ARRAY
    /*
    Any permutation can be viewed as a set of cyclic permutations.
     For an element in a cycle, how would you identify if it has been permuted?
     */

    public static void main(String ar[]) {
        List<Integer> perm = new LinkedList<>();
        perm.add(3);
        perm.add(1);
        perm.add(2);
        perm.add(0);
        List<Integer> array = new LinkedList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        System.out.println("b4 applyPermutation perm "+ perm + " array : " + array);
        applyPermutation(perm, array);
        System.out.println("applyPermutation perm "+ perm + " array : " + array);
    }

    private static void applyPermutation(List<Integer> perm, List<Integer> A) {
        for (int i = 0; i < A.size(); ++i) {
            // Check if the element at index i has not been moved by checking if
            // perm. get (i) is nonnegative .
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
            // Subtracts perm.size() from an entry in perm to make it negative ,
            // which indicates the corresponding move has been performed .
                perm.set(next, perm.get(next) - perm.size());
                next = temp;
            }
        }
        System.out.println("perm " +  perm);
        // Restore perm.
        for (int i = 0; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }
    }
}