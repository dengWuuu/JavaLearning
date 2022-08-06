package LeetCode.剑指offer02.easy.打印从1到最大的n位数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年07月27日 13:24
 */
public class Solution {
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}

