package LeetCode.周赛总.单周塞.周赛325.题2;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    int k;

    public int takeCharacters(String s, int k) {
        this.k = k;
        int i = 0, j = s.length(), n = s.length();
        int[] cnt = new int[3];
        int ans = Integer.MAX_VALUE;
        while (!check(cnt)) {
            if (j == 0) return -1;
            j--;
            cnt[s.charAt(j) - 'a']++;
        }
        ans = n - j;
        while (i < n) {
            cnt[s.charAt(i) - 'a']++;
            while (j < n && cnt[s.charAt(j) - 'a'] > k) {
                cnt[s.charAt(j) - 'a']--;
                j++;
            }
            ans = Math.min(ans, i + 1 + n - j);
            i++;
        }
        return ans;
    }

    public boolean check(int[] cnt) {
        return cnt[0] >= k && cnt[1] >= k && cnt[2] >= k;
    }
}