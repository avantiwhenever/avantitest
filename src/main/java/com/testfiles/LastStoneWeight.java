package com.testfiles;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i=0; i<stones.length; i++) {
            queue.add(stones[i]);
        }
        while (queue.size() >1) {
            Integer val1 =  queue.poll();
            Integer val2 = queue.poll();
            if (val1 != null && val2 != null) {
                if (val1 != val2) {
                    queue.offer(Math.abs(val1 - val2));
                }
            }
        }

        return (!queue.isEmpty() ? queue.poll() : -1);
    }
}
