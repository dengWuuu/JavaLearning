package 腾讯题库.打乱数组;

import java.util.Random;

/**
 * @author Wu
 * @date 2022年11月19日 20:51
 */
public class Solution {
    int[] nums;
    int[] shuffle;
    Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        shuffle = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            swap(shuffle, i, i + random.nextInt(nums.length - i));
        }
        return shuffle;
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}