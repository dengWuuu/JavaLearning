package 剑指Offer_专项突击版.图.矩阵中的距离;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;

    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> deque = new LinkedList<>();
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int[] floor = new int[mat[i].length];
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    visited = new boolean[mat.length][mat[0].length];
                    int count = 0;
                    deque.add(new int[]{i, j});
                    while (!deque.isEmpty()) {
                        int size = deque.size();
                        count++;
                        for (int k = 0; k < size; k++) {
                            int[] pop = deque.pop();
                            int x = pop[0], y = pop[1];
                            visited[x][y] = true;
                            for (int[] dir : dirs) {
                                int nx = dir[0] + x, ny = dir[1] + y;
                                if (nx < 0 || nx >= mat.length || ny < 0 || ny >= mat[i].length) continue;
                                if (!visited[nx][ny]) {
                                    deque.add(new int[]{nx, ny});
                                }
                                if (mat[nx][ny] == 0) {
                                    deque.clear();
                                    break;
                                }
                            }
                            if (deque.isEmpty()) break;
                        }
                    }
                    floor[j] = count;
                }
            }
            ans.add(floor);
        }
        return ans.toArray(new int[0][]);
    }

    /**
     * 多源BFS
     *
     * @param mat
     * @return
     */
    public int[][] update(int[][] mat) {
        Deque<int[]> deque = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        visited = new boolean[m][n];
        int[][] ans = new int[m][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    deque.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!deque.isEmpty()) {
            int x = deque.peek()[0], y = deque.pop()[1];
            for (int[] dir : dirs) {
                int nx = dir[0] + x, ny = dir[1] + y;
                if (nx < 0 || nx >= mat.length || ny < 0 || ny >= mat[0].length) continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    ans[nx][ny] = ans[x][y] + 1;
                    deque.add(new int[]{nx, ny});
                }

            }
        }
        return ans;

    }

}
//[1,0,1,1,0,0,1,0,0,1]
//[0,1,1,0,1,0,1,0,1,1]
//[0,0,1,0,1,0,0,1,0,0]
//[1,0,1,0,1,1,1,1,1,1]
//[0,1,0,1,1,0,0,0,0,1]
//[0,0,1,0,1,1,1,0,1,0]
//[0,1,0,1,0,1,0,0,1,1]
//[1,0,0,0,1,1,1,1,0,1]
//[1,1,1,1,1,1,1,0,1,0]
//[1,1,1,1,0,1,0,0,1,1]