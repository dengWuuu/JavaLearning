package 剑指Offer_专项突击版.图.省份数量;

/**
 * @author Wu
 * @date 2022年10月21日 19:53
 */
public class Solution {
    boolean[] visit;
    int ans = 0;

    public int findCircleNum(int[][] isConnected) {
        visit = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visit[i]) {
                ans++;
                dfs(isConnected, i);
            }
        }
        return ans;
    }

    public void dfs(int[][] isConnected, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!visit[j] && isConnected[i][j] == 1) {
                visit[j] = true;
                dfs(isConnected, j);
            }
        }
    }
}