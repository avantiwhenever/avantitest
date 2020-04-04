package msft;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    // https://leetcode.com/problems/meeting-rooms-ii/description
    public static void main(String[] args) {
        printResult(new int[][] { { 2, 7 }, { 5, 6 }, { 3, 4 } }); // 2
        printResult(new int[][] { { 2, 7 }}); // 1
        printResult(new int[][] { { 2, 7 }, { 7,9 }, { 9,11 } }); // 1
        printResult(new int[][] { { 2, 7 }, { 2,7 }, { 6,11 } }); // 3
        printResult(new int[][] { { 2, 7 }, { 3,8 }, { 4,9 }, {5,10}, {6,11}, {7,12} }); // 5
    }

    private static void printResult(int[][] meetingTimes) {
        System.out.println("Meeting times- ");
        for (int[] meeting : meetingTimes) {
            System.out.println("Start time- " + meeting[0] +". End time - " + meeting[1]);
        }
        System.out.println("Distinct meeting rooms needed - " + minMeetingRooms(meetingTimes));
        System.out.println();
    }

    public static int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i=0; i< intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int endIter = 0;
        for (int i=0; i<start.length ;i++) {
            if (start[i]<end[endIter]){
                rooms++;
            } else {
                endIter++;
            }
        }
        return rooms;    }
}
