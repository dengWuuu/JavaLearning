package LeetCode.二零二三年每日一题.最小的必要团队;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2023年04月08日 20:41
 */
//https://leetcode.cn/problems/smallest-sufficient-team/description/
public class Solution {
    private long all;
    private int[] mask;
    private long[][] memo;
    int n;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> map = new HashMap<>();
        int m = req_skills.length;
        //字符串映射下标
        for (int i = 0; i < m; i++) {
            map.put(req_skills[i], i);
        }

        n = people.size();
        mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (String s : people.get(i)) {
                mask[i] |= 1 << map.get(s);
            }
        }
        memo = new long[n][1 << m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        all = (1L << n) - 1;
        int allSkill = (1 << m) - 1;
        long cnt = dfs(0, allSkill);

        int[] ans = new int[Long.bitCount(cnt)];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (((cnt >> i) & 1) == 1) {
                ans[idx++] = i;
            }
        }
        return ans;
    }

    public long dfs(int i, int j) {
        if (j == 0) return 0;
        if (i == n) return all;
        if (memo[i][j] != -1) return memo[i][j];
        long res1 = dfs(i + 1, j);
        long res2 = dfs(i + 1, j & ~mask[i]) | (1L << i);
        return memo[i][j] = (Long.bitCount(res1) < Long.bitCount(res2) ? res1 : res2);
    }
}