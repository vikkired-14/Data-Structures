package google.TreesAndGraphs;
/*
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).



Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
 */
public class LongestIncreasingPathInAMatrix {
    static int n;
    static int m;
    static int[][] mat;
    public static int longestIncreasingPath(int[][] matrix) {

        n = matrix.length;
        m = matrix[0].length;
        int[][] cache = new int[n][m];
        boolean [][] visited = new boolean[n][m];
        int maxPath =0;
        mat = matrix;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j])
                    maxPath = Math.max(maxPath,dfs(i,j,cache,visited));
            }
        }
        return maxPath;
    }

    public static int dfs(int i,int j, int[][] cache, boolean [][] visited){
        if(cache[i][j]>0)
            return cache[i][j];
        visited[i][j] = true;
        int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
        int path =1;
        for(int[] d: dir){
            int r = i+d[0];
            int c = j+d[1];
            if(r>=0 && r<n && c>=0 && c<m && mat[r][c]>mat[i][j]){
                path = Math.max(path,1+dfs(r,c,cache,visited));
            }
        }
        visited[i][j] = false;
        cache[i][j] = path;
        return path;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(matrix1)); // Output: 4

        int[][] matrix2 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(longestIncreasingPath(matrix2)); // Output: 4

        int[][] matrix3 = {{1}};
        System.out.println(longestIncreasingPath(matrix3)); // Output: 1
    }
}
