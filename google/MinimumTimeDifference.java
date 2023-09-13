package google;
import java.util.*;
/*
Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.


Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1
Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0


Constraints:

2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for(String time : timePoints){
            String[] timeArr = time.split(":");
            int hours = Integer.parseInt(timeArr[0]);
            int minutes = Integer.parseInt(timeArr[1]);
            minutesList.add(hours*60 + minutes);
        }
        Collections.sort(minutesList);
        for(int i=1;i<minutesList.size();i++){
            minDiff = Math.min(minDiff,minutesList.get(i)-minutesList.get(i-1));
        }
        int circularDiff = (minutesList.get(0)+24*60 -minutesList.get(minutesList.size()-1));
        minDiff = Math.min(minDiff,circularDiff);
        return  minDiff;
    }

    public static void main(String[] args) {
        MinimumTimeDifference solution = new MinimumTimeDifference();

        // Example usage
        List<String> timePoints1 = Arrays.asList("23:59", "00:00");
        int result1 = solution.findMinDifference(timePoints1);
        System.out.println("Output 1: " + result1); // Output: 1

        List<String> timePoints2 = Arrays.asList("00:00", "23:59", "00:00");
        int result2 = solution.findMinDifference(timePoints2);
        System.out.println("Output 2: " + result2); // Output: 0
    }
    }
