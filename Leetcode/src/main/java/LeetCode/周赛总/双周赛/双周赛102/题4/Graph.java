package LeetCode.周赛总.双周赛.双周赛100.题4;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */

public class Graph {

    public int MaxValue = (int) 1e9;
    int n;

    int[][] Nmatrix;

    public Graph(int n, int[][] edges) {
        Nmatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Nmatrix[i][j] = MaxValue;
            }
        }
        for (int[] edge : edges) {
            Nmatrix[edge[0]][edge[1]] = edge[2];
        }
        this.n = n;
    }

    public void addEdge(int[] edge) {
        Nmatrix[edge[0]][edge[1]] = edge[2];
    }

    public int shortestPath(int node1, int node2) {
        int[][] matrix = new int[300][300];
        for (int i = 0; i < Nmatrix.length; i++) {
            matrix[i] = Arrays.copyOf(Nmatrix[i], Nmatrix.length);
        }
        return dijstra(matrix, node1, node2);
    }

    public int dijstra(int[][] matrix, int source, int target) {
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