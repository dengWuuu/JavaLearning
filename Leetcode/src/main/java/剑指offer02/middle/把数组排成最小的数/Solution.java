package 剑指offer02.middle.把数组排成最小的数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月01日 15:22
 */
public class Solution {
    public String minNumber(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int num : nums) {
            ans.add(String.valueOf(num));
        }
        ans.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder res = new StringBuilder();
        for (String an : ans) {
            res.append(an);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        ans.add("3");
        ans.add("30");
        ans.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(ans);
    }

}
