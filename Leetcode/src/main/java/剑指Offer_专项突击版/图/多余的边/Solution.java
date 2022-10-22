package 剑指Offer_专项突击版.图.多余的边;

/**
 * @author Wu
 * @date 2022年10月22日 10:50
 */
public class Solution {
    int[] f;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        f = new int[n + 1];
        for (int i = 1; i < f.length; i++) {
            f[i] = i;
        }

        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            if (find(node1) != find(node2)) {
                union(node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int index1, int index2) {
        f[find(index1)] = find(index2);
    }

    public int find(int x) {
        return x == f[x] ? x : (f[x] = find(f[x]));
    }
}