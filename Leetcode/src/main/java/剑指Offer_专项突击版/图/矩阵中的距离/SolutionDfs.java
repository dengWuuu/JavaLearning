package 剑指Offer_专项突击版.图.矩阵中的距离;

/**
 * @author Wu
 * @date 2022年10月19日 11:51
 */
public class SolutionDfs {
    int min;
    boolean[][] visited;
    int[][] res;

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        res = new int[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    min = Integer.MAX_VALUE;
                    int count = 0;
                    dfs(mat, i, j, count);
                    res[i][j] = min;
                }
            }
        }
        return res;
    }

    void dfs(int[][] mat, int i, int j, int count) {
        if (i < 0 || i >= res.length || j < 0 || j >= res[0].length || visited[i][j]) {
            return;
        }
        // 剪枝，如果当前路径已经大于了min了，那这条路就没必要走下去了
        if (count > min) {
            return;
        }
        if (mat[i][j] == 0) {
            min = Math.min(min, count);
            return;
        }
        visited[i][j] = true;
        dfs(mat, i - 1, j, count + 1);
        dfs(mat, i + 1, j, count + 1);
        dfs(mat, i, j - 1, count + 1);
        dfs(mat, i, j + 1, count + 1);
        visited[i][j] = false;
    }
}