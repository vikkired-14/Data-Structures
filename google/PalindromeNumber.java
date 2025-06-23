package google;
/*
9. Palindrome Number
Solved
Easy
Topics
conpanies icon
Companies
Hint
Given an integer x, return true if x is a palindrome, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?
https://leetcode.com/problems/palindrome-number/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10==0))
            return false;
        int reverse =0;
        while(x>reverse){
            reverse = reverse*10 + reverse%10;
            x = x/10;
        }
        return x== reverse || x==reverse/10;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome(121));
    }
}
