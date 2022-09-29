package 剑指offer02.middle.机器人的运动范围;

public class Solution {
    private int m, n, k;
    private boolean[][] visit;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visit = new boolean[m][n];
        return dfs(0, 0);
    }

    public int dfs(int i, int j) {
        if (i >= m || j >= n || getValue(i, j) > k || visit[i][j]) {
            return 0;
        }
        visit[i][j] = true;
        return dfs(i + 1, j) + 1 + dfs(i, j + 1);

    }

    public int getValue(int m, int n) {
        int value = 0;
        while (m != 0) {
            value += m % 10;
            m /= 10;
        }
        while (n != 0) {
            value += n % 10;
            n /= 10;
        }
        return value;
    }
}