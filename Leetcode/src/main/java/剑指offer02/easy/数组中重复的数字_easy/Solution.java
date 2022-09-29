package 剑指offer02.easy.数组中重复的数字_easy;

/**
 * @author Wu
 * @date 2022年07月20日 16:46
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int k = nums[i];
            if(k < 0) {
                k += n;
            }
            if(nums[k] < 0) {
                return k;
            }
            nums[k] -=n;
        }
        return -1;
    }
}
