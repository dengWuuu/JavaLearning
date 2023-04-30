package LeetCode.周赛总.双周赛.双周赛103.题4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wu
 * @date 2023年4月30日 10:21
 */

public class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        long ans = n;
        var t = new BIT(n + 1);

        int pre = 1;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; ++i)
            idx[i] = i;
        Arrays.sort(idx, Comparator.comparingInt(i -> nums[i]));

        for (int i = 0; i < idx.length; i++) {
            int cur = idx[i] + 1;
            if (pre <= cur) ans += cur - pre - t.query(pre, cur);
            else ans += n - pre + cur - (i - t.query(cur + 1, pre - 1));
            t.inc(cur);
            pre = cur;
        }
        return ans;
    }
}

class BIT {
    private final int[] tree;

    public BIT(int n) {
        tree = new int[n];
    }

    // 将下标 i 上的数加一
    public void inc(int i) {
        while (i < tree.length) {
            ++tree[i];
            i += i & -i;
        }
    }

    // 返回闭区间 [1, i] 的元素和
    public int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += tree[x];
            x &= x - 1;
        }
        return res;
    }

    // 返回闭区间 [left, right] 的元素和
    public int query(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}