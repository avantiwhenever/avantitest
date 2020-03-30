package com.testfiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        System.out.println("Sorting the numbers");
        List<Integer> numbers = Arrays.asList(9,78,121212, 1,2,3,7,5,6);
        System.out.println("Sorting the numbers : " + numbers);
        System.out.println("Sorted Numbers : " + sortUsingJava8(numbers));
    }

    private static List<Integer> sortUsingJava8(List<Integer> numbers) {
        Collections.sort(numbers, (a,b) -> (a.compareTo(b)));
        return numbers;
    }
}
