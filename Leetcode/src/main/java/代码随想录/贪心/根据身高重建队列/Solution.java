package 代码随想录.贪心.根据身高重建队列;

import java.util.*;

/**
 * @author Wu
 * @date 2022年09月16日 11:20
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        ans.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            if (people[0][0] == 0) {
                ans.add(0, people[i]);
            } else {
                ans.add(people[i][1], people[i]);
            }
        }

        return ans.toArray(new int[0][]);
    }

}