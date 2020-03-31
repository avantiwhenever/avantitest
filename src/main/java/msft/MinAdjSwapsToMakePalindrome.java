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
        char[] charArray = str.toCharArray();
        if(!isPalindromicString(str))
            return -1;
        int start = 0;
        int end = charArray.length - 1;
        int curr = end;
        while(start < end) {
            curr = end;
            while(charArray[start] != charArray[curr] && curr > start)
                curr--;
            if(charArray[start] == charArray[curr] && start != curr) {
                while(curr < end) {
                    swapItems(charArray,curr);
                    curr++;
                    result++;
                }
                start++;
                end--;
            }
            else {
                swapItems(charArray,start);
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
