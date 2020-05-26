package epi.recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TowerHanoi {

    private static final int NUM_PEGS = 3;

    public static void main(String args[]) {
        computeTowerHanoi(5);
    }

    public static void computeTowerHanoi(int num) {
        System.out.println("Compute ");
        List<Deque<Integer>> pegs = new ArrayList<>();
        for (int i=0; i<NUM_PEGS; i++) {
            pegs.add(new LinkedList<>());
        }
        // Initialize pegs.
        for (int i=num; i>0; i--){
            pegs.get(0).addFirst(i);
        }
        computeTowerHanoiSteps(num, pegs, 0, 1, 2);
    }

    private static void computeTowerHanoiSteps(int num, List<Deque<Integer>> pegs,
                                               int fromPeg, int toPeg, int usePeg) {
        if (num > 0) {
            computeTowerHanoiSteps(num-1, pegs, fromPeg, usePeg, toPeg);
            int val = pegs.get(fromPeg).removeFirst();
            pegs.get(toPeg).addFirst(val);
            System.out.println("Move " + val + " from peg " + fromPeg + " to peg " + toPeg);
            computeTowerHanoiSteps(num-1, pegs, usePeg, toPeg, fromPeg);
        }
    }
}
