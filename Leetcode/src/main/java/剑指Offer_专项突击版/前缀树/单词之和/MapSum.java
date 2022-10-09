package 剑指Offer_专项突击版.前缀树.单词之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年10月09日 18:39
 */
public class MapSum {
    Map<String,Integer> map = new HashMap<>();
    Trie root;
    class Trie {
        int val = 0;
        Trie[] children = new Trie[26];

    }
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Trie();
    }

    public void insert(String key, int val) {
        int num = val - map.getOrDefault(key,0);
        map.put(key,val);
        Trie node = root;
        for(int i = 0; i<key.length();i++){
            int index = key.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index]  = new Trie();
            }
            node = node.children[index];
            node.val += num;

        }
    }

    public int sum(String prefix) {
        Trie node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.val;
    }
}
