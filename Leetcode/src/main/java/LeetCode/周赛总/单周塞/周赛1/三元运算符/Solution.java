package LeetCode.周赛总.单周塞.周赛1.三元运算符;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年08月07日 11:31
 */
public class Solution {
    static Map<Integer, Integer> hash = new HashMap<>();

    public static int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            hash.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (hash.containsKey(diff + nums[i])) {
                int nextNums = hash.get(diff + nums[i]);
                if (nextNums > i) {
                    if (hash.containsKey(2 * diff + nums[i]))
                        if (hash.get(2 * diff + nums[i]) > nextNums) {
                            ans++;
                        }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        arithmeticTriplets(new int[]{0,1,4,6,7,10},3);
    }
}
