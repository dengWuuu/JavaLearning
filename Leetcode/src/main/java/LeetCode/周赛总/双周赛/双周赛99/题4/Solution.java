package LeetCode.周赛总.双周赛.双周赛99.题4;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */

public class Solution {
    public static void main(String[] args) {
        repairCars(new int[]{4, 2, 3, 1}, 10);
    }

    public static long repairCars(int[] ranks, int cars) {
        long l = -1;
        long r = Long.MAX_VALUE;
        while (l + 1 < r) {
            long mid = (r + l) / 2;
            if (check(mid, ranks, cars)) {
                r = mid;
            } else l = mid;
        }
        return r;
    }

    public static boolean check(long time, int[] ranks, int cars) {
        for (int i = 0; i < ranks.length; i++) {
            int num = 0;
            long t;
            while (num <= cars) {
                t = (long) num * ranks[i] * num;
                if (t < time) {
                    num++;
                } else break;
            }
            cars -= num - 1;
            if (cars <= 0) return true;
        }
        return false;
    }
}