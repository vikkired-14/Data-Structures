package google.TreesAndGraphs;

import java.util.*;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> wordSet = new HashSet<>(wordList);
      Set<String> beginSet = new HashSet<>();
      Set<String> endSet = new HashSet<>();
      Set<String> visited = new HashSet<>();
      Set<String> nextSet = new HashSet<>();
      beginSet.add(beginWord);
      endSet.add(endWord);
      int count=1;
      while (!beginSet.isEmpty() && !endSet.isEmpty()){

          if(beginSet.size()> endSet.size()){
              Set<String> temp = beginSet;
              beginSet = endSet;
              endSet = temp;
          }
          for(String word : beginSet){
              char[] charArray = word.toCharArray();
              for(int i=0;i<charArray.length;i++){
                  char ch =charArray[i];
                  for(char c ='a';c<='z';c++){
                      if(ch==c)
                          continue;
                      charArray[i] = c;
                      String newWord = new String(charArray);
                      if(endWord.contains(newWord))
                          return count+1;
                      if(!visited.contains(newWord) && wordSet.contains(newWord)){
                          nextSet.add(newWord);
                          visited.add(newWord);
                      }
                  }
                  charArray[i] = ch;
              }
          }
          beginSet = nextSet;
          count++;
      }
      return count;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest Transformation Sequence Length: " + result);
    }
    }
