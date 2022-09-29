package 剑指offer02.easy.数组中超过一半的数字;

/**
 * @author Wu
 * @date 2022年07月31日 11:28
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
