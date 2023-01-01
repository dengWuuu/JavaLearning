package 牛客网.字节跳动;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月31日 20:03
 */
public class ZJ7 {
    Map<Character, List<Integer>> map = new HashMap<>();

    public void solve(String str, int m) {
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), new ArrayList<>());
            }
            map.get(str.charAt(i)).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            res = Math.max(res, cnt(entry.getValue(), m));
        }
        System.out.println(res);
    }

    public int cnt(List<Integer> list, int m) {
        int n = list.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.abs(list.get(i + 1) - list.get(i)) - 1;
        }
        for (int j = 2; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                dp[i][i + j] = dp[i + 1][i + j - 1] + Math.abs(list.get(i + j) - list.get(i)) - j;
            }
        }
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] <= m) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int m = sc.nextInt();
        ZJ7 zj7 = new ZJ7();
        zj7.solve(str, m);
    }
}
