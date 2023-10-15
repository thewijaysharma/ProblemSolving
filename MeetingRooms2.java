package ProblemSolving;

import java.util.Arrays;

public class MeetingRooms2 {


    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }

    public static int minMeetingRooms(int[][] intervals) {

        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int i = 0;
        int j = 0;

        int maxRooms = 0;
        int currRooms = 0;

        while (i < intervals.length) {
            if (startTimes[i] < endTimes[j]) {
                i += 1;
                currRooms += 1;
                maxRooms = Math.max(maxRooms, currRooms);
            } else {
                currRooms -= 1;
                j += 1;
            }
        }

        return maxRooms;

    }
}
