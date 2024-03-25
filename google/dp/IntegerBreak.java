package google.dp;
/*
https://leetcode.com/problems/integer-break/
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

Return the maximum product you can get.



Example 1:

Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.


Constraints:

2 <= n <= 58
 */
public class IntegerBreak {
    public int integerBreak(int n) {

        if(n<=3)
            return n-1;
        int[] dp = new int[n+1];
        for(int i=1;i<=3;i++){
            dp[i] = i;
        }
        for(int num =4;num<=n;num++){
            int ans = num;
            for(int i=2;i<num;i++){
                ans = Math.max(ans,i*dp[num-i]);

            }
            dp[num]= ans;
        }
        return dp[n];

    }
}
