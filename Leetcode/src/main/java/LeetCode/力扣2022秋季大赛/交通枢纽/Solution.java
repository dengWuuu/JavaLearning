package LeetCode.力扣2022秋季大赛.交通枢纽;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年09月24日 15:13
 */
public class Solution {
    public int transportationHub(int[][] path) {
        Set<Integer> setNum = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(path, Comparator.comparingInt(x -> x[0]));
        for (int[] ints : path) {
            set.add(ints[0]);
            setNum.add(ints[0]);
            setNum.add(ints[1]);
        }
        int count = setNum.size() - 1;
        if (setNum.size() == set.size()) return -1;
        setNum.clear();
        for (int i = 0; i < path.length; i++) {
            if (set.contains(path[i][1])) continue;
            else {
                int num = path[i][1];
                for (int j = 0; j < path.length; j++) {
                    if (path[j][1] == num) {
                        setNum.add(path[j][0]);
                    }
                    if (setNum.size() == count) return num;
                }
            }

        }
        return -1;
    }
}
