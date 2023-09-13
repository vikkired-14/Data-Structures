package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1


Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */
public class MeetingRoomsII {
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval : intervals){
            if(!pq.isEmpty() && pq.peek()<= interval[1])
            {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
    }

    public static void main(String[] args){
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));//2
        System.out.println(minMeetingRooms(new int[][]{{7,10},{2,4}}));//1
    }
}
