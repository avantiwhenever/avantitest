package msft;

public class MinDeletionsToObtainStringInRightFormat {
    /*
     * https://leetcode.com/discuss/interview-question/421975/
     */
    public static void main(String[] args) {
        printResult("AA");
        printResult("BB");
        printResult("ABA");
        printResult("BAA");
        printResult("AAB");
        printResult("BAAABAB");
        printResult("BBABAA");
        printResult("AABBBB");
        printResult("AABBBBA");
        printResult("BBBBA");
    }

    private static void printResult(String str) {
        System.out.println("Original string " + str + ". Min deletions - " + getMinDeletions(str));
    }

    private static int getMinDeletions(String s) {
        int rhs = 0, lhs = 0;
        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == 'A')
                ++rhs;
        // rhs equals number of A's after index i [inclusive]
        // lhs equals number of B's before index i [exclusive]
        int ans = rhs;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'A')
                --rhs;
            else
                ++lhs;
            ans = Math.min(ans, rhs + lhs);
        }
        return ans;
    }
}
