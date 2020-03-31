package msft;

public class MinDeletionstoMakeFrequencyofEachLetterUnique {

    public static void main(String[] args) {
        printResult("baaaaa");
        printResult("baaabbaabbba");
        printResult("baaba");
        printResult("abczd");
        printResult("abcxdze");
        printResult("abcd");
    }

    private static void printResult (String str) {
        System.out.println("Printing getMinDeletions of string input : "
                + str + " =" + getMinDeletions(str));
    }

    private static int getMinDeletions(String string) {
        int[] freq = new int[128];
        int max = 0;
        for (int i = 0; i < string.length(); i++) {
            max = Math.max(max, ++freq[string.charAt(i)]);
        }

        int[] counter = new int[max+1];
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) counter[freq[i]]++;
        }

        int minDeletions = 0;
        for (int i = max; i > 0; i--) {
            int deletions = counter[i] != 0 ? (counter[i]-1) : 0;
            minDeletions += deletions;
            counter[i-1] += deletions;
        }

        return minDeletions;
    }
}
