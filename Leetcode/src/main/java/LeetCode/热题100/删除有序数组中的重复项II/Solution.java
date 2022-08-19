package LeetCode.热题100.删除有序数组中的重复项II;

/**
 * TODO:双指针重要题目
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 * @author Wu
 * @date 2022年08月19日 14:33
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int left = 2, right = 2;  //右指针指向当前处理,左指针表示合法的最后一位
        while (right < n){
            if(nums[left - 2] != nums[right]){
                nums[left] = nums[right];
                left++;
            }
            ++right;
        }
        return left;
    }
}