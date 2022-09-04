package LeetCode.热题100.任务调度器;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月03日 22:00
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        for (char task : tasks) {
            hash[task - 'A']++;
        }
        Arrays.sort(hash);
        int minTakes = (hash[25] - 1) * (n + 1) + 1;

        for (int i = 24; i >= 0; i--) {
            if (hash[i] == hash[25]) minTakes++;
        }

        return Math.max(minTakes, tasks.length);
    }
}
