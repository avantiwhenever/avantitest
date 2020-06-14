package com.testfiles;

import java.util.*;

public class CityTravel2N {

    public static void main(String args[]) {
        int[][] temp = { {10,20}, {30,200}, {400,50}, {30,20}};
        System.out.println("Result of Two city scheduling : " + twoCitySchedCost(temp));
    }

    public static int twoCitySchedCost(int[][] costs) {
        for (int[] cost:costs) {
            System.out.print("  "+Arrays.toString(cost));
        }
        System.out.println();
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o1[1] - (o2[0] - o2[1]);
            }
        });
        for (int[] cost:costs) {
            System.out.print("  "+Arrays.toString(cost));
        }
        System.out.println();
        int total = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; ++i) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }

    public static int twoCitySchedCost2(int[][] costs) {
        System.out.println(Arrays.toString(costs));
        Arrays.sort(costs, (int[] o1, int[] o2)-> (o1[0]- o1[1] - (o2[0] - o2[1])));
        int total = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; ++i) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }
}
