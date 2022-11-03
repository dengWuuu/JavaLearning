package 字节跳动题库.x的平方根;

/**
 * @author Wu
 * @date 2022年11月03日 9:27
 */
public class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if ((x / mid) > x) r = mid;
            else l = mid;
        }
        return l;
    }
}