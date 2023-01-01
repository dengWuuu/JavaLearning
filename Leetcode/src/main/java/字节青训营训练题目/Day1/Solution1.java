package 字节青训营训练题目.Day1;

import java.util.Scanner;

/**
 * @author Wu
 * @date 2022年12月29日 19:13
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(solution.sum(s1, s2));
    }
}


class Solution {
    String sum(String s1, String s2) {
        StringBuilder ans = new StringBuilder();

        int l = s1.length() - 1, r = s2.length() - 1, flag = 0;
        while (l >= 0 || r >= 0) {
            int a = l >= 0 ? getVal(s1.charAt(l)) : 0;
            int b = r >= 0 ? getVal(s2.charAt(r)) : 0;
            int sum = a + b + flag;

            if (sum >= 36) {
                flag = 1;
                sum -= 36;
            } else flag = 0;
            ans.insert(0, val(sum));
            l--;
            r--;
        }
        return ans.toString();
    }

    public int getVal(char character) {
        if (character >= '0' && character <= '9') return character - '0';
        return character - 'a' + 10;
    }

    public char val(int val) {
        if (val >= 0 && val <= 9) return (char) (val + '0');
        return (char) (val - 10 + 'a');
    }
}
