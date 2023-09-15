package google;

import java.util.*;

/*
Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".


Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2


Constraints:

1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
 */
public class NumberOfMatchingSubsequences {
    static class Node{
        int index;
        String word;
        Node(int index,String word){
            this.index=index;
            this.word = word;
        }
    }
    public static int numMatchingSubseq(String s, String[] words) {
        List<Node>[] wordList = new List[26];
        for(int i=0;i<26;i++){
            wordList[i] = new ArrayList<>();
        }
        for(String word: words){
            wordList[word.charAt(0)-'a'].add(new Node(0,word));
        }
        int result =0;
        for(char ch : s.toCharArray()){
            List<Node> oldBucket = wordList[ch-'a'];
            wordList[ch-'a'] = new ArrayList<>();
            for(Node node : oldBucket){
                node.index++;
                if(node.index== node.word.length()){
                    result++;
                }else{
                    wordList[node.word.charAt(node.index)-'a'].add(node);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
//        Input: s = "abcde", words = ["a","bb","acd","ace"]
//        Output: 3

        System.out.println(numMatchingSubseq("abcde",new String[]{"a","bb","acd","ace"}));
//        Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//        Output: 2
        System.out.println(numMatchingSubseq("dsahjpjauf",new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));

    }
}
