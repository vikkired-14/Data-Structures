package google.dp;

import java.util.*;

/*
You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.



Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
Example 3:

Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.


Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of lowercase English letters.
 */
public class LongestStringChain {
    public static int longestStrChain(String[] words) {
        Map<String,Integer> dp = new HashMap<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        int maxLen =0;
        for(String word: words){
            int presentLen =1;
            for(int i=0;i<word.length();i++){
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String newWord = sb.toString();
                presentLen = Math.max(presentLen,dp.getOrDefault(newWord,0)+1);
            }
            dp.put(word,presentLen);
            maxLen = Math.max(maxLen,presentLen);
        }
        return maxLen;
    }

    public static void main(String[] args){
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));//4

        System.out.println(longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));//5
        System.out.println(longestStrChain(new String[]{"abcd","dbqca"}));//1

    }
    }

    /*
    Complexity Analysis

Let NNN be the number of words in the list and LLL be the maximum possible length of a word.

Time complexity: O(N⋅(log⁡N+L2))O(N \cdot (\log N + L ^ 2))O(N⋅(logN+L
2
 )).

Sorting a list of size NNN takes O(Nlog⁡N)O(N \log N)O(NlogN) time. Next, we use two for loops in which the outer loop runs for O(N)O(N)O(N) iterations and the inner loop runs for O(L2)O(L ^ 2)O(L
2
 ) iterations in the worst case scenario. The first LLL is for the inner loop and the second LLL is for creating each predecessor. Thus the overall time complexity is O(Nlog⁡N+(N⋅L2))O(N \log N + (N \cdot L ^ 2))O(NlogN+(N⋅L
2
 )) which equals O(N⋅(log⁡N+L2))O(N \cdot (\log N + L ^ 2))O(N⋅(logN+L
2
 )).

Space complexity: O(N)O(N)O(N).

We use a map to store the length of the longest sequence formed with each of the NNN words as the end word.
     */
