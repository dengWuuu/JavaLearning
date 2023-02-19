package LeetCode.周赛总.单周塞.周赛326.题4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] zhishu = new boolean[right + 1];
        Arrays.fill(zhishu, true);
        zhishu[0] = false;
        zhishu[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (zhishu[i]) {
                for (int j = i * i; j <= right; j += i) {
                    zhishu[j] = false;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (zhishu[i]) list.add(i);
        }
        if (list.size() < 2) return new int[]{-1, -1};
        int min = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        for (int i = 1; i < list.size(); i++) {
            if (min > list.get(i) - list.get(i - 1)) {
                min = list.get(i) - list.get(i - 1);
                x = list.get(i - 1);
                y = list.get(i);
            }
        }
        return new int[]{x, y};
    }
}

