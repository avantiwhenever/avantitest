package epi.recursion;

import java.util.ArrayList;
import java.util.List;

public class nqueens {
    //GENERATE ALL NONATTACKING PLACEMENTS OF n-Queens
    public static void main(String arg[]) {
        List<List<Integer>> result = nQueems(5);
        printResult(result);
    }

    private static void printResult(List<List<Integer>> result) {
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<List<Integer>> nQueems(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void solveNQueens(
            int n, int row,
            ArrayList<Integer> colPlacement,
            List<List<Integer>> result) {
        if (row == n) {
            //All queens are legally placed
            result.add(new ArrayList<>(colPlacement));
        } else {
            for (int col=0; col< n; col++) {
                colPlacement.add(col);
                if (isValid(colPlacement)) {
                    solveNQueens(n, row + 1, colPlacement, result);
                }
                colPlacement.remove(colPlacement.size()-1);
            }
        }
    }

    private static boolean isValid(ArrayList<Integer> colPlacement) {
        int rowId = colPlacement.size()-1;
        for(int i=0; i<rowId; i++) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowId));
            if (diff == 0 || diff == rowId - i) {
                return false;
            }
        }
        return true;
    }
}
