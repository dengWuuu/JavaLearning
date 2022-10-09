package 剑指Offer_专项突击版.前缀树.神奇的字典;

/**
 * @author Wu
 * @date 2022年10月09日 11:47
 */
public class MagicDictionary {
    Trie root;

    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie();
                }
                cur = cur.child[idx];
            }
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Trie node, int index, boolean modified) {
        if (index == searchWord.length()) {
            return modified && node.isFinished;
        }
        int idx = searchWord.charAt(index) - 'a';
        if (node.child[idx] != null) {
            if (dfs(searchWord, node.child[idx], index + 1, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    if (dfs(searchWord, node.child[i], index + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Trie {
    boolean isFinished;
    Trie[] child;

    public Trie() {
        isFinished = false;
        child = new Trie[26];
    }
}