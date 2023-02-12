package LeetCode.周赛总.单周塞.周赛332.题3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 30; i > 0; i--) {
            for (int j = s.length() - i; j >= 0; j--) {
                map.put(Integer.valueOf(s.substring(j, i + j), 2), new int[]{j, i + j - 1});
            }
        }
        int[][] result = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            result[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], new int[]{-1, -1});
        }
        return result;
    }
}
