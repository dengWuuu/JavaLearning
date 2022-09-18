package 代码随想录.贪心.用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wu
 * @date 2022年09月16日 11:36
 */
public class Solution {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;
        Arrays.sort(points, (x, y) -> x[0] == y[0] ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0]));
        int ans = 0;
        for (int i = 0; i < points.length; ) {
            int R = points[i][1];
            int idx = i + 1;
            while (idx < points.length) {
                if (points[idx][0] <= R) {
                    R = Math.min(R, points[idx][1]);
                    idx++;
                } else break;
            }
            ans++;
            i = idx;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        Arrays.sort(points, (x, y) -> x[0] == y[0] ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0]));
        System.out.println(Arrays.deepToString(points));
        System.out.println(findMinArrowShots(points));
    }
}
