package msft;

/*

https://leetcode.com/discuss/interview-question/398031/

Given a string s containing only a and b, find longest substring of s such that s does
not contain more than two contiguous occurrences of a and b.

Example 1:

Input: "aabbaaaaabb"
Output: "aabbaa"

Example 2:

Input: "aabbaabbaabbaa"
Output: "aabbaabbaabbaa"

Time complexity O(N)
Space complexity O(1)
*/

public class LongestSubstringWithout3ContiguousOccurrencesofLetter {

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
                + str + " =" + validLongestSubstring(str));
    }
	
	public static String validLongestSubstring(String input) {
		if (input.length() < 3)
			return input;
		int start = 0;
		int currIndex = 1;
		char compareAgainstChar = input.charAt(start);
		int count = 1;
		int maxLen = 1;
		int maxLengthStart = 0;

		while (currIndex < input.length()) {
            if (input.charAt(currIndex) == compareAgainstChar) {
                count++;
                if (count == 2 && currIndex - start + 1 > maxLen) {
                    maxLen = currIndex - start + 1;
                    maxLengthStart = start;
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
                    maxLengthStart = start;
                }
            }

            currIndex++;
        }
		return input.substring(maxLengthStart, maxLengthStart + maxLen);
	}
}
