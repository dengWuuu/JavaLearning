package 代码随想录.额外的题目.有效的山脉数组;

/**
 * @author Wu
 * @date 2022年09月23日 22:54
 */
public class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length == 1) return false;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!flag) {
                if (arr[i + 1] == arr[i]) {
                    return false;
                } else if (arr[i + 1] < arr[i] && i == 0) {
                    return false;
                } else if (arr[i + 1] < arr[i]) {
                    flag = true;
                }
            } else {
                if (arr[i + 1] >= arr[i]) {
                    return false;
                }
            }
        }
        return flag;
    }
}
