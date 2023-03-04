package 携程真题.红蓝数组;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
            }
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'R') {
                    arr[i][1] = 1;
                } else arr[i][1] = 0;
            }
            int bMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;
            int bMin = Integer.MAX_VALUE, rMin = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (arr[i][1] == 1) {
                    rMax = Math.max(rMax, arr[i][0]);
                    rMin = Math.min(rMin, arr[i][0]);
                } else {
                    bMax = Math.max(bMax, arr[i][0]);
                    bMin = Math.min(bMin, arr[i][0]);
                }
            }

            if (rMax >= bMax) {
                if (rMin >= bMin) {
                    System.out.println(rMax - bMin);
                } else {
                    System.out.println(rMax - rMin);
                }
            } else {
                int ans = Integer.MAX_VALUE;
                // 生红色
                ans = Math.min(ans, bMax - Math.min(bMax - rMax + rMin, bMin));
                ans = Math.min(ans, rMax - Math.min(bMin - bMax + rMax, rMin));
                System.out.println(ans);
            }

        }
    }
}

