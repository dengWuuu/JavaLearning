package 携程真题.二三三数.correct;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long x = scanner.nextLong();
            int ans = 0;
            if (x % 233 != 0) System.out.println(-1);
            else {
                x /= 233;
                while (x != 0) {
                    ans += x % 10;
                    x /= 10;
                }
                System.out.println(ans);
            }
        }
    }
}