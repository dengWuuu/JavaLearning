package LeetCode.热题100.爬楼梯;

/**
 * @author Wu
 * @date 2022年08月17日 11:52
 */
public class Solution {
    public static int climbStairs(int n) {
        int ans = 1, p = 0, q = 0;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = ans;
            ans = p + q;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
