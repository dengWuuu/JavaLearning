package 剑指offer02.middle.剑指offer64;

/**
 * @author Wu
 * @date 2022年08月05日 16:48
 */
public class Solution {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}