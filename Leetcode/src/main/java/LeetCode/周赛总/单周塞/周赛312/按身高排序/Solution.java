package LeetCode.周赛总.单周塞.周赛312.按身高排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月25日 10:30
 */
public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String[] ans = new String[names.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(heights[ans.length - i - 1]);
        }
        return ans;
    }
}
