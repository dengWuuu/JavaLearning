package LeetCode.周赛总.双周赛.双周赛102.题2;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(String.valueOf(grid[j][i]).length(), max);
            }
            ans[i] = max;
        }
        return ans;
    }
}