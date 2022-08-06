package LeetCode.二零二二年每日一题.六月;

class Solution {
    public int numPrimeArrangements(int n) {
        int a = 0, b = 0;
        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                a++;
            }
        }
        b = n - a;
        long ans = 1;
        long mod = (long) 1e9 + 7;
        for (int i = a; i > 1; i--) {
            ans = (ans * i) % mod;
        }
        for (int i = b; i > 1; i--) {
            ans = (ans * i) % mod;
        }
        return (int) ans;
    }
}