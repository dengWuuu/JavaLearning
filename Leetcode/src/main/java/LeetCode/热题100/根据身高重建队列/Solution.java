package LeetCode.热题100.根据身高重建队列;

import java.util.*;

/**
 * @author Wu
 * @date 2022年08月31日 19:10
 */
public class Solution {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        List<int[]> ans = new LinkedList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }

        return ans.toArray(new int[0][]);
    }
}