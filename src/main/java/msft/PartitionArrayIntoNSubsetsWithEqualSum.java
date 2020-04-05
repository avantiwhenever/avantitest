package msft;
/*

Given an array of integers nums and a positive integer k,
 find whether it's possible to divide this array into k
  non-empty subsets whose sums are all equal.
Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets
 (5), (1, 4), (2,3), (2,3) with equal sums.

Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
 */

public class PartitionArrayIntoNSubsetsWithEqualSum {

    public boolean canPartitionKSubsets(int[] nums, int noOfSubsets) {
        int sum = 0;
        for(int num:nums)
            sum += num;
        if(noOfSubsets <= 0 || sum%noOfSubsets != 0)
            return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, sum/noOfSubsets,0, noOfSubsets, 0, 0);
    }

    private boolean canPartition(int[] nums, int[] visited, int target, int start_index,
                                 int noOfSubsets, int cur_sum, int cur_num){
        if(noOfSubsets==1)
            return true;
        if(cur_sum == target && cur_num>0)
            return canPartition(nums, visited, target,0, noOfSubsets-1, 0, 0);
        for(int i = start_index; i<nums.length; i++) {
            if(visited[i] == 0){
                visited[i] = 1;
                if(canPartition(nums, visited, target,i+1, noOfSubsets, cur_sum + nums[i], cur_num++))
                    return true;
                visited[i] = 0;
            }
        }
        return false;
    }
}
