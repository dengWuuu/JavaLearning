package 剑指offer02.hard.从1到n中整数1出现的次数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年07月31日 13:35
 */
public class Solution {
    public int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; k++) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(0, n % (mulk * 10) - mulk + 1), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
