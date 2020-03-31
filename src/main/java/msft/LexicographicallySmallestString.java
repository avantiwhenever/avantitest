package msft;

public class LexicographicallySmallestString {
    public static void main(String[] args) {
        printResult("baaaaa");
        printResult("baaabbaabbba");
        printResult("baaba");
        printResult("abczd");
        printResult("abcxdze");
        printResult("abcd");
        System.out.println(1 << 2);
        System.out.println(1 << 3);
        System.out.println(1 << 4);
        System.out.println(1 << 5);

    }

    private static void printResult (String str) {
        System.out.println("Printing getLexicographicallySmallestString of string input : "
                + str + " =" + getLexicographicallySmallestString(str));
    }

    private static String getLexicographicallySmallestString(String s) {
        StringBuilder str = new StringBuilder(s);
        int i=0;
        for(; i<str.length()-1; i++){
            if(str.charAt(i)>str.charAt(i+1)){
                break;
            }
        }
        return str.deleteCharAt(i).toString();
    }
}
