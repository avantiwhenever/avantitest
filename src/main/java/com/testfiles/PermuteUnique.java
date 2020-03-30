package com.testfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUnique {

    public static void main(String[] args)
    {
        printResult(new String[] {"a","b","c"});
    }

    private static void printResult (String[] abc) {
        System.out.println("Printing permuteUnique of "+ Arrays.toString(abc) + " =" +
                printListOfList(permuteUnique(abc)));
    }

    private static String printListOfList(List<List<String>> result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<String> strings : result) {
            stringBuilder.append("{");
            for (String str : strings) {
                stringBuilder.append(str + ",");
            }
            stringBuilder.append("},");
        }
        return stringBuilder.toString();
    }

    private static List<List<String>> permuteUnique(String[] nums) {
        List<List<String>> ans = new ArrayList<>();
        if (nums==null || nums.length==0) {
            return ans;
        }
        permute(ans, nums, 0);
        return ans;
    }

    private static void permute(List<List<String>> ans, String[] nums, int index) {
        if (index == nums.length) {
            List<String> temp = new ArrayList<>();
            for (String num: nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        Set<String> appeared = new HashSet<>();
        for (int i=index; i<nums.length; ++i) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                permute(ans, nums, index+1);
                swap(nums, index, i);
            }
        }
    }

    private static void swap(String[] nums, int i, int j) {
        String save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
}
