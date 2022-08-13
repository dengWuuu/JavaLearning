package LeetCode.热题100.有效的数独;

/**
 * @author Wu
 * @date 2022年08月12日 14:40
 */
public class Solution {
    boolean[][] row = new boolean[10][10], col = new boolean[10][10], area = new boolean[10][10];

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '0';
                int idx = i / 3 * 3 + j / 3;
                if (row[i][num] || col[j][num] || area[idx][num]) return false;
                row[i][num] = col[j][num] = area[idx][num] = true;
            }
        }
        return true;
    }
}
