package 剑指offer02.middle.数字序列中某一位的数字;

/**
 * @author Wu
 * @date 2022年08月01日 12:25
 */
public class Solution {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9;
        while (count < n) {
            n -= count;
            start *= 10;
            digit++;
            count = digit * start * 9;
        }

        long num = start + (n - 1) / digit;
        return Integer.parseInt(String.valueOf(String.valueOf(num).charAt((n - 1) % digit)));
    }
}