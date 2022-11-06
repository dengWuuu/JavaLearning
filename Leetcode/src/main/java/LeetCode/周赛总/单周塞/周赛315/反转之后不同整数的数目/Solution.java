package LeetCode.周赛总.单周塞.周赛315.反转之后不同整数的数目;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年10月16日 10:33
 */
public class Solution {
    public int countDistinctIntegers(int[] nums) {
        int[] num = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            num[i] = this.reverse(nums[i] + "");
        }


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(num[i]);
            set.add(nums[i]);
        }
        return set.size();
    }

    public int reverse(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            s.append(str.charAt(i));
        }
        return Integer.parseInt(s.toString());
    }

}
