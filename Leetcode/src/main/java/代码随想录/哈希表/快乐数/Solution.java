package 代码随想录.哈希表.快乐数;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wu
 * @date 2022年09月06日 18:49
 */
public class Solution {
    Set<Integer> hash = new HashSet<>();

    public boolean isHappy(int n) {
        while (true) {
            int num = getNum(n);
            if (num == 0) return true;
            else {
                if (hash.contains(n)) {
                    return false;
                }
                hash.add(n);
                n = num;
            }
        }
    }

    public int getNum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += (number % 10) * (number % 10);
            number /= 10;
        }
        return sum;
    }
}
