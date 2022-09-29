package 剑指offer02.easy.旋转数组最小的数字;

/**
 * @author Wu
 * @date 2022年07月24日 12:25
 */
public class Solution {
    public int minArray(int[] numbers) {
        int r = numbers.length - 1;
        int l = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return numbers[r];
    }
}
