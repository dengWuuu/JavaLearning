package atcoder.灵茶试炼.SubsequencePath;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wu
 * @date 2022年12月24日 15:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] edges = new int[m + 1][3];
        for (int i = 1; i <= m; i++) {
            edges[i] = new int[]{in.nextInt(), in.nextInt(), in.nextInt()};
        }
        long[] res = new long[n + 1];
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = in.nextInt();
        }
        Arrays.fill(res, -1);
        res[1] = 0;
        for (int i = 0; i < k; i++) {
            int[] edge = edges[a[i]];
            if (res[edge[0]] != -1) {
                if (res[edge[1]] == -1 || res[edge[1]] > res[edge[0]] + edge[2]) {
                    res[edge[1]] = res[edge[0]] + edge[2];
                }
            }
        }
        System.out.println(res[n]);
    }
}
