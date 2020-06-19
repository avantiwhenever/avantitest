package msft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedStringLengthWithUniqueCharacters {

/*
 https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.
Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.

Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".

Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26

     */
    public static void main(String[] args) {
        printResult(Arrays.asList("un","iq","ue")); // uniq
        printResult(Arrays.asList("cha","r","act","ers")); // chaers
        printResult(Arrays.asList("abcdefghijklmnopqrstuvwxyz"));
        printResult(Arrays.asList("av","nt","ii")); // avnt
        printResult(Arrays.asList("my","luvi","luvi")); // myluvi
    }

    private static void printResult(List<String> wordList) {
        System.out.println("List of words is- "
                + Arrays.toString(wordList.toArray())
                + " -> Length of max word is " + maxLength(wordList));
    }

    private static int maxLength(List<String> arr) {
        return process(arr, "", 0);
    }

    private static int process(List<String> arr, String soFar, int index) {
        if (index > arr.size()) return 0;
        Set<Character> set = new HashSet<>();
        for(char c: soFar.toCharArray()) {
            if(set.contains(c)) return 0;
            set.add(c);
        }
        int max = soFar.length();
        for(int i = index; i < arr.size(); i++) {
            max = Math.max(max, process(arr, soFar + arr.get(i), i + 1));
        }
        return max;
    }
}