package msft;

import java.util.HashSet;

public class MinAdjSwapsToMakePalindrome {

    public static void main(String[] args) {
        printResult("mamad");
        printResult("asflkj");
        printResult("aabb");
        printResult("ntiin");
        printResult("nitin");
    }

    private static void printResult (String str) {
        System.out.println("Printing getMinSwaps of string input : "
                + str + " = " + getMinSwaps(str));
    }

    private static int getMinSwaps(String str) {
        int result = 0;
        char[] s1 = str.toCharArray();
        if(!isPalindromicString(str))
            return -1;
        int i = 0;
        int j = s1.length - 1;
        int k = j;
        while(i < j) {
            k = j;
            while(s1[i] != s1[k] && k > i)
                k--;
            if(s1[i] == s1[k] && i != k) {
                while(k < j) {
                    swapItems(s1,k);
                    k++;
                    result++;
                }
                i++;
                j--;
            }
            else {
                swapItems(s1,i);
                result++;
            }

        }
        return result;
    }

    private static void swapItems(char[] items, int k) {
        char temp = items[k];
        items[k] = items[k+1];
        items[k+1] = temp;
    }

    private static boolean isPalindromicString(String input){
        HashSet<Character> hs = new HashSet<>();
        for(char c: input.toCharArray()) {
            if(hs.contains(c)) {
                hs.remove(c);
            }
            else {
                hs.add(c);
            }
        }
        return hs.size() < 2;
    }
}
