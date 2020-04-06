package msft;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationError {

    public static void main(String[] args) {

        printResult(2,4);
        printResult(3,20);
        printResult(5,6);
        printResult(1,4);
    }

    private static void printResult(int n, int k) {
        System.out.println("Getting combinatio of strings for N = " + n + " and K = " + k +
                " result = " + Arrays.toString(solution(n,k)));
    }

    private static String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<>();
        for (String p: solution(N-1, K-1)) {
            for (char l : new char[]{'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen-1) != l) {
                    result.add(p+l);
                }
            }
        }
        int perfSize = Math.min(result.size(), K);
        return result.subList(0, perfSize).toArray(new String[perfSize]);
    }
}
