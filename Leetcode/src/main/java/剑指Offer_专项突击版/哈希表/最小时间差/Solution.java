package 剑指Offer_专项突击版.哈希表.最小时间差;

import java.util.Collections;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月01日 13:37
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int preMin = getMin(timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            int curMin = getMin(timePoints.get(i));
            ans = Math.min(ans, curMin - preMin);
            if (ans == 0) return 0;
            preMin = curMin;
        }
        ans = Math.min(ans, 1440 - (preMin - getMin(timePoints.get(0))));
        return ans;
    }

    public int getMin(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
    }
}
