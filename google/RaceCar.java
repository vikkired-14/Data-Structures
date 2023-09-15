package google;

import java.util.*;

/*
Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions.
Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):

When you get an instruction 'A', your car does the following:
position += speed
speed *= 2
When you get an instruction 'R', your car does the following:
If your speed is positive then speed = -1
otherwise speed = 1
Your position stays the same.
For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.

Given a target position target, return the length of the shortest sequence of instructions to get there.



Example 1:

Input: target = 3
Output: 2
Explanation:
The shortest instruction sequence is "AA".
Your position goes from 0 --> 1 --> 3.
Example 2:

Input: target = 6
Output: 5
Explanation:
The shortest instruction sequence is "AAARA".
Your position goes from 0 --> 1 --> 3 --> 7 --> 7 --> 6.

 */
public class RaceCar {
    public static int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> qSet = new HashSet<>();
        queue.offer(new int[]{0,1,0});
        qSet.add(new int[]{0,1});
        int moves = 0;
        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            int  pos = arr[0];
            int speed = arr[1];
             moves = arr[2];
//            arr = new int[]{pos+speed,speed*2,moves+1};
            if(pos==target)
                return moves;
            else if (!qSet.contains(new int[]{pos,speed})) {
                qSet.add(new int[]{pos,speed});
                queue.offer(new int[]{pos+speed,speed*2,moves+1});
                if((pos+speed>target && speed>0)|| (pos+speed<target && speed<0)){
                    queue.offer(new int[]{pos,speed>0?-1:1,moves+1});
                }
            }
        }
        return moves;
    }

    public static void main(String[] args){
        System.out.println(racecar(3));
        System.out.println(racecar(6));
    }
    }
