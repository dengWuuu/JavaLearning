package LeetCode.周赛总.单周塞.周赛317.美丽整数的最小增量;

/**
 * @author Wu
 * @date 2022年10月30日 10:48
 */
public class Solution {
    public static long makeIntegerBeautiful(long n, int target) {
        long sum = getSum(n);
        if (sum <= target) return 0;

        long x = 0;
        String val = String.valueOf(n);
        long r = val.length() - 1;
        long idx = 1;
        while (r >= 0) {
            if (val.charAt((int) r) == '0') {
                r--;
                idx *= 10;
                continue;
            }
            long v = val.charAt((int) r) - '0';
            x += (10 - v) * idx;
            long s = (10 - v) * idx;
            n += s;
            val = String.valueOf(n);

            if (getSum(Long.parseLong(val)) <= target) {
                return x;
            }
            r--;
            idx *= 10;
        }
        return -1;
    }

    public static long getSum(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(makeIntegerBeautiful(6068060761L, 3));
    }

}