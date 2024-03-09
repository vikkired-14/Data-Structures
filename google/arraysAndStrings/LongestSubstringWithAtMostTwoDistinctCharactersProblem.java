package google.arraysAndStrings;

import java.util.Collections;
import java.util.HashMap;
import java.util.*;

/*
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 * Input: s = "eceba" Output: 3
 * Explanation: The substring is "ece" which its length is 3.
 * */
public class LongestSubstringWithAtMostTwoDistinctCharactersProblem {

    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(new LongestSubstringWithAtMostTwoDistinctCharactersProblem().lengthOfLongestSubstringTwoDistinct(s));

         String s1 = "eceba";
        System.out.println(new LongestSubstringWithAtMostTwoDistinctCharactersProblem().lengthOfLongestSubstringTwoDistinct(s1));

    }

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * */
 /*   public int lengthOfLongestSubstringTwoDistinct(String s) {

        int len = s.length();
        if (len < 3) return len;

        int left = 0, right = 0;
        int maxLength = 2;
        HashMap<Character, Integer> hm = new HashMap<>();

        while (right < len) {
            hm.put(s.charAt(right), right++);

            if (hm.size() == 3) {
                int delIdx = Collections.min(hm.values());
                hm.remove(s.charAt(delIdx));
                left = delIdx + 1;
            }
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }*/

    public int lengthOfLongestSubstringTwoDistinct(String s) {
       // s = "eceba" Output: 3
        int left=0,right=0;
        int maxLen=0;
        Map<Character,Integer> hashSet = new HashMap<>();
        while(right<s.length()){
            hashSet.put(s.charAt(right),hashSet.getOrDefault(s.charAt(right),0)+1);
            while(hashSet.size()>2){
                hashSet.put(s.charAt(left),hashSet.get(s.charAt(left))-1);
                if(hashSet.get(s.charAt(left))==0)
                  hashSet.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}
