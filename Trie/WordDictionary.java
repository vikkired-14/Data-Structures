package Trie;

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
