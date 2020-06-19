package epi.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String arg[]) {
        List<List<Integer>> result = combinations(4, 2);
    }

    // GENERATE ALL SUBSETS OF SIZE k
    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        directedCombinations(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private static void directedCombinations(int n, int k, int offset,
                                             ArrayList<Integer> partialCombination,
                                             List<List<Integer>> result) {
        if (partialCombination.size() == k) {
            System.out.println(partialCombination);
            result.add(new ArrayList<Integer>(partialCombination));
            return;
        }
        final int numRemaining = k - partialCombination.size();
        for (int i = offset; i<=n && numRemaining <= n-i+1; i++) {
            partialCombination.add(i);
            directedCombinations(n, k, i+1, partialCombination, result);
            partialCombination.remove(partialCombination.size()-1);
        }
    }
    
}
