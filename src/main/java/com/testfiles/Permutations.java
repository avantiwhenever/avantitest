package com.testfiles;

import java.util.ArrayList;
import java.util.List;

// Java program to print all the permutations
// of the given string
public class Permutations {

    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);

        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i)
                        + word.substring(i + 1, word.length()));
            }
        }

    }

    // Driver code
    public static void main(String[] args)
    {
//        String s = "abb";
//        List<String> stringArrayList = new ArrayList<>();
//        String world = "";
//        permutation("", s);
        String[] stringArray = new String[] {"A","B","C"};
        List<List<String>>  result = permute(stringArray);
        printListofResult(result);
    }

    private static void printListofResult(List<List<String>> result) {
        for (List<String> res : result) {
            for (String r : res) {
                System.out.print(r);
            }
            System.out.println();
        }
    }

    private static List<List<String>> permute(String[] num) {
        List<List<String>> finalAnswer = new ArrayList();
        if (num.length == 0) return finalAnswer;
        List<String> firstElement = new ArrayList();
        firstElement.add(num[0]);
        finalAnswer.add(firstElement);
        for (int i = 1; i < num.length; ++i) {
            List<List<String>> intermediateAns = new ArrayList();
            for (int j = 0; j <= i; ++j) {
                for (List<String> allAnswers : finalAnswer) {
                    List<String> newStringList = new ArrayList(allAnswers);
                    newStringList.add(j, num[i]);
                    //System.out.println(newStringList + "\t"+ i + "\t"+ j +" " + l);
                    intermediateAns.add(newStringList);
                    System.out.println(intermediateAns + "\t"+ i + "\t"+ j +" " + allAnswers);
                }
            }
            finalAnswer = intermediateAns;
        }
        return finalAnswer;
    }
}
