package LeetCode.二零二二年每日一题.八月.数组中的字符串匹配;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月06日 12:56
 */
public class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
