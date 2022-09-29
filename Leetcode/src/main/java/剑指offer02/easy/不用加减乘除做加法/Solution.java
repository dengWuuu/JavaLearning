package 剑指offer02.easy.不用加减乘除做加法;

/**
 * @author Wu
 * @date 2022年08月05日 16:52
 */
public class Solution {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}