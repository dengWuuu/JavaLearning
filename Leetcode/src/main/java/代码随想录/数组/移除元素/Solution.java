package 代码随想录.数组.移除元素;

/**
 * @author Wu
 * @date 2022年09月05日 10:12
 */
public class Solution {
    public int removeElement1(int[] nums, int val) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            while (left < n && left <= right && nums[left] != val) {
                left++;
            }
            while (right >= 0 && nums[right] == val && left <= right) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                nums[right] = val;
            }
        }
        return left;
    }

    public int removeElement2(int[] nums, int val) {
        int slowIdx = 0;
        for (int fastIdx = 0; fastIdx < nums.length; fastIdx++) {
            if (nums[fastIdx] != val) {
                nums[slowIdx] = nums[fastIdx];
                slowIdx++;
            }
        }
        return slowIdx;
    }
}
