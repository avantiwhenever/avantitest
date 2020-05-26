package epi.recursion;
import java.util.ArrayList;
import java.util.List;

public class GenerateMatchedParameters {
    //GENERATE STRINGS OF MATCHED PARENS
    /*
    Write a program that takes as input a number and returns all the strings
     with that number of matched pairs of parens.
     */
    public static void main(String args[]) {
        generateBalancedParanthesis(1);
        generateBalancedParanthesis(2);
        generateBalancedParanthesis(3);
        generateBalancedParanthesis(4);
    }

    // Hint: Think about what the prefix of a string of matched parens must look like.
    public static List<String> generateBalancedParanthesis(int numPairs) {
        List<String> result = new ArrayList<>();
        directedGenerateBalancedParanthesis(numPairs, numPairs, "", result);
        return result;
    }

    private static void directedGenerateBalancedParanthesis(
            int numLeftParansNeeded,
            int numRightParansNeeded, String validPrefix,
            List<String> result) {
        if(numLeftParansNeeded == 0 && numRightParansNeeded == 0) {
            System.out.println(validPrefix);
            result.add(validPrefix);
            return;
        }

        if (numLeftParansNeeded > 0) {
            // Able to insert '('
            directedGenerateBalancedParanthesis(
                    numLeftParansNeeded-1,
                    numRightParansNeeded,
                    validPrefix + "(",
                    result);
        }
        if (numLeftParansNeeded < numRightParansNeeded) {
            // Able to insert ')'
            directedGenerateBalancedParanthesis(
                    numLeftParansNeeded,
                    numRightParansNeeded-1,
                    validPrefix + ")",
                    result);
        }
    }


}
