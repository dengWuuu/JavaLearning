package 模板.前缀树;

/**
 * @author Wu
 * @date 2023年03月24日 10:13
 */
class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 插入
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    // 字符串的查找
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    //前缀的查找
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}


class TrieNode {
    //子节点
    private final TrieNode[] links;

    private boolean isEnd;

    public TrieNode() {
        int r = 26;
        links = new TrieNode[r];
    }

    //判断是否包含子节点
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    //获取子节点
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    //创建节点
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    //设置成有效字符串
    public void setEnd() {
        isEnd = true;
    }

    //判断从根节点到这个节点路径表示的字符串是否有效
    public boolean isEnd() {
        return isEnd;
    }
}
