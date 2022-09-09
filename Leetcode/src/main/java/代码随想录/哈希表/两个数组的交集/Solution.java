package 代码随想录.哈希表.两个数组的交集;

import java.util.*;

/**
 * @author Wu
 * @date 2022年09月06日 18:22
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }
        List<Integer> ans = new LinkedList<>();
        for (Integer integer : set1) {
            if (set2.contains(integer)) {
                ans.add(integer);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
