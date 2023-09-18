package google.TreesAndGraphs;
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int result =0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    result++;
                    helper(grid,i,j,n,m);
                }
            }
        }
    return result;
    }

    private static void helper(char[][] grid, int i, int j, int n, int m) {
        grid[i][j]='0';
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(r<0 || r>=n || c<0 || c>=m|| grid[r][c]=='0')
                continue;
            helper(grid,r,c,n,m);
        }
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int result1 = numIslands(grid1);
        int result2 = numIslands(grid2);

        System.out.println("Number of Islands in Grid 1: " + result1); // Output: 1
        System.out.println("Number of Islands in Grid 2: " + result2); // Output: 3
    }
}
