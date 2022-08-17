package LeetCode.热题100.排列序列;

import java.util.ArrayList;

/**
 * @author Wu
 * @date 2022年08月16日 11:55
 */
public class Solution {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static String getPermutation(int n, int k) {
        dfs(n, 0, new boolean[n + 1], 0);
        return String.valueOf(arrayList.get(k - 1));
    }

    public static void dfs(int n, int current, boolean[] visited, int num) {
        if (current == n) {
            arrayList.add(num);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(n, current + 1, visited, num * 10 + i);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 10));
    }
}