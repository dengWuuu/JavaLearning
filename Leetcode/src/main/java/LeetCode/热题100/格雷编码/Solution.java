package LeetCode.热题100.格雷编码;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月21日 21:17
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }

    public static List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(grayCode2(3));
    }
}