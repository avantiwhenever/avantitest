package msft;

import java.util.HashMap;
import java.util.Map;

public class NumberOfFractionsSumUpTo1 {

    private final static int ModuloNumber = 1000000007;
    public static int twoSumFractions(int[] A, int[] B) {
        if (A.length != B.length) {
            return 0;
        }
        int n = A.length;
        int ans = 0;
        Map<Long, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int numerator = A[i];
            int denominator = B[i];
            //this means that the number is already greater than 1
            if (numerator>denominator) continue;
            int g = gcd(numerator, denominator);
            numerator /=g;
            denominator /=g;
            // fraction=numerator/denominator,
            // we need (denominator-numerator)/denominator for the other term
            long fraction =
                    (long) (denominator-numerator) * ModuloNumber + denominator;
            if (map.containsKey(fraction)) {
                ans = (ans + map.get(fraction)) % ModuloNumber;
            }
            map.put((long) numerator* ModuloNumber + denominator,
                    map.getOrDefault((long) numerator* ModuloNumber +denominator, 0) + 1);
        }
        return ans;
    }

    private static int gcd(int p, int q) {
        return q == 0 ? p : gcd(q, p%q);
    }

    public static void main(String args[]) {
        System.out.println("output : " + (
                twoSumFractions(new int[]{1,1,2}, new int[] {3,2,3})
                == 1));
        System.out.println("output : " + (
                twoSumFractions(new int[]{1,1,1}, new int[] {2,2,2})
                        == 3));
        System.out.println("output : " + (
                twoSumFractions(
                        new int[]{1,2,3,1,2,12,8,4},
                        new int[] {5,10,15,2,4,15,10,5})
                        == 10));
        System.out.println("output : " +
                (twoSumFractions(
                        new int[]{5,6,5}, new int[] {11,11,11})
                        == 2));
    }
}
