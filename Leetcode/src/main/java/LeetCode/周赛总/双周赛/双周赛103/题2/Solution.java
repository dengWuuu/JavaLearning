package LeetCode.周赛总.双周赛.双周赛103.题2;

/**
 * @author Wu
 * @date 2023年4月30日 10:21
 */
class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n = a.length;
        var ans = new int[n];
        long p = 0, q = 0;
        for (int i = 0; i < n; ++i) {
            p |= 1L << a[i];
            q |= 1L << b[i];
            ans[i] = Long.bitCount(p & q);
        }
        return ans;
    }
}