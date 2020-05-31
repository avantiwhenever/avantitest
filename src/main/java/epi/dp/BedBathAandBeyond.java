package epi.dp;

import java.util.*;

public class BedBathAandBeyond {
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
        printResults("avanti", Arrays.asList("a","ava","anti"));
        printResults("bedbathandbeyond.com", Arrays.asList("bed", "bath", "beyond", "bat", "hand"));
    }

    private static void printResults(String string, List<String> list) {
        List<String> result = decomposelntoDictionaryWords(string, new HashSet<>(list));
        System.out.println("Getting the string : "+ string +
                " and dictionary as : " + list +
                " : result is : " + result);
    }

    public static List<String> decomposelntoDictionaryWords(
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
                System.out.println("lastlength " + lastLength.length);
                lastLength[i] = i + 1;
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
                        break ;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(lastLength));
        System.out.println("dictionary" + dictionary);

        List<String> decompositions = new ArrayList<>();
        if (lastLength[lastLength.length - 1] != -1) {
        // domain can be assembled by valid words.
            int idx = domain.length() - 1;
            while (idx >= 0) {
                decompositions.add(
                        domain.substring(idx + 1 - lastLength[idx], idx + 1));
                idx -= lastLength[idx];
                System.out.println("decompositions" + decompositions);

            }
            System.out.println("decompositions" + decompositions);

            Collections.reverse(decompositions);
        }
        System.out.println("decompositions" + decompositions);
        return decompositions;
    }
}
