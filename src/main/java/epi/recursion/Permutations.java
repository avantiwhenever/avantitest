package epi.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String arg[]) {
        List<List<Integer>> result = generatePermutations(Arrays.asList(1,2,3,4));
    }
    //The time complexity T(n) is
    // O(n X n!), since we do O(n) computation per call outside of the recursive calls.
    public static List<List<Integer>> generatePermutations(List<Integer> n) {

        List<List<Integer>> result = new ArrayList<>();
        generatePermute(0, n, result);
        return result;
    }

    private static void generatePermute(int i, List<Integer> n, List<List<Integer>> result) {
        if (i == n.size()-1) {
            System.out.println(Arrays.toString(n.toArray()));
            result.add(new ArrayList<>(n));
            return;
        }
        for (int j=i ; j<n.size(); j++) {
            Collections.swap(n, i, j);
            generatePermute(i+1, n, result);
            Collections.swap(n, i, j);
        }
    }

}
