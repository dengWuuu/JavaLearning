package LeetCode.周赛总.双周赛.双周赛98.题1;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
class Solution {
    public int minMaxDifference(int num) {
        int ans = 0;
        int max = num;
        for (int i = 0; i < 10; i++) {
            String s = num + "";
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) - '0' == i) {
                    sb.append(9);
                } else sb.append(s.charAt(k) - '0');
            }
            max = Math.max(Integer.parseInt(sb.toString()), max);
        }

        int min = num;
        for (int i = 9; i >= 1; i--) {
            String s = num + "";
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) - '0' == i) {
                    sb.append(0);
                } else sb.append(s.charAt(k) - '0');
            }
            min = Math.min(Integer.parseInt(sb.toString()), min);
        }
        return max - min;
    }
}