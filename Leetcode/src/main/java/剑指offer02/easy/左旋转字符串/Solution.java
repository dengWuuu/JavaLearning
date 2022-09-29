package 剑指offer02.easy.左旋转字符串;

/**
 * @author Wu
 * @date 2022年08月04日 16:12
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n + 1) + s.substring(0, n + 1);
    }
}