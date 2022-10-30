package LeetCode.周赛总.双周赛.双周赛90.距离字典两次编辑以内的单词;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年10月29日 22:51
 */
public class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (String query : queries) {
            for (String s : dictionary) {
                if (judge(query, s)) {
                    ans.add(query);
                    break;
                }
            }
        }
        return ans;

    }

    public boolean judge(String str1, String str2) {
        int num = 0;
        int left = 0, right = 0;
        while (left < str1.length()) {
            if (str1.charAt(left++) != str2.charAt(right++)) {
                num++;
                if (num == 3) return false;
            }
        }
        return true;
    }
}
