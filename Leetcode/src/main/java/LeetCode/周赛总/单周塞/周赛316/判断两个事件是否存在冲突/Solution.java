package LeetCode.周赛总.单周塞.周赛316.判断两个事件是否存在冲突;

/**
 * @author Wu
 * @date 2022年10月23日 10:31
 */
public class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String right1 = event2[0], right2 = event2[1];
        String left1 = event1[0], left2 = event1[1];

        if (judge(left2, right1) && judge(right2, left2)) return true;
        else if (judge(right2, left1) && judge(left2, right2)) return true;
        else return false;
    }

    public boolean judge(String left, String right) {
        int l = 0, r = 0;
        if (left.equals(right)) return true;
        while (l < left.length()) {
            if (left.charAt(l) > right.charAt(r)) return true;
            else if (left.charAt(l) == right.charAt(r)) {
                l++;
                r++;
            } else {
                return false;
            }
        }
        return true;
    }
}