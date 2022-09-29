package 剑指offer02.middle.机器人的运动范围;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wu
 * @date 2022年07月24日 17:26
 */
public class SolutionBfs {
    int m, n, k;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visit;

    public int movingCount(int m, int n, int k) {
        visit = new boolean[m][n];
        int ans = 0;
        queue.add(new int[]{0, 0, getValue(0, 0)});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            int value = poll[2];
            if (i >= m || j >= n || k < value || visit[i][j]) {
                continue;
            }
            visit[i][j] = true;
            ans++;
            queue.add(new int[]{i + 1, j, getValue(i + 1, j)});
            queue.add(new int[]{i, j + 1, getValue(i, j + 1)});
        }
        return ans;
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
