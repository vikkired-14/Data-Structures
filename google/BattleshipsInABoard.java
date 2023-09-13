package google;
/*
Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).



Example 1:


Input: board = [['X','.','.','X'],['.','.','.','X'],['.','.','.','X']]
Output: 2
Example 2:

Input: board = [['.']]
Output: 0


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is either '.' or 'X'.


Follow up: Could you do it in one-pass, using only O(1) extra memory and without modifying the values board?
 */
public class BattleshipsInABoard {
    static int n;
    static int m;
    public static int countBattleships(char[][] board) {
        n = board.length;
        m = board[0].length;
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 if(board[i][j]=='X'){
                     count++;
                     helper(i,j,board);
                 }
            }
        }
        return count;
    }

    private static void helper(int i, int j, char[][] board) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        board[i][j] = '.';
        for(int[] dir: dirs){
            int row = dir[0] + i;
            int col = dir[1] + j;
            if(row<0 || row>= n || col<0 || col>=m || board[i][j]=='.')
                continue;
            helper(i,j,board);
        }
    }

    public static void main(String[] args){
        System.out.println(countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));//2

        System.out.println(countBattleships(new char[][]{{'.'}}));//0

    }
}
