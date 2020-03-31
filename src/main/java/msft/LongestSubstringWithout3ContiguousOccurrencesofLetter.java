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
        printResult("aaab");
    }

    private static void printResult (String str) {
        System.out.println("Printing validLongestSubstring of string input : "
                + str + " =" + validLongestSubstring(str));
    }
	
	public static String validLongestSubstring(String input) {
		if (input.length() < 3)
			return input;
		int start = 0, end = 1;
		char currentChar = input.charAt(0);
		int count = 1;
		int maxLen = 1;
		int maxLengthStart = 0;

		while (end < input.length()) {
			if (input.charAt(end) == currentChar) {
				count++;
				if (count == 2) {
					if (end - start + 1 > maxLen) {
						maxLen = end - start + 1;
						maxLengthStart = start;
					}
				} else {
					start = end - 1;
				}
			} else {
				currentChar = input.charAt(end);
				count = 1;
				if (end - start + 1 > maxLen) {
					maxLen = end - start + 1;
					maxLengthStart = start;
				}
			}
			
			end++;
		}
		return input.substring(maxLengthStart, maxLengthStart + maxLen);
	}
}
