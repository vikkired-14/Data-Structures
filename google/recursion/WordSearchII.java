package google.recursion;
import java.util.*;
/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
 */
public class WordSearchII {

    class Trie{
        Character ch;
        Map<Character,Trie> child = new HashMap<>();
        String word=null;
        Trie(){}
    }
    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    List<String> result = new ArrayList<>();
    char[][] _board;
    public List<String> findWords(char[][] board, String[] words) {
        Trie root= new Trie();
        _board = board;
        for(String word : words){
            Trie node = root;
            for(char ch : word.toCharArray()){
                if(!node.child.containsKey(ch))
                    node.child.put(ch,new Trie());
                node = node.child.get(ch);
            }
            node.word = word;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.child.containsKey(board[i][j])){
                    backTrack(i,j,root);
                }
            }
        }
        return result;
    }

    public void backTrack(int i,int j, Trie root){
        char ch = _board[i][j];
        Trie trie = root.child.get(ch);
        if(trie.word!=null){
            result.add(trie.word);
            trie.word =null;
        }
        _board[i][j] = '#';
        for(int[] dir: dirs){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x<0 || x>= _board.length|| y<0 || y>= _board[0].length)
                continue;
            if(trie.child.containsKey(_board[x][y])){
                backTrack(x,y,trie);
            }
        }
        _board[i][j] = ch;
        if(trie.child.isEmpty())
            trie.child.remove(ch);
    }
}
