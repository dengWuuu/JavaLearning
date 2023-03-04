package atcoder.灵茶试炼.AlmostSorted;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution();
    }
}


class Solution {
    int mod = 998244353;

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][1 << (2 * d)];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < (1 << (2 * d)); mask++) {
                int res = dp[i][mask];
                for (int j = Math.max(0, i - d); j <= Math.min(n - 1, i + d); j++) {
                    if ((arr[i] == -1 || arr[i] - 1 == j) && (mask >> (j - i + d) & 1) == 0) {
                        int newMask = (mask | (1 << j - i + d)) >> 1;
                        dp[i + 1][newMask] = (dp[i + 1][newMask] + res) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int i : dp[n]) {
            ans = (ans + i) % mod;
        }
        System.out.println(ans);
    }
}
