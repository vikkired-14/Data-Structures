package facebook.dp;

import java.util.Stack;

/*
Longest Palindromic Substring

Solution
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {
    static String res = "";
    public static String longestValidParentheses(String s) {

        if(s.length()==1)
            return s;
        for(int i=0;i<s.length();i++){
            checkPalindrome(s,i,i);
            checkPalindrome(s,i,i+1);
        }
        return res;
    }
    public static void checkPalindrome(String s,int left,int right){
        while(left>=0 && right< s.length()){
            if(s.charAt(left)!=s.charAt(right))
                return;
            if(right-left+1> res.length()){
                res = s.substring(left,right+1);
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses("babad"));
    }
}
