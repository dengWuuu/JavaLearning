package CF.灵茶试炼.AlmostRegularBracketSequence;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wu
 * @date 2023年02月16日 21:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.next();

        int[] sumFix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sumFix[i] = sumFix[i - 1] + (s.charAt(i - 1) == '(' ? 1 : -1);
        }
        long ans = 0;
        // 开始进行前后的判断操作
        int[] sufM = new int[n + 2];
        Arrays.fill(sufM, Integer.MAX_VALUE);
        for (int i = n; i >= 1; i--) {
            sufM[i] = Math.min(sufM[i + 1], sumFix[i]);
        }
        System.out.println(Arrays.toString(sumFix));
        System.out.println(Arrays.toString(sufM));
        if (Math.abs(sufM[n]) != 2) {
            System.out.println(0);
            return;
        }

        if (sufM[n] == 2) {
            for (int i = 1; i <= n; i++) {
                if (sumFix[i] < 0) break;
                if (s.charAt(i - 1) == '(' && sufM[i] > 1) {
                    ans++;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == ')' && sufM[i] >= -2) {
                    ans++;
                }
                if (sumFix[i] < 0) break;
            }
        }
        System.out.println(ans);
    }
}
