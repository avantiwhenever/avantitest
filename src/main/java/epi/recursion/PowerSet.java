package epi.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    public static void main(String args[]) {
        generatePowerSet(Arrays.asList(1,2,3,4));
    }

    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        List<List<Integer>> powerSet = new ArrayList<>();
        directedPowerSet(inputSet, 0, new ArrayList<Integer>(), powerSet);
        return powerSet;
    }

    private static void directedPowerSet(List<Integer> inputSet, int tobeSelected,
                                         ArrayList<Integer> selectedSoFar,
                                         List<List<Integer>> powerSet) {
        if (tobeSelected == inputSet.size()) {
            System.out.println(selectedSoFar);
            powerSet.add(new ArrayList<>(selectedSoFar));
            return;
        }
        // Generate all subsets that contain inputSet[toBeSelected].
        selectedSoFar.add(inputSet.get(tobeSelected));
        directedPowerSet(inputSet, tobeSelected + 1, selectedSoFar, powerSet);
        // Generate all subsets that do not contain inputSet[toBeSelected].
        selectedSoFar.remove(selectedSoFar.size()-1);
        directedPowerSet(inputSet, tobeSelected + 1, selectedSoFar, powerSet);
    }
}
