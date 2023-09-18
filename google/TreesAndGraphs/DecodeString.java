package google.TreesAndGraphs;
import java.util.*;
/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 */
public class DecodeString {
    static int index=0;
    public static String   decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while (index<s.length() && s.charAt(index)!=']'){
            if(!Character.isDigit(s.charAt(index))){
                result.append(s.charAt(index++));
            }else{
                int k =0;
                // build k while next character is a digit
                while(index<s.length() && Character.isDigit(s.charAt(index))){
                    k = k*10 + s.charAt(index++)-'0';
                }
                // ignore the opening bracket '['
                index++;
                String str = decodeString(s);
                // ignore the closing bracket ']'
                index++;
                // build k[decodedString] and append to the result
                while(k>0){
                    result.append(str);
                    k--;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
//        Input: s = "3[a]2[bc]"
//        Output: "aaabcbc"
       // System.out.println(decodeString("3[a]2[bc]"));

//        Input: s = "3[a2[c]]"
//        Output: "accaccacc"
     //  System.out.println(decodeString("3[a2[c]]"));
//        Input: s = "2[abc]3[cd]ef"
//        Output: "abcabccdcdcdef"
        System.out.println(decodeString("2[abc]3[cd]ef"));

    }
}
