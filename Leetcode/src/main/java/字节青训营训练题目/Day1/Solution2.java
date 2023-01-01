package 字节青训营训练题目.Day1;

/**
 * @author Wu
 * @date 2022年12月30日 11:26
 */
public class Solution2 {

    public static void main(String[] args) {
        Solve solve = new Solve();
        int ans = 0;
        int[][] nums = {{1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0}};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    ans = Math.max(ans, solve.getNum(nums, i, j));
                }
            }
        }
        System.out.println(ans);
    }
}


class Solve {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;

    public int getNum(int[][] nums, int i, int j) {
        if (nums[i][j] == 1) return 0;
        m = nums.length;
        n = nums[0].length;
        int ans = 1;
        nums[i][j] = 1;
        for (int[] dir : dirs) {
            int nx = i + dir[0], ny = j + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (nums[nx][ny] == 1) continue;
            ans += getNum(nums, nx, ny);
        }
        return ans;
    }
}
