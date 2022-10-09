package 剑指Offer_专项突击版.前缀树.最短的单词编码;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年10月09日 18:26
 */
public class Solution {

    class Node {
        boolean isWord;
        Node[] children;

        public Node() {
            this.isWord = false;
            this.children = new Node[26];
        }
    }

    class Trie {
        Node root;
        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            int length = word.length();
            for (int i = length - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }
        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }
        private Node find(String word) {
            Node node = root;
            int length = word.length();
            for (int i = length - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
        public int getCnt(String[] words) {
            int res = 0;
            for (String word : words) {
                if (!startsWith(word)) {
                    res += word.length() + 1;
                    insert(word);
                }
            }
            return res;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        Trie trie = new Trie();
        return trie.getCnt(words);
    }
}