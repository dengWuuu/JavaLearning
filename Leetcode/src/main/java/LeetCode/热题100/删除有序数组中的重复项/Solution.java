package LeetCode.热题100.删除有序数组中的重复项;

/**
 * @author Wu
 * @date 2022年08月11日 14:55
 */
public class Solution {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;
        while (left < n && right < n) {
            if (nums[left] == nums[right]) {
                while (right < n && nums[left] == nums[right]) right++;
                if (right == n) return left + 1;
            } else {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}
