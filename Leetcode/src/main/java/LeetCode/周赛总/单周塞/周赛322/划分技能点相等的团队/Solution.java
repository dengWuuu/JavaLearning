package LeetCode.周赛总.单周塞.周赛322.划分技能点相等的团队;

import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        long ans = 0;
        Arrays.sort(skill);
        int l = 0, r = skill.length - 1;
        int sum = skill[l] + skill[r];
        while (l < r) {
            if (skill[l] + skill[r] != sum) return -1;
            ans += (long) skill[l] * skill[r];
            l++;
            r--;
        }
        return ans;
    }
}