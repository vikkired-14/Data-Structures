package google;

import java.util.*;

/*
You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).



Example 1:


Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:


Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.


Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] < n2
Each value grid[i][j] is unique.
 */
public class SwimInRisingWater {
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->grid[a/n][a%n]-grid[b/n][b%n]);
        pq.offer(0);
        seen.add(0);
        int ans=0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!pq.isEmpty()){
            int k = pq.poll();
            int row = k/n;
            int col = k%n;
            ans = Math.max(ans,grid[row][col]);
            if(row==n-1 && col==n-1)
                return ans;
            for(int[] dir: dirs){
               int nrow = row+dir[0];
                int ncol = col +dir[1];
                int sum = nrow*n+ncol;
                if(nrow<0 || nrow>= n|| ncol<0 || ncol>=n || seen.contains(sum))
                    continue;
                pq.offer(sum);
                seen.add(sum);
            }
        }
        return ans;
    }

    public static void main(String[] args){
//        Input: grid = [[0,2],[1,3]]
//        Output: 3
        System.out.println(swimInWater(new int[][]{{0,2},{1,3}}));
//        Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
//        Output: 16
        System.out.println(swimInWater(new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},
                {11,17,18,19,20},{10,9,8,7,6}}));
    }
}
/*

        int n = grid.length;
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->grid[a/n][a%n]-grid[b/n][b%n]);
        pq.offer(0);
        seen.add(0);
        int ans=0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!pq.isEmpty()){
            int k = pq.poll();
            int row = k/n;
            int col = k%n;
            ans = Math.max(ans,grid[row][col]);
            if(row==n-1 && col==n-1)
                return ans;
            for(int[] dir: dirs){
                int nrow = row+dir[0];
                int ncol = col+dir[1];
                int sum = nrow*n+ncol;
                if(nrow<0 || nrow>= n|| ncol<0 || ncol>=n || seen.contains(sum))
                    continue;
                pq.offer(sum);
                seen.add(sum);
            }
        }
        return ans;
 */