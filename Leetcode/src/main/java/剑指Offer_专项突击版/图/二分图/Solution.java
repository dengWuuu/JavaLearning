package 剑指Offer_专项突击版.图.二分图;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年10月19日 11:21
 */
public class Solution {
    //表示每个节点是否染色
    int[] colors; // -1 未染色 0 表示白色 1 表示黑色

    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        colors = new int[m];
        Arrays.fill(colors, -1);
        for (int i = 0; i < m; i++) {
            if (colors[i] == -1) {
                if (!dfs(graph, i, 0)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int i, int color) {
        colors[i] = color;
        for (int node : graph[i]) {
            if (colors[node] == -1) {
                if (!dfs(graph, node, color == 0 ? 1 : 0)) return false;
            } else if (colors[node] == color) return false;
        }

        return true;
    }

}
