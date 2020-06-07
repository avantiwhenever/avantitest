package epi.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ComputeNextPermutation {
    /*
    Write a program that takes as input a permutation, and returns the next permutation
under dictionary ordering. If the permutation is the last permutation, return the
empty array. For example, if the input is (1,0,3, 2) your function should return
(1, 2, 0, 3). If the input is (3, 2,1,0), return ().
     */

    public static void main(String ar[]) {
//        List<Integer> perm = new LinkedList<>();
//        perm.add(3);
//        perm.add(1);
//        perm.add(2);
//        perm.add(0);
//        System.out.println("b4 applyPermutation perm "+ perm + " array : " + nextPermutation(perm));

        List<Integer> array = new LinkedList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        for (int i=0;i<30;i++) {
            System.out.println("applyPermutation perm "+ array + " array : " + nextPermutation(array));
        }
    }

    private static List<Integer> nextPermutation(List<Integer> perm) {
        int k = perm.size() - 2;
        while (k >= 0 && perm.get(k) >= perm.get(k + 1)){
            --k;
        }
        if (k == -1) {
            return Collections.emptyList(); // perm is the last permutation.
        }
        // Swap the smallest entry after index k that is greater than perm[k] . We
// exploit the fact that perm .subList (k + 1, perm.sizeO) is decreasing so
// if we search in reverse order, the first entry that is greater than
// perm[k ] is the smallest such entry.
        for (int i = perm.size() - 1; i > k; --i) {
            if (perm.get(i) > perm.get(k)) {
                Collections.swap(perm, k, i);
                break;
            }
        }
// Since perm . subList[k + 1, perm.size()) is in decreasing order, we can
// build the smallest dictionary ordering of this subarray by reversing it.
        Collections.reverse(perm.subList(k + 1, perm.size()));
        return perm;
    }
}
