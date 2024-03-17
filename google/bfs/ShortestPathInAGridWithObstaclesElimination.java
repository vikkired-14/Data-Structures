package google.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.



Example 1:


Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation:
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:


Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0
 */
public class ShortestPathInAGridWithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> qu = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        qu.offer(new int[]{0,0,0,k});
        visited.add("0_0_"+k);
        while(!qu.isEmpty()){
            int[] arr = qu.poll();
            int row = arr[0];
            int col = arr[1];
            int moves = arr[2];
            int left = arr[3];
            if(row== n-1 && col ==m-1)
                return moves;
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] dir: dirs){
                int nRow = dir[0] + row;
                int nCol = dir[1]+ col;
                if(nRow<0 || nRow >= n || nCol<0 || nCol>=m )
                    continue;
                int nextElimination = left- grid[nRow][nCol];
                if(nextElimination>=0 &&  !
                        visited.contains(nRow+"_"+nCol+"_"+nextElimination)){
                    visited.add(nRow+"_"+nCol+"_"+nextElimination);
                    qu.offer(new int[]{nRow,nCol,moves+1,nextElimination});
                }

            }
        }
        return -1;
    }
}
