package LeetCode.周赛总.单周塞.周赛343.题3;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2023年4月30日 10:21
 */

class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int cnt = target[0] + target[1] - start[0] - start[1];


        List<int[]> use = new ArrayList<>();
        for (int[] s : specialRoads) {
            if (s[2] + s[3] - s[0] - s[1] < s[4]) use.add(s);
        }


        return cnt;
    }

}
