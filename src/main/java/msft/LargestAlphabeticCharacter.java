package msft;

/*
 * https://leetcode.com/discuss/interview-question/548119/
 * Given a string S, find the largest alphabetic character,
 * whose both uppercase and lowercase appear in S.
 * The uppercase character should be returned.
 * For example, for S = "admeDCAB", return "D".
 * If there is no such character, return "NO".
 *
 * Time Complexity: O(n), n is the length of the input string
 * Space Complexity: O(26)
 */

public class LargestAlphabeticCharacter {

    public static void main(String[] args) {
        printResult("a");
        printResult("z");
        printResult("A");
        printResult("Z");
        printResult("aA");
        printResult("Zz");
        printResult("aabcdZyZZsD");
        printResult("a");
    }

    private static void printResult(String givenString) {
        System.out.println("Given string - " + givenString + ". Largest Character - " + largestCharacter(givenString));
    }

    public static String largestCharacter(String s) {
        // record each char's uppercase or lowercase
        boolean[] uppers = new boolean[26];
        boolean[] lowers = new boolean[26];
        char[] arr = s.toCharArray();

        for (char cur : arr) {
            if (Character.isLowerCase(cur))
                lowers[cur - 'a'] = true;
            if (Character.isUpperCase(cur))
                uppers[cur - 'A'] = true;
        }

        // visit from uppercase's high index
        for (int i = 25; i >= 0; i--) {
            // check both its uppercase and lowercase exist or not
            if (uppers[i] && lowers[i]) {
                return (char) (i + 'A') + "";
            }
        }

        return "NO";
    }

}