package facebook.dp;
/*
https://leetcode.com/problems/longest-valid-parentheses/description/
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.



Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
 */
public class LongestValidParentheses {

    public static  int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLen =0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2 ?dp[i-2]:0)+2;
                } else if (s.charAt(i-1)==')' && i-dp[i-1]-1>=0  && s.charAt(i-dp[i-1]-1)=='(') {
                    dp[i] = dp[i-1]+ (i-dp[i-1]-2>=0 ?dp[i-dp[i-1]-2]:0)+2;
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return  maxLen;
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()())"));
    }
}
