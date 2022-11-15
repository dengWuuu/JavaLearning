package 字节跳动题库.字典序的第K小数字;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static int findKthNumber(int n, int k) {
        int start = 1;
        while (k > 1) {
            int cnt = getCnt(start, n);
            if (cnt >= k) {
                start *= 10;
                k--;
            } else {
                k -= cnt;
                start++;
            }
        }
        return start;
    }

    public static int getCnt(int i, int limit) {
        String a = String.valueOf(i), b = String.valueOf(limit);
        int m = a.length(), n = b.length(), dis = n - m;
        int cnt = 0;
        int limitPrefix = Integer.parseInt(b.substring(0, m));
        for (int j = 0; j < dis; j++) {
            cnt += Math.pow(10, j);
        }

        if (i < limitPrefix) {
            cnt += Math.pow(10, dis);
        } else if (i == limitPrefix) {
            cnt += Integer.parseInt(b.substring(m)) + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(getCnt(123, 12456));
        System.out.println(getCnt(124, 12456));
    }


}