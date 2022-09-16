package 代码随想录.贪心.分发饼干;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月15日 9:31
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int sIdx = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (sIdx >= 0 && s[sIdx] >= g[i]) {
                sIdx--;
                res++;
            }
        }
        return res;
    }
}
