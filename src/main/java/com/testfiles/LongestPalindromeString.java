package com.testfiles;

public class LongestPalindromeString {

    public static void main(String[] args)
    {
        String[] str = new String[] {
                "", "i", "avanti", "ashwin", "patil", "kalabhor", "alaka", "alala"
        };
        for (String string : str) {
            printResult(string);
        }
    }

    private static void printResult (String string) {
        System.out.println("Longest Palindrome of string " + string + " = " + longestPalindrome(string));
    }

    private static String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        boolean dp[] = new boolean[len];
        int start = 0;
        int maxLen = 0;
        for(int left = len - 1; left >= 0; left--){
            for(int right = len - 1; right >= left; right--){
                dp[right] = (s.charAt(left) == s.charAt(right))
                        && (right - left < 2 || dp[right - 1]);
                if(dp[right] && maxLen < right - left + 1){
                    start = left;
                    maxLen = right - left + 1;
                }
                printFromLeftToRight(left, right, dp);
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static void printFromLeftToRight(int left, int right, boolean[] dp) {
        for (int i=left; i<right; i++) {
            System.out.print("dp[" + i +"] = " + dp[i] + ", ");
        }
        System.out.println();
    }
}
