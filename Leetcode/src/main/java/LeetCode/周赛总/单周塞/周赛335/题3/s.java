package LeetCode.周赛总.单周塞.周赛335.题3;

/**
 * @author Wu
 * @date 2023年03月05日 12:14
 */

class s {

    public int findValidSplit(int[] nums) {
        int left[] = new int[1000000], right[] = new int[1000000], count = 0;
        for (int i = 0, j, k; i < nums.length; i++, right[k]++) {
            for (j = 2, k = nums[i]; j * j <= k; j++) {
                for (; k % j == 0; k /= j) {
                    right[j]++;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 2; j * j <= nums[i]; j++) {
                for (; nums[i] % j == 0; nums[i] /= j) {
                    count += (left[j]++ > 0 ? 0 : 1) - (--right[j] > 0 ? 0 : 1);
                }
            }
            if (nums[i] > 1) {
                count += (left[nums[i]]++ > 0 ? 0 : 1) - (--right[nums[i]] > 0 ? 0 : 1);
            }
            if (count == 0) {
                return i;
            }
        }
        return -1;
    }
}
