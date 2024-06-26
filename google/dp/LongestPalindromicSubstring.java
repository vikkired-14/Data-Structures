package google.dp;
import java.util.*;
/*
https://leetcode.com/problems/longest-palindromic-substring/description/
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
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        int len = s.length();
        int resLen =0;
        String resString ="";
        for(int i=0;i<len;i++){
            int left =i,right =i;
            while(left>=0 && right < len && s.charAt(left)==s.charAt(right)){
                if(right-left+1 > resLen ){
                    resLen = right-left+1;
                    resString = s.substring(left,right+1);
                }
                left -= 1;
                right += 1;
            }

            left =i;right =i+1;
            while(left>=0 && right < len && s.charAt(left)==s.charAt(right)){
                if(right-left+1 > resLen ){
                    resLen = right-left+1;
                    resString = s.substring(left,right+1);
                }
                left -= 1;
                right += 1;
            }
        }
        return resString;
    }
}
