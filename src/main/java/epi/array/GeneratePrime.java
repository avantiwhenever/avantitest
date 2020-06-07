package epi.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratePrime {

    public static void main(String ar[]) {
        System.out.println("Prime number "+ generatePrimes(100));
    }

    // Given n, return all primes up to and including n.
    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        // isPrime.get(p) represents if p is prime or not. Initially , set each
        // to true, excepting 0 and 1. Then use sieving to eliminate nonprimes.
        boolean[] isComposite = new boolean[n+1];
        isComposite[0] = true;
        isComposite[1] = true;
        for (int p = 2; p <= n; ++p) {
            if (!isComposite[p] ) {
                primes.add(p);
                // Sieve p’s multiples.
                for (int j = p; j <= n; j += p) {
                    isComposite[j] = true;
                }
            }
        }
        return primes;
    }
}
