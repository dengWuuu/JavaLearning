package LeetCode.周赛总.单周塞.周赛333.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public int minOperations(int n) {
        String str = Integer.toBinaryString(n);
        int cnt = 0;
        List<int[]> list = new ArrayList<>();
        int idx = 0;
        while (idx < str.length()) {
            if (str.charAt(idx) == '0') idx++;
            else {
                int r = idx;
                while (r < str.length() && str.charAt(r) == '1') {
                    r++;
                }
                list.add(new int[]{idx, r - 1});
                idx = r;
            }
        }
        if (list.size() == 0) return cnt;
        int[][] intervals = list.toArray(new int[0][]);
        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int x = intervals[i][0], y = intervals[i][1];
            if (x - 2 <= ans.get(ans.size() - 1)[1] && ans.get(ans.size() - 1)[1] != ans.get(ans.size() - 1)[0]) {
                int[] ints = ans.get(ans.size() - 1);
                ints[1] = y;
                ans.set(ans.size() - 1, ints);
                cnt++;
            } else {
                ans.add(new int[]{x, y});
            }
        }
        for (int[] an : ans) {
            if (an[0] == an[1]) cnt++;
            else cnt += 2;
        }
        return cnt;
    }
}