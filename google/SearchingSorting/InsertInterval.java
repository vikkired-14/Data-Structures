package google.SearchingSorting;
import java.util.*;
/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
 */
public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = insertInterval(intervals,newInterval);
        return mergeIntervals(intervals);
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        LinkedList<int[]> mergeList = new LinkedList<>();
        for(int[] interval : intervals){
            if(mergeList.isEmpty() || mergeList.getLast()[1]<interval[0])
                mergeList.add(interval);
            else
                mergeList.getLast()[1] = Math.max(mergeList.getLast()[1],interval[1]);
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }

    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        int index = findUpperBound(intervals,newInterval);
        if(index!=intervals.length)
            list.add(index,newInterval);
        else
            list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }

    private static int findUpperBound(int[][] intervals, int[] newInterval) {
        if(intervals.length==0)
            return 0;
        int left=0;
        int right=intervals.length-1;
        int ans = intervals.length;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(intervals[mid][0]> newInterval[0])
            {
                ans = mid;
                right= mid-1;
            }else
                left = mid+1;
        }
        return ans;
    }

    public static void main(String[] args){

//        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//        Output: [[1,5],[6,9]]

        int[][] result = insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
        for(int[] res: result)
            System.out.println("("+res[0]+","+res[1]+")");

//        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        Output: [[1,2],[3,10],[12,16]]
        System.out.println("*********************************************************");
        result = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8});
        for(int[] res: result)
            System.out.println("("+res[0]+","+res[1]+")");
    }
}
