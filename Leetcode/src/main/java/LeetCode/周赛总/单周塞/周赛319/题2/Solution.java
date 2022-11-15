package LeetCode.周赛总.单周塞.周赛319.题2;

class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == k) ans++;
            for (int j = i + 1; j < nums.length; j++) {
                num = lcm(num, nums[j]);
                if (num > k) break;
                if (num == k) ans++;
            }
        }


        return ans;
    }

    public int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

}