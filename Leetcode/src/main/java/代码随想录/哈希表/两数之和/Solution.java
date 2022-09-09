package 代码随想录.哈希表.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月06日 18:57
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
