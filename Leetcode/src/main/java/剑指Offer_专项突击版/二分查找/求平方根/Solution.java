package 剑指Offer_专项突击版.二分查找.求平方根;

/**
 * @author Wu
 * @date 2022年10月10日 19:24
 */
public class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
}