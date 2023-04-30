package 模板.Dij;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2023年04月30日 23:29
 */
public class Dij {
    int MaxValue;

    /**
     *
     * @param matrix 图
     * @param source 目标
     * @param target 目的地
     * @param n 几个点
     * @return
     */
    public int dijstra(int[][] matrix, int source, int target, int n) {
        //最短路径长度
        int[] shortest = new int[n];
        Arrays.fill(shortest, MaxValue);
        //判断该点的最短路径是否求出
        int[] visited = new int[n];
        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < n; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }
            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;
            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < n; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                }
            }
        }
        return shortest[target] >= 1e9 ? -1 : shortest[target];
    }
}
