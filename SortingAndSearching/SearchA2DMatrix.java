package SortingAndSearching;
/*
You are given an m x n integer matrix    with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

/*
Sorted array is a perfect candidate for the binary search
because the element index in this virtual array (for sure we're
not going to construct it for real) could be easily
transformed into the row and column in the initial matrix
 */
public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        if(m==0)
            return false;
        int left=0,right =n*m-1;
        while (left<=right){
            int pivot = left + (right-left)/2;
            int pivotVal = matrix[pivot/m][pivot%m];
            if(pivotVal==target)
                return true;
            if(pivotVal> target)
                right = pivot-1;
            else
                left = pivot+1;
        }
        return false;
    }

    public static void main(String[] args){
       // System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},13));//false
      //  System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));//true
        System.out.println(searchMatrix(new int[][]{{1,1}},3));//true

    }
}
