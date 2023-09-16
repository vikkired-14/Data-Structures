package google;

import java.util.*;

/*
Given a list of strings dict where all the strings are of the same length.

Return true if there are 2 strings that only differ by 1 character in the same index, otherwise return false.



Example 1:

Input: dict = ["abcd","acbd", "aacd"]
Output: true
Explanation: Strings "abcd" and "aacd" differ only by one character in the index 1.
Example 2:

Input: dict = ["ab","cd","yz"]
Output: false
Example 3:

Input: dict = ["abcd","cccc","abyd","abab"]
Output: true


Constraints:

The number of characters in dict <= 105
dict[i].length == dict[j].length
dict[i] should be unique.
dict[i] contains only lowercase English letters.


Follow up: Could you solve this problem in O(n * m) where n is the length of dict and m is the length of each string.
 */
public class StringsDifferbyOneCharacter {
    public static boolean differByOne(String[] dict) {

        Set<String> dictSet = new HashSet<>(List.of(dict));
        for(String str: dict){
            for(int i=0;i<str.length();i++){
                StringBuilder sb = new StringBuilder(str);
                sb.setCharAt(i,'*');
                if(dictSet.contains(sb.toString()))
                    return true;
                dictSet.add(sb.toString());
            }
        }
      return false;
    }

    public static void main(String[] args){
        System.out.println(differByOne(new String[]{"abcd","acbd", "aacd"}));//true
        System.out.println(differByOne(new String[]{"abcd","cccc","abyd","abab"}));//true
        System.out.println(differByOne(new String[]{"ab","cd","yz"}));//false

    }
    }
