package 代码随想录.贪心.柠檬水找零;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年09月16日 11:10
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) return false;
        }

        return true;
    }
}
