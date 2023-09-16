package google;

import java.util.*;

/*
You are given a stream of points on the X-Y plane. Design an algorithm that:

Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.

Implement the DetectSquares class:

DetectSquares() Initializes the object with an empty data structure.
void add(int[] point) Adds a new point point = [x, y] to the data structure.
int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.


Example 1:


Input
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
Output
[null, null, null, null, 1, 0, null, 2]

Explanation
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // return 1. You can choose:
                               //   - The first, second, and third points
detectSquares.count([14, 8]);  // return 0. The query point cannot form a square with any points in the data structure.
detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
detectSquares.count([11, 10]); // return 2. You can choose:
                               //   - The first, second, and third points
                               //   - The first, third, and fourth points


Constraints:

point.length == 2
0 <= x, y <= 1000
At most 3000 calls in total will be made to add and count.
 */
public class DetectSquares {

    List<int[]> coordinates;
    Map<String,Integer> count;
    DetectSquares(){
        coordinates = new ArrayList<>();
        count = new HashMap<>();
    }
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        String key = x+"@"+y;
        count.put(key,count.getOrDefault(key,0)+1);
        coordinates.add(point);
    }
    public int count(int[] point) {

        int x = point[0];
        int y = point[1];
        int sum=0;
        for(int[] coordinate :coordinates){
            int px = coordinate[0];
            int py = coordinate[1];
            if((x==px && y==py)||Math.abs(x-px)!=Math.abs(y-py))
                continue;
            sum += count.getOrDefault(x +"@"+py,0)  * count.getOrDefault(px +"@"+y,0);
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] commands = {"DetectSquares", "add", "add", "add", "count", "count", "add", "count"};
        int[][] values ={{}, {3, 10}, {11, 2}, {3, 2}, {11, 10}, {14, 8}, {11, 2}, {11, 10}};


        DetectSquares detectSquares = null;
        int[] output = new int[values.length];

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            int[] value = values[i];

            if (command.equals("DetectSquares")) {
                detectSquares = new DetectSquares();
            } else if (command.equals("add")) {
                detectSquares.add(value);
            } else if (command.equals("count")) {
                output[i] = detectSquares.count(value);
            }
        }

        for (int result : output) {
            System.out.println(result);
        }
    }
    }
