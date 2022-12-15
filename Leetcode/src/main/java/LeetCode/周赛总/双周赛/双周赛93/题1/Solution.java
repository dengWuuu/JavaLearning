package LeetCode.周赛总.双周赛.双周赛93.题1;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
public class Solution {
    public int maximumValue(String[] strs) {
        int ans = 0;

        for (String str : strs) {
            if (is(str)) {
                ans = Math.max(ans, str.length());
            } else {
                ans = Math.max(ans, Integer.parseInt(str));
            }
        }

        return ans;
    }

    public boolean is(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) return true;
        }
        return false;
    }
}