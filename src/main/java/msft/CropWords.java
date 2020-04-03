package msft;

public class CropWords {
    /*
     * https://leetcode.com/discuss/interview-question/507367/
     */
    public static void main(String[] args) {
        printResult(" zCodility we test coders", 14);
        printResult("codility We test coders", 14);// === "codility We")
        printResult(" co de my", 5);// === " co")
        printResult(" co de my", 7);// === " co de")
        printResult("   ", 2);// === "")
        printResult("   re", 2);// === "") //3 spaces before
        printResult(" c ", 3);// === " c")
        printResult(" c d  ", 5);// === " c d")
        printResult("co de my", 5);// === "co de")
        printResult("Word", 4);// === "Word")
        printResult("codility We test coders", 23);// === "codility We test coders")
        printResult("withOutSpaces", 14);// === "withOutSpaces")
        printResult("", 14);// === "")
        printResult("Separatedby hyphens", 14);// === "Separatedby")
        printResult("      Codility We test coders     ", 14);// === " Codility") //6 leading spaces
        printResult("      Codility We test coders     ", 10);// === "") //6 leading spaces
    }

    private static void printResult(String fullText, int lineWidth) {
        System.out.print(" Full Text - [" + fullText + "].\n Requried Line Width - " + lineWidth);
        System.out.println("\n Cropped words - [" + cropWords(fullText, lineWidth) + "]");
        System.out.println();
    }

    private static String cropWords(String fullText, int lineWidth) {
        if (lineWidth >= fullText.length()) {
            StringBuilder sb = new StringBuilder(fullText);
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.setLength(sb.length() - 1);
            }
            return sb.toString();
        }
        StringBuilder sb = new StringBuilder(fullText.substring(0, lineWidth));
        if (fullText.charAt(lineWidth) != ' ') {
            while (sb.charAt(--lineWidth) != ' ') {
                sb.deleteCharAt(lineWidth);
            }
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
