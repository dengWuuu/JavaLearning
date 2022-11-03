package LeetCode.二零二二年每日一题.十一月.最大重复子字符串;

/**
 * @author Wu
 * @date 2022年11月03日 9:03
 */
public class Solution {
    public int maxRepeating(String sequence, String word) {
        for (int k = sequence.length() / word.length(); k > 0; --k) {
            if (sequence.contains(word.repeat(k))) {
                return k;
            }
        }
        return 0;
    }
}