package frank.advanceDS.autocomplete;

import java.util.ArrayList;
import java.util.List;

class Trie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Array for each letter 'a' to 'z'
        boolean isEndOfWord = false; // Indicates if the node marks the end of a word

        // Helper function to convert a character to its corresponding index
        int charToIndex(char c) {
            return c - 'a';
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;

        for (char c : word.toLowerCase().toCharArray()) {
            int index = currentNode.charToIndex(c);
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;

        for (char c : word.toLowerCase().toCharArray()) {
            int index = currentNode.charToIndex(c);
            if (currentNode.children[index] == null) {
                return false; // Word not found
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord; // Return true if it's the end of the word
    }


    public List<String> autocomplete(String prefix) {
        TrieNode currentNode = root;
        List<String> result = new ArrayList<>();

        // Find the node that represents the last character of the prefix
        for (char c : prefix.toLowerCase().toCharArray()) {
            int index = currentNode.charToIndex(c);
            if (currentNode.children[index] == null) {
                return result;
            }
            currentNode = currentNode.children[index];
        }

        collectWords(currentNode, prefix.toLowerCase(), result);
        return result;
    }

    private void collectWords(TrieNode node, String prefix, List<String> result) {
        if (node == null) {
            return;
        }

        if (node.isEndOfWord) {
            result.add(prefix);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            TrieNode childNode = node.children[c - 'a'];
            if (childNode != null) {
                collectWords(childNode, prefix + c, result);
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("batman");

        System.out.println("Search 'app': " + trie.search("app")); // true
        System.out.println("Search 'bat': " + trie.search("bat")); // true
        System.out.println("Search 'bats': " + trie.search("bats")); // false

        // Autocomplete for a prefix
        System.out.println("Autocomplete for 'ba': " + trie.autocomplete("ba"));
        System.out.println("Autocomplete for 'ap': " + trie.autocomplete("ap"));
    }
}

