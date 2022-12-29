package LeetCode.周赛总.双周赛.双周赛94.题2;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月10日 22:16
 */
public class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));

        int n = student_id.length;
        int[][] res = new int[n][2];

        for (int i = 0; i < student_id.length; i++) {
            int cnt = 0;
            for (String s : report[i].split(" ")) {
                if (positive.contains(s)) {
                    cnt += 3;
                } else if (negative.contains(s)) cnt--;
            }
            res[i][0] = cnt;
            res[i][1] = student_id[i];
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] != o1[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(res[i][1]);
        }

        return ans;
    }
}