package epi.dp;

import java.util.*;

public class TriangleMinPath {

    /*
    FIND THE MINIMUM WEIGHT PATH IN A TRIANGLE
A sequence of integer arrays in which the nth array consists of n entries naturally
corresponds to a triangle of numbers. See Figure 17.10 for an example.
Define a path in the triangle to be a sequence of entries in the triangle in which
adjacent entries in the sequence correspond to entries that are adjacent in the triangle.
The path must start at the top, descend the triangle continuously, and end with an
entry on the bottom row. The weight of a path is the sum of the entries.
Write a program that takes as input a triangle of numbers and returns the weight of
a minimum weight path. For example, the minimum weight path for the number
triangle in Figure 17.10 is shown in bold face, and its weight is 15.
Hint: What property does the prefix of a minimum weight path have?

A far better way is to consider entries in the ith row. For any such entry, if you
look at the minimum weight path ending at it, the part of the path that ends at the
previous row must also be a minimum weight path. This gives us a DP solution. We
iteratively compute the minimum weight of a path ending at each entry in Row i.
Since after we complete processing Row i, we do not need the results for Row i —1to
process Row i+1, we can reuse storage.
     */
    static List<Integer> one1 = Arrays.asList(2);
    static List<Integer> two1 = Arrays.asList(4,4);
    static List<Integer> three1 = Arrays.asList(8,5,6);
    static List<Integer> four1 = Arrays.asList(4,2,6,2);
    static List<Integer> five1 = Arrays.asList(1,5,2,3,4);

    public static void main(String args[]) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(one1); list.add(two1); list.add(three1);
        list.add(four1); list.add(five1);
        printResult(list);
    }

    private static void printResult(List<List<Integer>> list) {
        System.out.println("Total min path sum for : " + list
         + " is = " + minimumPathTotal(list));
    }

    /*
    The time spent per element is 0(1) and there are 1 + 2 + ---- + n = n(n + l)/2 elements,
implying an 0(n^2) time complexity. The space complexity is 0(n).
     */
    private static int minimumPathTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty())
            return 0;
        // As we iterate, prevRow stores the minimum path sum to each entry in
        // triangle.get(i - 1).
        List<Integer> prevRow = new ArrayList<>(triangle.get(0));
        for (int i = 1; i < triangle.size(); ++i) {
            // Stores the minimum path sum to each entry in triangle.get(i) .
            List<Integer> currRow = new ArrayList<>(triangle.get(i));
            // For the first element.
            currRow.set(0, currRow.get(0) + prevRow.get(0));
            for (int j = 1; j < currRow.size() - 1; ++j) {
                currRow.set(j, currRow.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
            }
            // For the last element
            currRow.set(currRow.size() - 1, currRow.get(currRow.size() - 1)
                    + prevRow.get(prevRow.size() - 1));
            System.out.println("prevRow" + prevRow);
            System.out.println("currRow" + currRow);
            prevRow = currRow;
        }
        System.out.println("prevRow" + prevRow);
        return Collections.min(prevRow);
    }
}