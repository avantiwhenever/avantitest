package msft;

public class MaxPossibleValue {

    // https://leetcode.com/discuss/interview-question/398050/

    public static void main(String[] args) {
        printResult(123);
        printResult(321);
        printResult(876);
        printResult(-111);
        printResult(-777);
    }

    private static void printResult(int number) {
        System.out.println("Given number " + number + ". Max Number - " + MaximumPossibleValue(number));
    }

    private static int MaximumPossibleValue(int N) {
        // write your code here
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(N)));
        int flag = N >= 0 ? 1 : -1;
        if (N >= 0) {
            int idx = 0;
            while (idx < sb.length() && (sb.charAt(idx) - '0') >= 5) {
                idx++;
            }
            sb.insert(idx, 5);
        } else {
            int idx = 0;
            while (idx < sb.length() && (sb.charAt(idx) - '0') <= 5)
                idx++;
            sb.insert(idx, 5);
        }
        int val = Integer.parseInt(sb.toString());
        return flag * val;
    }

}