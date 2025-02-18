package com.testfiles;

import java.util.PriorityQueue;

public class KthLargestElementInArray {


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1-n2);
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
