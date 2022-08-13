package LeetCode.热题100.移除元素;

/**
 * @author Wu
 * @date 2022年08月11日 16:05
 */
public class Solution {
    public static int removeElement(int[] nums, int val) {
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

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3}, 3));
    }
}
