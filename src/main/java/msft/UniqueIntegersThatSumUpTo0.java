package msft;
/*

https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
1304. Find N Unique Integers Sum up to Zero
Given an integer n, return any array containing n unique integers such
 that they add up to 0.

 */
public class UniqueIntegersThatSumUpTo0 {
    /*
        Intuition
        Naive idea
        n = 1, [0]
        n = 2, [-1, 1]

        Now write more based on this
        n = 3, [-2, 0, 2]
        n = 4, [-3, -1, 1, 3]
        n = 5, [-4, -2, 0, 2, 4]

        It spreads like the wave.
        Explanation
        Find the rule
        A[i] = i * 2 - n + 1

        Complexity
        Time O(N)
        Space O(N)
         */
    public int[] sumZero(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; ++i)
            A[i] = i * 2 - n + 1;
        return A;
    }


}
