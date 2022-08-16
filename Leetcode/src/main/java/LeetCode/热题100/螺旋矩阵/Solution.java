package LeetCode.热题100.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月15日 12:42
 */
public class Solution {
    static List<Integer> ans = new ArrayList<>();

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (true) {
            for (int i = left; i <= right; i++) ans.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) ans.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) ans.add(matrix[bottom][i]);
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) ans.add(matrix[i][left]);
            if (++left > right) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{2,5,8}, {4,0,-1}}));
    }
}
