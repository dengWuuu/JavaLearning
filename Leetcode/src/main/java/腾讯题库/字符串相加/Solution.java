package 腾讯题库.字符串相加;

/**
 * @author Wu
 * @date 2022年11月09日 21:13
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int l = num1.length() - 1, r = num2.length() - 1;
        int entry = 0;
        StringBuilder ans = new StringBuilder();
        while (l >= 0 || r >= 0) {
            int left = l >= 0 ? num1.charAt(l) - '0' : 0;
            int right = r >= 0 ? num2.charAt(r) - '0' : 0;
            int sum = left + right + entry;

            if (sum >= 10) {
                sum -= 10;
                entry = 1;
            } else entry = 0;

            ans.insert(0, sum);
            l--;
            r--;
        }

        if (entry > 0) {
            ans.insert(0, 1);
        }


        return ans.toString();
    }
}