package LeetCode.周赛总.单周塞.周赛334.题2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] ans = new int[word.length()];
        ans[0] = (word.charAt(0) - '0') % m == 0 ? 1 : 0;
        long tmp = word.charAt(0) - '0';

        for (int i = 1; i < word.length(); i++) {
            tmp *= 10;
            tmp += word.charAt(i) - '0';
            tmp %= m;
            ans[i] = tmp == 0 ? 1 : 0;
        }
        return ans;
    }

}
