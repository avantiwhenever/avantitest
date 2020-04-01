package msft;

/*
 * https://leetcode.com/discuss/interview-question/398056/
 */
public class MaxInsertsToObtainStringWithout3ConsecutiveAlphabet {

    public static void main(String[] args) {
        printResult("aabab");
        printResult("dog");
        printResult("aa");
        printResult("baaa");
        printResult("aaba");
        printResult("a");
        printResult("aaaa");
        printResult("dogaaa");
    }

    private static void printResult(String givenString) {
        System.out.println("Given string - " + givenString + ". Largest string - " + maxA(givenString));
    }

    private static int maxA(String s) {
        int cnt = 0, res = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == 'a') {
                cnt++;
            } else {
                res += 2 - cnt;
                cnt = 0;
            }
            if(cnt == 3)
                return -1;
        }
        if(s.charAt(s.length() - 1) != 'a')
            res += 2;
        else
            res += 2 - cnt;
        return res;
    }

}
