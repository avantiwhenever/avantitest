package com.testfiles;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2)->n1-n2);
    private int k;
    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }
    }

    public int add(int num) {
        heap.offer(num);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
