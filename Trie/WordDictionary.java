package Trie;
/*
https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
Design Add and Search Words Data Structure

Design a data structure that supports adding new words and finding if a string matches any previously added
string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false
otherwise. word may contain dots '.' where dots can be matched with any letter.


Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 104 calls will be made to addWord and search.
 */
public class WordDictionary {
    class TrieNode{
        boolean isEnd;
        TrieNode[] child = new TrieNode[26];
        public TrieNode() {}
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            int id = word.charAt(i)-'a';
            if(node.child[id]==null)
                node.child[id] = new TrieNode();
            node = node.child[id];
        }
        node.isEnd = true;
        //      System.out.println(root);
    }

    public boolean search(String word) {
        return searchInNode(word,root);
    }

    public boolean searchInNode(String word, TrieNode node){
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='.'){
                for(int j=0;j<26;j++){
                    if(node.child[j] !=null && searchInNode(word.substring(i+1),node.child[j]))
                        return true;
                }
                return false;
            }
            else{
                int id = word.charAt(i)-'a';
               // System.out.println(node + " " + word );
                if(node.child[id]==null){
                    return false;
                }else{
                    node = node.child[id];
                }
            }

        }
        return node.isEnd;
    }


    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
