package 剑指Offer_专项突击版.前缀树.最大的异或;

/**
 * @author Wu
 * @date 2022年10月09日 18:59
 */
public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0; // 两个非负数的异或必为非负数
        Trie trie = new Trie();
        for(int num : nums){
            trie.insert(num);
            max = Math.max(max, num ^ trie.search(num));
        }
        return max;
    }
}

class Trie{
    Trie[] next;
    public Trie(){
        this.next = new Trie[2];
    }
    public void insert(int num){
        Trie cur = this;
        for(int i = 30; i >= 0; i--){ // 题目范围为非负数，高31位移动到低1位只要右移30位
            int bit = (num >> i) & 1;
            if(cur.next[bit] == null){
                cur.next[bit] = new Trie();
            }
            cur = cur.next[bit];
        }
    }
    public int search(int num){ // 返回当前前缀树中与num做异或能够取得最大值的数字。取出后再在外部做异或运算。
        Trie cur = this;
        int ans = 0;
        for(int i = 30; i >= 0; i--){
            int bit = (num >> i) & 1; // 取得当前位（0或1）
            bit = cur.next[bit ^ 1] == null ? bit : bit ^ 1; // 与bit相反（指0-1相反）的节点若不存在，bit不变，若存在，取相反
            ans += bit << i; // 累计ans
            cur = cur.next[bit];
        }
        return ans;
    }
}