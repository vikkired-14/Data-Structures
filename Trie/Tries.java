package Trie;

import Trees.TreeNode;

public class Tries {

    static class TrieNode{
        boolean isEnd;
        TrieNode[] childs = new TrieNode[26];
    }
    static TrieNode root;

    Tries(){
        root = new TrieNode();
    }

    public static void insert(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            int id = word.charAt(i)-'a';
            if(node.childs[id]==null)
                node.childs[id] = new TrieNode();
            node = node.childs[id];
        }
        node.isEnd = true;
    }

    public static boolean search(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            int id = word.charAt(i)-'a';
            if(node.childs[id]==null)
                return false;
            node = node.childs[id];
        }
        return node.isEnd;
    }

    public static boolean startWith(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            int id = word.charAt(i)-'a';
            if(node.childs[id]==null)
                return false;
            node = node.childs[id];
        }
        for(int i=0;i<26;i++){
            if(node.childs[i]==null)
                return true;
        }
        return node.isEnd;
    }

    public static void main(String[] args){

//        Input
//                ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//        Output
//                [null, null, true, false, true, null, true]
//
//        Explanation
//        Trie trie = new Trie();
//        trie.insert("apple");
//        trie.search("apple");   // return True
//        trie.search("app");     // return False
//        trie.startsWith("app"); // return True
//        trie.insert("app");
//        trie.search("app");     // return True


        Tries trie = new Tries();
        trie.insert("apple");
        System.out.println(trie.search("apple"));// return True
        System.out.println(trie.search("app"));     // return False
        System.out.println( trie.startWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True

    }
}
