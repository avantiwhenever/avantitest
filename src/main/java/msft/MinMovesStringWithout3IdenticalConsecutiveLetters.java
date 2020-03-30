package msft;

public class MinMovesStringWithout3IdenticalConsecutiveLetters {

    public static void main(String[] args) {
        printResult("baaaaa");
        printResult("baaabbaabbba");
        printResult("baaba");
    }

    private static void printResult (String str) {
        System.out.println("Printing getMinMoves of string input : "
                + str + " =" + getMinMoves(str));
    }

    private static int getMinMoves(String s) {
        int res = 0;
        for(int i = 0 ; i < s.length() ;){
            int next = i+1;
            while(next < s.length() && s.charAt(i) == s.charAt(next))
                next++;
            res += (next - i)/3;
            i = next;
        }
        return res;
    }
}
