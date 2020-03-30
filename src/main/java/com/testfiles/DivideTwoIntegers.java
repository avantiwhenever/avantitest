package com.testfiles;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        printResult(17,2);
        printResult(17,1);
        printResult(51, 12);
        printResult(Integer.MAX_VALUE, 2);
        printResult(0,1);
        printResult(1,0);
        printResult(Integer.MIN_VALUE, -1);
        printResult(Integer.MIN_VALUE, 1);
        printResult(Integer.MAX_VALUE, -1);
        printResult(Integer.MAX_VALUE, 1);
    }

    private static void printResult (int num1, int num2) {
        try {
            long startMilli = System.nanoTime();
            int val = divide(num1, num2);
            long totalTime = System.nanoTime() - startMilli;
            System.out.println("Printing division of of two digits "
                    + num1 + " / " + num2 + " = " + val + ", Time taken : " + totalTime/1000);
        } catch (Exception e) {
            System.out.println("Error while processing , division of of two digits "
                    + num1 + " / " + num2 );
            System.out.println("Exception Thrown " +  e.getMessage());
        }
    }

    private static final int halfMinInt = -Integer.MIN_VALUE/2;
    private static int divide(int dividend, int divisor) throws Exception {
        if (divisor == 0) {
            throw new Exception("Divide by 0 error");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negatives = 2;
        if (dividend >0) {
            negatives --;
            dividend = -dividend;
        }
        if (divisor >0) {
            negatives --;
            divisor = -divisor;
        }
        int quotient = 0;
        while(divisor >= dividend) {
            int powerOfTwo = -1;
            int value = divisor;
            while(value > halfMinInt &&  value + value >= dividend ) {
                value += value;
                powerOfTwo += powerOfTwo;
                //System.out.println(String.format("Value of : value = %d, powerOfTwo=%d, divisor=%d, dividand=%d",
                //        value, powerOfTwo, divisor, dividend));
            }
            quotient += powerOfTwo;
            //System.out.println("------------------------ " + quotient);
            dividend -= value;
        }
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }
}
