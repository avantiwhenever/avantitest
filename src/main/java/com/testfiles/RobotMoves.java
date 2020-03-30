package com.testfiles;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

// child can go 1m 2m 3 step
public class RobotMoves {
    boolean[][] exampleGrid1 = new boolean[][] {
            {true, true, true},
            {true, false, true},
            {true, false, true}
    };

    public static void main(String[] args)
    {
        int num = 10;
        for (int i=0 ; i<=num; i++) {
            printResult(i);
        }
    }

    private static void printResult (int num) {
//        System.out.println("Printing robotMovesRec of number "+ num + " ="
//                + robotMovesRec(num));
    }

    private static ArrayList<Point> robotMovesRec(int[][] num) {
        ArrayList<Point> result = new ArrayList<Point>();
        return result;
    }
//
//    private static ArrayList<Point> robotMovesRec(
//            int[][] num, int rows, int columns, List<Point> result) {
//
//    }

}
