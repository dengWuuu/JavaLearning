package 字节跳动题库;

import java.util.Arrays;

public class ByteDance {
    public static void main(String[] args) {
        int num = 24131;
        int[] nums = new int[]{2, 4, 5};
        System.out.println(getMax(num, nums));
    }

    public static int max = Integer.MIN_VALUE;
    public static int len;
    public static int targetNum;

    public static int getMax(int target, int[] nums) {
        Arrays.sort(nums);
        int length = (target + "").length();
        targetNum = target;
        len = length;
        dfs(0, 0, nums);
        return max;
    }

    private static void dfs(int cur, int curLen, int[] nums) {
        max = Math.max(max, cur);
        if (curLen == len) return;
        for (int i = 0; i < nums.length; i++) {
            int tem = cur * 10 + nums[i];
            if (tem >= targetNum) {
                continue;
            }
            cur = cur * 10 + nums[i];
            curLen += 1;
            dfs(cur, curLen, nums);
            cur /= 10;
            curLen -= 1;

        }
    }
}
