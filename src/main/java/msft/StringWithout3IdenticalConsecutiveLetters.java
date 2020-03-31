package msft;
/*
 * Microsoft | OA 2019 | String Without 3 Identical Consecutive Letters
 * https://leetcode.com/discuss/interview-question/398039/
 *
 * Space - 2N max
 * Time - N
 *
 */
public class StringWithout3IdenticalConsecutiveLetters {
    public static void main(String[] args) {
        String s1 = "eeedaaad";
        String s2 = "xxxtxxxttt";
        String s3 = "uuuuxaaaaxuuu";
        printResult(s1);
        printResult(s2);
        printResult(s3);
        printResult("ededededededededsadasefasd");
        printResult("aaabbbccc");
        printResult("aabbaababbb");
    }

    private static void printResult(String str) {
        System.out.println("Printing getLongestSubstring of string input : " + str + " = " + getLongestSubstring(str));
    }

    private static String getLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int currentCharacterCount = 1;
        for (int currentPosition = 1; currentPosition < s.length(); currentPosition++) {
            char currentChar = s.charAt(currentPosition);
            if (currentChar == s.charAt(currentPosition - 1))
                currentCharacterCount++;
            else {
                currentCharacterCount = 1;
            }

            if (currentCharacterCount < 3)
                sb.append(currentChar);
        }
        return sb.toString();
    }
}
