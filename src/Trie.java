/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

 */


class TrieNode {

    TrieNode[] nodes = new TrieNode[26];
    boolean isEnd;
}

public class Trie {
    TrieNode root;


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i) - 'a';
            if (currNode.nodes[val] == null) {
                currNode.nodes[val] = new TrieNode();
            }
          currNode = currNode.nodes[val];
        }
        currNode.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {

        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i) - 'a';
            if (currNode.nodes[val] != null) {
                currNode = currNode.nodes[val] ;
            }
            else
                return false;
        }
        return currNode.isEnd;
    }



    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int val = prefix.charAt(i) - 'a';
            if (currNode.nodes[val] != null) {
                currNode = currNode.nodes[val];
            }
            else
                return false;
        }
        return true;
    }


    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}