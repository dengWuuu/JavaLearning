package LeetCode.热题100.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月01日 20:20
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = (nums[i] - 1) % n;
            nums[x] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
