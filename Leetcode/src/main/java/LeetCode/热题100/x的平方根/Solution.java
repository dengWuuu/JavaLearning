package LeetCode.热题100.x的平方根;

/**
 * @author Wu
 * @date 2022年08月17日 11:44
 */
public class Solution {
    public static int mySqrt(int x) {
        if (x == 1) return 1;
        int left = 0, right = x;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (x / mid < mid) right = mid;
            else left = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}
