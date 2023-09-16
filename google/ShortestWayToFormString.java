package google;
import java.util.*;
/*
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.



Example 1:

Input: source = "abc", target = "abcbc"
Output: 2
Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
Example 2:

Input: source = "abc", target = "acdbc"
Output: -1
Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
Example 3:

Input: source = "xyz", target = "xzyxz"
Output: 3
Explanation: The target string can be constructed as follows "xz" + "y" + "xz".


Constraints:

1 <= source.length, target.length <= 1000
source and target consist of lowercase English letters.
 */
public class ShortestWayToFormString {
    public static int shortestWay(String source, String target) {

        List<Integer>[] wordList = new ArrayList[26];
        for(int i=0;i<source.length();i++){
            char ch = source.charAt(i);
            if(wordList[ch-'a']==null)
                wordList[ch-'a']= new ArrayList<>();
            wordList[ch-'a'].add(i);
        }
        int sourceIterator = 0;

        // Number of times we need to iterate through source
        int count = 1;

        for(int i=0;i<target.length();i++){
            char ch = target.charAt(i);
            if(wordList[ch-'a']==null)
                return -1;
            List<Integer> indexList = wordList[ch-'a'];
            int index = Collections.binarySearch(indexList,sourceIterator);
            if(index<0)
                index = -index-1;
            if(index==indexList.size()){
                count++;
                sourceIterator = indexList.get(0)+1;
            }else {
                sourceIterator = indexList.get(index)+1;
            }
        }
        return count;
    }

    public static void main(String[] args){
//        Input: source = "abc", target = "abcbc"
//        Output: 2
        System.out.println(shortestWay("abc","abcbc"));
//        Input: source = "abc", target = "acdbc"
//        Output: -1
        System.out.println(shortestWay("abc","acdbc"));

//        Input: source = "xyz", target = "xzyxz"
//        Output: 3
        System.out.println(shortestWay("xyz","xzyxz"));

        System.out.println(shortestWay("xyz","xyyy"));//3


    }
    }
