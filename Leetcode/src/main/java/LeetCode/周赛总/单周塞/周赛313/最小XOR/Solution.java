package LeetCode.周赛总.单周塞.周赛313.最小XOR;

/**
 * @author Wu
 * @date 2022年10月02日 10:40
 */
public class Solution {
    public static int minimizeXor(int num1, int num2) {
        int ans = 0;
        int count = Integer.bitCount(num2);
        int num1Count = Integer.bitCount(num1);
        if (count == num1Count) return num1;
        else if (count < num1Count) {
            int tmp = num1;
            ans = tmp;
            for (int i = 0; i < count; i++) {
                ans -= Integer.highestOneBit(tmp);
                tmp -= Integer.highestOneBit(tmp);
            }
            return num1 - ans;
        } else {
            int times = count - num1Count;
            ans = num1;
            String s = Integer.toBinaryString(num1);
            int base = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    ans += base;
                    times--;
                }
                if (times == 0) return ans;
                base *= 2;
            }
            while (times > 0) {
                ans += base;
                base *= 2;
                times--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimizeXor(65, 84));
    }
}
