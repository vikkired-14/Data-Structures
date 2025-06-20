package google;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/number-of-distinct-islands/description/?envType=company&envId=servicenow&favoriteSlug=servicenow-three-months
 You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Return the number of distinct islands.



Example 1:


Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
Output: 1
Example 2:


Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.

Approach 3: Hash By Path Signature
Intuition

Remember how we didn't need to sort islands in Approach 1? When we start a depth-first search on the top-left square of some island, the path taken by our depth-first search will be the same if, and only if, the shape is the same. We can exploit this by using the path as a hash.

Algorithm

Each time we discover the first cell in a new island, we initialize an empty string. Then each time dfs is called for that island, we first determine whether or not the cell being entered is un-visited land, in the same way as before. If it is, then we append the direction we entered it from to the string. For example, this is the path that our algorithm would follow to explore the following island.

The path taken to explore a large island.

This path will be encoded as "RDDRUURRUL".

There's one thing we need to be cautious of. The three islands below would have the same encoding of RDDDR.

3 islands that hash to the same path, using the scheme described above.

The solution to this is that we also need to record where we backtracked. This occurs each time we exit a call to the dfs(...) function. We'll do this by appending a 0 to the string.

The same 3 islands as above, also showing the back movements.

In this way, the islands will now have the encodings of RDDDR, RDDD0R, and RDDD00R.
 */
public class NumberofDistinctIslands {
     static int[][] gridGbl;
    static StringBuilder currentIsland;
    static boolean[][] vstd ;
    public static int numDistinctIslands(int[][] grid) {
        gridGbl = grid;
        int n = grid.length;
        int m = grid[0].length;
        vstd = new boolean[n][m];
        Set<String> unquieIslands = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    currentIsland = new StringBuilder();
                    dfs(i,j,n,m,'0');
                    if(currentIsland.isEmpty())
                        continue;
                    unquieIslands.add(currentIsland.toString());
                }
            }
        }
        return unquieIslands.size();
    }

    private static void dfs(int row, int col, int n, int m, char dir) {

        if(row<0 || row>=n || col<0 || col>=m ) return;
        if(gridGbl[row][col]==0 || vstd[row][col]) return;
        vstd[row][col] = true;
        currentIsland.append(dir);
        dfs(row+1,col,n,m,'D');
        dfs(row-1,col,n,m,'U');
        dfs(row,col+1,n,m,'R');
        dfs(row,col-1,n,m,'L');
        currentIsland.append('0');
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(numDistinctIslands(matrix));

        matrix = new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(numDistinctIslands(matrix));
//
//        Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
//        Output: 3
    }
}
