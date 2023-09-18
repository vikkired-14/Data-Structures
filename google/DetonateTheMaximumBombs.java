package google;

import java.util.*;

/*
You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. This area is in the shape of a circle with the center as the location of the bomb.

The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.

You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.

Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.



Example 1:


Input: bombs = [[2,1,3],[6,1,4]]
Output: 2
Explanation:
The above figure shows the positions and ranges of the 2 bombs.
If we detonate the left bomb, the right bomb will not be affected.
But if we detonate the right bomb, both bombs will be detonated.
So the maximum bombs that can be detonated is max(1, 2) = 2.
Example 2:


Input: bombs = [[1,1,5],[10,10,5]]
Output: 1
Explanation:
Detonating either bomb will not detonate the other bomb, so the maximum number of bombs that can be detonated is 1.
Example 3:


Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
Output: 5
Explanation:
The best bomb to detonate is bomb 0 because:
- Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
- Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
- Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
Thus all 5 bombs are detonated.


Constraints:

1 <= bombs.length <= 100
bombs[i].length == 3
1 <= xi, yi, ri <= 105
 */
public class DetonateTheMaximumBombs {

    public int maximumDetonation(int[][] bombs) {

        Map<Integer,List<Integer>> graph = new HashMap<>();
        int count=0;
        int n = bombs.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    int x1 = bombs[i][0]; int y1 = bombs[i][1];int r1 = bombs[i][2];
                    int x2 = bombs[j][0]; int y2 = bombs[j][1];
                    if((long)r1*r1>=(long)(x1-x2)*(x1-x2) + (long)(y1-y2)*(y1-y2)){
                        graph.computeIfAbsent(i,k->new ArrayList<>()).add(j);
                    }

                }
            }
        }
        for(int i=0;i<n;i++){
            count = Math.max(count,bfs(graph,i));
        }
        return count;
    }

    public int bfs(Map<Integer, List<Integer>> graph, int i){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(i);
        visited.add(i);
        while(!queue.isEmpty()){
            int point = queue.poll();
            if(graph.containsKey(point)){
                for(int neighbour:graph.get(point)){
                    if(!visited.contains(neighbour)){
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }
        return visited.size();
    }
}
