package google;
/*
Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.

The line could be horizontal, vertical, diagonal, or anti-diagonal.



Example 1:


Input: mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]
Output: 3
Example 2:


Input: mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]
Output: 4


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.

 public int longestLine(int[][] M) {
    if (M.length == 0) return 0;
    int ones = 0;
    int[][][] dp = new int[M.length][M[0].length][4];
    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[0].length; j++) {
        if (M[i][j] == 1) {
          dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
          dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
          dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
          dp[i][j][3] = (i > 0 && j < M[0].length - 1) ? dp[i - 1][j + 1][3] + 1 : 1;
          ones =
              Math.max(
                  ones,
                  Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
        }
      }
    }
    return ones;
  }

In the previous approach, we can observe that the current dp entry is dependent only on the entries
of the just previous corresponding dp row. Thus, instead of maintaining a 2-D dp matrix for each kind
of line of 1's possible, we can use a 1-d array for each one of them, and update the corresponding
entries in the same row during each row's traversal. Taking this into account, the previous 3-D dp
matrix shrinks to a 2-D dp matrix now. The rest of the procedure remains same as the previous approach.
 */
public class LongestLineOfConsecutiveOneInMatrix {
    public static int longestLine(int[][] M) {
        int n = M.length;
        int m= M[0].length;
        int[][] dp = new int[m][4];
        int maxLen=0;
        for(int i=0;i<n;i++){
            int old =0;
            for(int j=0;j<m;j++){
                if(M[i][j]==1){
                    dp[j][0] = j>0? dp[j-1][0]+1: 1;//horizontal
                    dp[j][1] = i>0? dp[j][0]+1: 1;//vertical
                    int prev = dp[j][2];
                    dp[j][2] = (i>0 && j>0)? old+1: 1;//diagonal
                    old = prev;
                    dp[j][3] = (i>0 && j<M[0].length-1)? dp[j+1][3]+1:1;//anti diagonal
                    maxLen = Math.max(maxLen,Math.max(dp[j][0],Math.max(dp[j][1],Math.max(dp[j][2],dp[j][3]))));
                }else{
                    old = dp[j][2];
                    dp[j][0]=dp[j][1]=dp[j][2]= dp[j][3]=0;
                }

            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        System.out.println(longestLine(new int[][]{{0,1,1,0},{0,1,1,0},{0,0,0,1}}));//3
        System.out.println(longestLine(new int[][]{{1,1,1,1},{0,1,1,0},{0,0,0,1}}));//4

    }
    }
/*

    if (M.length == 0) return 0;
    int n = M.length;
    int m = M[0].length;
    int ones = 0;
    int[][] dp = new int[m][4];
    for (int i = 0; i < n; i++) {
      int old =0;
      for (int j = 0; j < m; j++) {
        if (M[i][j] == 1) {
          dp[j][0] = j > 0 ? dp[j - 1][0] + 1 : 1;
          dp[j][1] = i > 0 ? dp[j][1] + 1 : 1;
          int prev = dp[j][2];
          dp[j][2] = (i > 0 && j > 0) ? old + 1 : 1;
          old = prev;
          dp[j][3] = (i > 0 && j < M[0].length - 1) ? dp[j + 1][3] + 1 : 1;
          ones =
              Math.max(
                  ones,
                  Math.max(Math.max(dp[j][0], dp[j][1]), Math.max(dp[j][2], dp[j][3])));
        }else{
          old = dp[j][2];
          dp[j][0]=dp[j][1]=dp[j][2]=dp[j][3]=0;
        }
      }
    }
    return ones;
  }
 */