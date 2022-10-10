package 剑指Offer_专项突击版.二分查找.查找插入位置;

/**
 * @author Wu
 * @date 2022年10月10日 18:29
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return left;
    }
}
