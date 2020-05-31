package com.testfiles;

import java.util.Arrays;

public class SimilarStringGroups {

/*
Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
Also two strings X and Y are similar if they are equal.
For example, "tars" and "rats" are similar (swapping at positions 0 and 2),
and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.
Notice that "tars" and "arts" are in the same group even though they are not similar.
Formally, each group is such that a word is in the group if and only if it is similar to at
least one other word in the group.
We are given a list A of strings.
Every string in A is an anagram of every other string in A.  How many groups are there?
==========================================================================================
Example 1:
Input: A = ["tars","rats","arts","star"]
Output: 2

Constraints:
1 <= A.length <= 2000
1 <= A[i].length <= 1000
A.length * A[i].length <= 20000
All words in A consist of lowercase letters only.
All words in A have the same length and are anagrams of each other.
The judging time limit has been increased for this question.
*/

   static class QuickUniqueGroups {
       private int[] ids;
       private int[] weights;
       private int groups;

       QuickUniqueGroups(int N) {
           ids = new int[N];
           weights = new int[N];
           for (int i = 0; i < N; i++) {
               ids[i] = i;
               weights[i] = 1;
           }
           groups = N;
       }

       private void union(int i, int j) {
           int ri = root(i);
           int rj = root(j);
           if (ri == rj) return;
           if (weights[ri] > weights[rj]) {
               ids[rj] = ri;
               weights[rj] += weights[ri];
           } else {
               ids[ri] = rj;
               weights[ri] += weights[rj];
           }
           --groups;
       }

       private int root(int i) {
           while (i != ids[i]) {
               ids[i] = ids[ids[i]];
               i = ids[i];
           }
           return ids[i];
       }

       int getGroups() {
           return groups;
       }
   }

   private static int numSimilarGroups(String[] words) {
       QuickUniqueGroups quickUniqueGroups = new QuickUniqueGroups(words.length);
       for (int compareWordIdx = 0; compareWordIdx < words.length; compareWordIdx++) {
           int lenOfString = words[compareWordIdx].length();
           for (int wordIdx = compareWordIdx + 1; wordIdx < words.length; wordIdx++) {
               int count = 0;
               for (int strIdx = 0; strIdx < lenOfString; strIdx++) {
                   if (words[compareWordIdx].charAt(strIdx) != words[wordIdx].charAt(strIdx)) {
                       ++count;
                   }
                   if (count > 2) {
                       break;
                   }
               }
               if (count <= 2) {
                   quickUniqueGroups.union(compareWordIdx, wordIdx);
               }
           }
       }
       return quickUniqueGroups.getGroups();
   }

   private static void printResult(String[] a){
    System.out.println("Result of groups for input :" + Arrays.toString(a) +
            " = " + numSimilarGroups(a));
   }

   public static void main(String[] arg) {
       printResult(new String[]{"abcd", "adbc"});
       printResult(new String[]{"abcd", "abcd"});
       printResult(new String[]{"xyz", "xqz"});
   }
}
