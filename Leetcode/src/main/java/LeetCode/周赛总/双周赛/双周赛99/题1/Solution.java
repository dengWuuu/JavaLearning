package LeetCode.周赛总.双周赛.双周赛99.题1;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(distMoney(20, 3));
    }

    public static int distMoney(int money, int children) {
        if (money < children) return -1;
        int l = -1, r = children + 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (check(money, children, mid)) {
                l = mid;
            } else r = mid;
        }
        return l;
    }

    public static boolean check(int money, int children, int n) {
        money -= n * 8;
        if (money < 0) return false;
        children -= n;
        if (money < children) return false;
        if (children == 1 && money == 4) return false;
        if (children < 0) return false;
        if (children == 0 && money > 0) return false;
        return true;
    }
}