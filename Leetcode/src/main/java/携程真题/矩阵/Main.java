package 携程真题.矩阵;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int[][] a = new int[2][2], b = new int[2][2];
            int cnt0 = 0, cnt1 = 0;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    a[j][k] = sc.nextInt();
                    if (a[j][k] == 1) {
                        cnt0++;
                    }
                }
            }
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    b[j][k] = sc.nextInt();
                    if (b[j][k] == 1) {
                        cnt1++;
                    }
                }
            }
            if (cnt1 == cnt0) {
                int f1, f2, f3, f4;
                int ans;
                f1 = a[0][0] == b[0][0] ? 0 : 1;
                f2 = a[0][1] == b[0][1] ? 0 : 1;
                f3 = a[1][0] == b[1][0] ? 0 : 1;
                f4 = a[1][1] == b[1][1] ? 0 : 1;
                if (f1 + f2 + f3 + f4 == 0) {
                    ans = 0;
                } else if ((f1 & f4) == 1 || (f2 & f3) == 1) {
                    ans = 2;
                } else if (f1 + f2 + f3 + f4 == 2) ans = 1;
                else ans = 2;
                System.out.println(ans);
            } else System.out.println(-1);
        }
    }
}
