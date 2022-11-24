package 腾讯题库.格雷编码;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        ans.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(head + ans.get(i));
            }
            head <<= 1;
        }

        return ans;
    }
}
