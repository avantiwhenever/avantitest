package epi.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchEngineMatchEachWordFromDictionary {
    /*
    Suppose you are designing a search engine. In addition to getting keywords from
a page's content, you would like to get keywords from Uniform Resource Locators
(URLs). For example, bedbathandbeyond.com yields the keywords"bed, bath, beyond,
bat, hand": the first two coming from the decomposition "bed bath beyond" and the
latter two coming from the decomposition "bed bat hand beyond".
Given a dictionary i.e., a set of strings, and a name, design an efficient algorithm that
checks whether the name is the concatenation of a sequence of dictionary words. If
such a concatenation exists, return it. A dictionary word may appear more than once
in the sequence, e.g., "a", "man", "a", "plan", "a", "canal" is a valid sequence for
"amanaplanacanal".
Hint: Solve the generalized problem, i.e., determine for each prefix of the name whether it is the
concatenation of dictionary words.
     */

    public static void main(String args[]) {
        printResults("avanti", Arrays.asList("a","av","ant"));
        printResults("bedbathandbeyond", Arrays.asList("bed", "bath", "and", "beyond", "bat", "hand"));
    }

    private static void printResults(String string, List<String> list) {
        List<String> result = decomposeEntireStringIntoDictionaryWords(string, new HashSet<>(list));
        System.out.println("Getting the string : "+ string +
                " and dictionary as : " + list +
                " : result is : " + result);
    }

    private static List<String> decomposeEntireStringIntoDictionaryWords(
            String domain, Set<String> dictionary) {
        int[] lastLength = new int[domain.length()];
        Arrays.fill(lastLength , -1);
        // When the algorithm finishes , lastLength[i] != -1 indicates
        // domain.substring(SI , i + 1) has a valid decomposition, and the length of
        // the last string in the decomposition will be lastLength[i].
        for (int i = 0; i < domain.length(); ++i) {
        // If domain.substring(0, i + 1) is a valid word, set lastLength[i] to the
        // length of that word.
            if (dictionary.contains(domain.substring(0 , i + 1))) {
                lastLength[i] = i + 1;
                System.out.println("lastlength " + Arrays.toString(lastLength));
            }
            // If lastLength[i] = -1 look for j < i such that domain.substring(SI, j +
            // 1) has a valid decomposition and domain.substring(j + 1, i + 1) is a
            // dictionary word. If so, record the length of that word in
            // lastLength[i].
            if (lastLength[i] == -1) {
                for (int j = 0; j < i; ++j) {
                    if (lastLength[j] != -1
                            && dictionary.contains(domain.substring(j + 1, i + 1))) {
                        lastLength[i] = i - j;
                        System.out.println("updated lastlength " + Arrays.toString(lastLength));
                        break ;
                    }
                }
            }
        }
        System.out.println("lastlength " + Arrays.toString(lastLength));
        System.out.println("dictionary" + dictionary);

        List<String> decompositions = new ArrayList<>();
        int count = lastLength.length -1;
        while (count >0 && lastLength[count] == -1) {
            count--;
        }
        if (lastLength[count] != -1) {
        // domain can be assembled by valid words.
            int idx = count;
            while (idx >= 0) {
                decompositions.add(
                        domain.substring(idx + 1 - lastLength[idx], idx + 1));
                idx -= lastLength[idx];
                System.out.println("decompositions" + decompositions);

            }
            System.out.println("decompositions" + decompositions);
            Collections.reverse(decompositions);
        }
        System.out.println("final decompositions" + decompositions);
        return decompositions;
    }
}
