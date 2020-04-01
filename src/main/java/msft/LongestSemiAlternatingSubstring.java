package msft;
/*
https://leetcode.com/discuss/interview-question/398037/
 */

public class LongestSemiAlternatingSubstring {

    public static void main(String[] args) {
        printResult("aabbaabbaabbaabb");
        printResult("abbaabbaaa");
        printResult("aba");
        printResult("bbaaa");
        printResult("aabbaababbaa");
        printResult("aabbababbabaabab");
        printResult("baaab");
    }

    private static void printResult (String str) {
        System.out.println("Printing getLongestSemiAlternatingSubstring of string input : "
                   + str + " =" + getLongestSemiAlternatingSubstring(str));
    }

    public static String getLongestSemiAlternatingSubstring(String input) {
        if (input.length() < 3)
            return input;
        int start = 0;
        int currIndex = 1;
        char compareAgainstChar = input.charAt(start);
        int count = 1;
        int maxLen = 1;

        while (currIndex < input.length()) {
            if (input.charAt(currIndex) == compareAgainstChar) {
                count++;
                if (count == 2 && currIndex - start + 1 > maxLen) {
                    maxLen = currIndex - start + 1;
                } else {
                    //reset the start
                    start = currIndex - 1;
                }
            } else {
                //change compareAgainstChar
                compareAgainstChar = input.charAt(currIndex);
                //resetting the count
                count = 1;
                // check max size
                if (currIndex - start + 1 > maxLen) {
                    maxLen = currIndex - start + 1;
                }
            }
            currIndex++;
        }
        return String.valueOf(maxLen);
    }
}
