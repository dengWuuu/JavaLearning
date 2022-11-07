package LeetCode.二零二二年每日一题.十一月.模糊坐标;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年11月07日 18:33
 */
public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String left = s.substring(0, i + 1), right = s.substring(i + 1);
            // System.out.print(left + "   "+ right+"                ");
            List<String> l = addPoint(left);
            List<String> r = addPoint(right);
            // System.out.print(l+"    " + r+"     ");
            for (String s1 : l) {
                for (String s2 : r) {
                    ans.add("(" + s1 + "," + s2 + ")");
                }
            }
//            System.out.println();
        }
        return ans;
    }

    public List<String> addPoint(String s) {
        List<String> res = new ArrayList<>();

        if (s.length() == 1 || s.charAt(0) != '0') res.add(s);
        for (int i = 0; i < s.length() - 1; i++) {
            String left = s.substring(0, i + 1), right = s.substring(i + 1);
            if ((left.length() == 1 || left.charAt(0) != '0') && right.charAt(right.length() - 1) != '0')
                res.add(left + "." + right);
        }
        return res;
    }
}