package 剑指offer02.middle.数组中数字出现的次数;

/**
 * @author Wu
 * @date 2022年08月04日 11:34
 */
public class Solution {
    static int n;

    public static int[] singleNumbers(int[] nums) {
        n = nums.length;
        int x = 0, y = 0, z = 0, m = 1;
        for (int i = 0; i < n; i++) {
            z ^= nums[i];
        }
        while ((z & m) == 0) {
            m <<= 1;
        }
        for (int i = 0; i < n; i++) {
            if ((nums[i] & m) == 0) x ^= nums[i];
            else y ^= nums[i];
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        singleNumbers(new int[]{1, 2, 5, 2});
    }
}
