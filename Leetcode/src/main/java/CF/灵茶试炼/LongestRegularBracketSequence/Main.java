package CF.灵茶试炼.LongestRegularBracketSequence;

import java.util.Scanner;

/**
 * @author Wu
 * @date 2023年02月21日 10:50
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int ans = 0;
        int cnt = 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else cnt--;
            if (cnt < 0) {
                cnt = 0;
                sum = 0;
                continue;
            }
            sum++;
            if (cnt == 0) {
                if (sum > ans) {
                    ans = sum;
                    count = 1;
                } else if (sum == ans) {
                    count++;
                }
            }
        }

        cnt = 0;
        sum = 0;
        int ans2 = 0;
        int count2 = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') cnt++;
            else cnt--;
            if (cnt < 0) {
                cnt = 0;
                sum = 0;
                continue;
            }
            sum++;
            if (cnt == 0) {
                if (sum > ans2) {
                    ans2 = sum;
                    count2 = 1;
                } else if (sum == ans2) {
                    count2++;
                }
            }
        }
        if (count != 0 || count2 != 0) {
            if (ans2 > ans) System.out.println(ans2 + " " + count2);
            else if (ans2 == ans) System.out.println(ans2 + " " + Math.max(count, count2));
            else System.out.println(ans + " " + count);
        } else System.out.println(0 + " " + 1);
    }
}
