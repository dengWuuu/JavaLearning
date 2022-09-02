package LeetCode.热题100.前缀树;

public class Trie {
    private final Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (root.children[idx] == null) {
                root.children[idx] = new Trie();
            }
            root = root.children[idx];
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (root.children[idx] == null) return false;
            root = root.children[idx];
        }
        return root.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if (root.children[idx] == null) return false;
            root = root.children[idx];
        }
        return true;
    }
}