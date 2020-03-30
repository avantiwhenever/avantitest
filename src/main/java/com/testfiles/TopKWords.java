package com.testfiles;

import java.util.*;

public class TopKWords {
    public static void main(String[] args)
    {
        printResult(new String[] {"a","b","c","a","b","c","d"}, 2);
        printResult(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4);
    }

    private static void printResult (String[] abc, int k) {
        System.out.println("Printing topKFrequent " + k + "words of "+ Arrays.toString(abc) + " =" +
                topKFrequent(abc, k));
    }

    private static List<String> topKFrequent(String[] words, int k) {
        List<HashSet<String>> buckets = new LinkedList<>();
        buckets.add(new HashSet<>());
        for (String word : words) {
            for (int i=0; i<=k; i++) {
                if (i>=buckets.size()) {
                    buckets.add(i, new HashSet<>());
                }
                if (buckets.get(i).contains(word))
                    continue;
                else {
                    System.out.println("Putting word " + word + " in bucket # " + (i));
                    buckets.get(i).add(word);
                    break;
                }
            }
        }
        List<String> result = new LinkedList<>();
        if (k == buckets.size()) {
            result.addAll(buckets.get(k-1));
            Collections.sort(result);
        }
        return result;
    }
}
