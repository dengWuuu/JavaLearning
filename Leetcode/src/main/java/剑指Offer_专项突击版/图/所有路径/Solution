package 剑指Offer_专项突击版.图.所有路径;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, path, 0);
        return ans;
    }

    //i表示下一个节点
    public void dfs(int[][] graph, List<Integer> path, int i) {
        if (i == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            path.add(graph[i][j]);
            dfs(graph, path, graph[i][j]);
            path.remove(path.size() - 1);
        }
    }
}