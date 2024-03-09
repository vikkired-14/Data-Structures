package Trie;

import java.util.*;

public class WordSuggestions {

    static class Trie{
        Map<Character,Trie> child = new HashMap<>();
        boolean isWordEnd;
    }
    static Trie root;
    WordSuggestions(){
        root = new Trie();
    }

    public static void insert(String word){
        Trie node = root;
        for(char ch : word.toCharArray()){
            if(!node.child.containsKey(ch))
                node.child.put(ch,new Trie());
            node = node.child.get(ch);
        }
        node.isWordEnd = true;
    }

    public static List<String> searchWord(String wordPrefix){
        Trie node = root;
        List<String> suggested = new ArrayList<>();
        node= getToNode(wordPrefix,node);
        if(node!=null){
            collectSuggested(node,wordPrefix,suggested);
        }
        return suggested;
    }

    private static void collectSuggested(Trie node, String wordPrefix, List<String> suggested) {
        if(node.isWordEnd)
            suggested.add(wordPrefix);
        for(char ch : node.child.keySet()){
            collectSuggested(node.child.get(ch), wordPrefix+ch,suggested);
        }
    }

    private static Trie getToNode(String wordPrefix, Trie node) {
        for(char ch : wordPrefix.toCharArray()){
            if(!node.child.containsKey(ch))
                return null;
            node = node.child.get(ch);
        }
        return node;
    }

    public static void main(String[] args){
        WordSuggestions ws = new WordSuggestions();
        insert("apple");
        insert("application");
        insert("app1");
        insert("acappp1");
        System.out.println(searchWord("app"));
    }
}
