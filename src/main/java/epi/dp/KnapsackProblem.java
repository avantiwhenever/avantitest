package epi.dp;

import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {
    /*
     Write a program for the knapsack problem that selects a subset of items that has
maximum value and satisfies the weight constraint. All items have integer weights
and values. Return the value of the subset
     */

    private static class Item {
        public Integer value;
        public Integer weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "value : " + value + ", weight :" + weight + "\n";
        }
    }

    public static void main(String args[]) {
        printResult(Arrays.asList(new Item(60, 5),
                new Item(50, 3),
                new Item(70, 5),
                new Item(30, 1)), 5);
    }

    public static void printResult(List<Item> items, int capacity){
        System.out.println("Optimal capacity for \n"+ items
                + " and given capacity: "  + capacity + " = " +
                optimumItemtoCapacity(items, capacity));
    }

    public static int optimumItemtoCapacity(List<Item> items, int capacity) {
        int[][] opt = new int[items.size()][capacity+1];
        for (int[] v : opt) {
            Arrays.fill(v, -1);
        }
        return findOptimumItemToCapacity(items, items.size()-1, capacity, opt);
    }

    private static int findOptimumItemToCapacity(List<Item> items, int k,
                                                 int availableCapacity, int[][] opt) {
        if (k < 0) {
            return 0;
        }
        if (opt[k][availableCapacity] == -1) {
            int withoutCurrltem  =
                    findOptimumItemToCapacity(items , k - 1, availableCapacity, opt);
            int withCurrltem
                    = availableCapacity < items.get(k).weight
                    ? 0 :
                    items.get(k).value +
                            findOptimumItemToCapacity(items , k - 1 , availableCapacity - items.get(k).weight , opt);
            opt[k][availableCapacity] = Math.max(withoutCurrltem, withCurrltem);
        }
        return opt[k][availableCapacity];
    }
    /*
    The algorithm computes V[n - 1][zv] in 0(nw) time, and uses 0(nw) space.
     */
}
