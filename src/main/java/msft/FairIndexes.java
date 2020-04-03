package msft;

public class FairIndexes {

    public static void main(String[] args) {
        int[] A1 = {4,-1,0,3}, B1 = {-2, 5, 0 ,3}; // Index 2 and 3
        int[] A2 = {2,-2,-3,3}, B2 = {0,0,4,-4}; // Index 2
        int[] A3 = {4,-1,0,3}, B3 = {-2,6,0,4}; // return 0 since no index
        int[] A4 = {3,2,6}, B4 = {4,1,6}; // return 0 since no index
        int[] A5 = {1,4,2,-2,5}, B5 = {7,-2,-2,2,5}; // Index 2 and 4
        printResult(A1, B1);
        printResult(A2, B2);
        printResult(A3, B3);
        printResult(A4, B4);
        printResult(A5, B5);
    }

    private static void printResult(int[] arr1, int[] arr2) {
        printArray(arr1);
        printArray(arr2);
        System.out.println("number of fair indexes - " + getNumOfFairIndexes(arr1, arr2));
        System.out.println();
    }

    private static void printArray(int[] arr1) {
        System.out.print("Integer array - [");
        for (int number : arr1) {
            System.out.print(number + ", ");
        }
        System.out.println("]");
    }

    private static int getNumOfFairIndexes(int[] A, int[] B) {
        int res = 0, sumA = 0, sumB = 0;
        for(int i=0;i<A.length;i++) {
            sumA += A[i];
            sumB += B[i];
        }
        int tmpA = 0, tmpB = 0;
        for(int i=0;i<A.length-1;i++) {
            tmpA += A[i];
            tmpB += B[i];
            if(sumA == 2 * tmpA && sumB == 2 * tmpB && tmpA == tmpB)
                res++;
        }
        return res;
    }

}
