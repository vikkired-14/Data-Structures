package google.recursion;
//
//import java.util.*;
//
///*
//Given an array of unique strings words, return all the word squares you can build from words. The same word from words can be used multiple times. You can return the answer in any order.
//
//A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).
//
//For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
//
//
//Example 1:
//
//Input: words = ["area","lead","wall","lady","ball"]
//Output: [["ball","area","lead","lady"],["wall","area","lead","lady"]]
//Explanation:
//The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
//Example 2:
//
//Input: words = ["abat","baba","atan","atal"]
//Output: [["baba","abat","baba","atal"],["baba","abat","baba","atan"]]
//Explanation:
//The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
//
//
//Constraints:
//
//1 <= words.length <= 1000
//1 <= words[i].length <= 4
//All words[i] have the same length.
//words[i] consists of only lowercase English letters.
//All words[i] are unique.
// */
//public class WordSquares {
//    static class Trie{
//        static Map<Character,Trie> child = new HashMap<>();
//        static List<Integer> wordList = new ArrayList<>();
//        Trie(){}
//    }
//    static Trie trie = null;
//    public static List<List<String>> wordSquares(String[] words) {
////        trie = new Trie();
////        buildTrie(words);
////        List<List<String>> result = new ArrayList<>();
////        for(String word: words){
////            LinkedList<String> wordSquares = new LinkedList<>();
////            wordSquares.addLast(word);
////            backTrack(1,wordSquares,result,word.length(),words);
////        }
////        return result;
//
//        List<List<String>> results = new ArrayList<List<String>>();
//        buildTrie(words);
//
//        for (String word : words) {
//            LinkedList<String> wordSquares = new LinkedList<String>();
//            wordSquares.addLast(word);
//            backTrack(1, wordSquares, results,word.length(),words);
//        }
//        return results;
//    }
//
//   private static void backTrack(int step, LinkedList<String> wordSquares, List<List<String>> result,int n,String[] words) {
////        if(step==n){
////            result.add((List<String>)wordSquares.clone());
////            return;
////        }
////        StringBuilder prefix = new StringBuilder();
////        for(String word: wordSquares){
////            prefix.append(word.charAt(step));
////        }
////        for(Integer wordIndex:getStringWithPrefix(prefix.toString(),words)){
////            wordSquares.addLast(words[wordIndex]);
////            backTrack(step+1,wordSquares,result,n,words);
////            wordSquares.removeLast();
////        }
//       if (step == n) {
//           result.add((List<String>) wordSquares.clone());
//           return;
//       }
//
//       StringBuilder prefix = new StringBuilder();
//       for (String word : wordSquares) {
//           prefix.append(word.charAt(step));
//       }
//
//       for (Integer wordIndex : getStringWithPrefix(prefix.toString(),words)) {
//           wordSquares.addLast(words[wordIndex]);
//           backTrack(step+1,wordSquares,result,n,words);
//           wordSquares.removeLast();
//       }
//    }
//
//
//
////    private static List<String> getStringWithPrefix(StringBuilder prefix,String[] words) {
////        List<String> wordList = new ArrayList<>();
////        Trie node = trie;
////            for (int i=0;i<prefix.length();i++){
////                char ch = prefix.charAt(i);
////                if(node.child.containsKey(ch)){
////                    node = node.child.get(ch);
////                }else{
////                    return new ArrayList<>();
////                }
////            }
////            for(Integer wordIndex :node.wordList){
////                wordList.add(words[wordIndex]);
////            }
////
////        return  wordList;
////    }
//
//    protected static List<Integer> getStringWithPrefix(String prefix,String[] words) {
//        Trie node = trie;
//        for (Character letter : prefix.toCharArray()) {
//            if (node.child.containsKey(letter)) {
//                node = node.child.get(letter);
//            } else {
//                // return an empty list.
//                return new ArrayList<Integer>();
//            }
//        }
//        return node.wordList;
//    }
//
////    private static void buildTrie(String[] words, Trie trie) {
////        trie = new Trie();
////        for(int i=0;i< words.length;i++){
////            String word = words[i];
////            Trie node = trie;
////            for(int j =0;j<word.length();j++){
////                char ch = word.charAt(j);
////                if(!node.child.containsKey(ch))
////                    node.child.put(ch,new Trie());
////                node = node.child.get(ch);
////                node.wordList.add(i);
////            }
////
////        }
////    }
//
//    protected static void buildTrie(String[] words) {
//        trie = new Trie();
//
//        for (int wordIndex = 0; wordIndex < words.length; ++wordIndex) {
//            String word = words[wordIndex];
//
//            Trie node = trie;
//            for (Character letter : word.toCharArray()) {
//                if (node.child.containsKey(letter)) {
//                    node = node.child.get(letter);
//                } else {
//                    Trie newNode = new Trie();
//                    node.child.put(letter, newNode);
//                    node = newNode;
//                }
//                node.wordList.add(wordIndex);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        String[] words1 = {"area", "lead", "wall", "lady", "ball"};
//        List<List<String>> result1 = wordSquares(words1);
//        System.out.println("Output 1: " + result1);
//
////        String[] words2 = {"abat", "baba", "atan", "atal"};
////        List<List<String>> result2 = wordSquares(words2);
////        System.out.println("Output 2: " + result2);
//    }
//}


import java.util.*;

class WordSquares {
    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        List<Integer> wordList = new ArrayList<Integer>();

        public TrieNode() {}
    }
    static int N = 0;
    static String[] words = null;
    static TrieNode trie = null;

    public static List<List<String>> wordSquares(String[] words) {
        words = words;
       N = words[0].length();

        List<List<String>> results = new ArrayList<List<String>>();
       buildTrie(words);

        for (String word : words) {
            LinkedList<String> wordSquares = new LinkedList<String>();
            wordSquares.addLast(word);
           backtracking(1, wordSquares, results);
        }
        return results;
    }

    protected static void backtracking(int step, LinkedList<String> wordSquares,
                                List<List<String>> results) {
        if (step == N) {
            results.add((List<String>) wordSquares.clone());
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares) {
            prefix.append(word.charAt(step));
        }

        for (Integer wordIndex :getWordsWithPrefix(prefix.toString())) {
            wordSquares.addLast(words[wordIndex]);
           backtracking(step + 1, wordSquares, results);
            wordSquares.removeLast();
        }
    }

    protected static void buildTrie(String[] words) {
       trie = new TrieNode();

        for (int wordIndex = 0; wordIndex < words.length; ++wordIndex) {
            String word = words[wordIndex];

            TrieNode node =trie;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
                node.wordList.add(wordIndex);
            }
        }
    }

    protected static List<Integer> getWordsWithPrefix(String prefix) {
        TrieNode node =trie;
        for (Character letter : prefix.toCharArray()) {
            if (node.children.containsKey(letter)) {
                node = node.children.get(letter);
            } else {
                // return an empty list.
                return new ArrayList<Integer>();
            }
        }
        return node.wordList;
    }

        public static void main(String[] args) {
        String[] words1 = {"area", "lead", "wall", "lady", "ball"};
        List<List<String>> result1 = wordSquares(words1);
        System.out.println("Output 1: " + result1);

//        String[] words2 = {"abat", "baba", "atan", "atal"};
//        List<List<String>> result2 = wordSquares(words2);
//        System.out.println("Output 2: " + result2);
    }
}