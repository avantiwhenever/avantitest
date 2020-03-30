package com.testfiles;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumberLetterCombinations {

    public static void main(String[] args)
    {
        printResult("234");
    }

    private static void printResult (String abc) {
        System.out.println("Printing letterCombinations of "+ abc + " =" +
                letterCombinations(abc));
    }

    public static String[] mapping = new String[] {"0", "1", "abc", "def",
            "ghi", "jkl", "mno", "pqrs",
            "tuv", "wxyz"};
    public static  List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.isEmpty()) { return result; }
        result.add("");
        int temp = 0;
        while(result.peek().length() != digits.length()) {
            String remove = result.remove();
            System.out.println("Removed string : " + remove);
            String map = mapping[digits.charAt(remove.length())-'0'];
            for (char c : map.toCharArray()) {
                System.out.println("Adding string : " + remove + " + " + c );
                result.addLast(remove+c);
                temp ++;
            }
        }
        System.out.println("Print total number of calls " + temp + " result length : "  +result.size());
        return result;
    }

}
