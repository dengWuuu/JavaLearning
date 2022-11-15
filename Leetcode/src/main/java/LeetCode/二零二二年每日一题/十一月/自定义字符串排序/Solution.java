package LeetCode.二零二二年每日一题.十一月.自定义字符串排序;

/**
 * @author Wu
 * @date 2022年11月13日 14:00
 */
public class Solution {
    public String customSortString(String order, String s) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) cnts[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnts[c - 'a']-- > 0) sb.append(c);
        }
        for (int i = 0; i < 26; i++) {
            while (cnts[i]-- > 0) sb.append((char) (i + 'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        double a = 0.2;
        System.out.println(Double.doubleToLongBits(a));
    }
}
