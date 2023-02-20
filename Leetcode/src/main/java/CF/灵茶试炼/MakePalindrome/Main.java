package CF.灵茶试炼.MakePalindrome;

import java.util.*;

/**
 * @author Wu
 * @date 2023年02月20日 11:17
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }
        int n = str.length();
        int i = 0;
        int j = 25;
        while (i < j) {
            while (i < j && cnt[i] % 2 == 0) i++;
            while (i < j && cnt[j] % 2 == 0) j--;
            if (i == j) break;
            cnt[i++]++;
            cnt[j--]--;
        }
        char[] ch = new char[n];
        i = 0;
        j = n - 1;
        for (int k = 0; k < 26; k++) {
            char c = (char) ('a' + k);
            while (cnt[k] > 0) {
                if (cnt[k] == 1) {
                    ch[n / 2] = c;
                    cnt[k]--;
                } else {
                    ch[i++] = c;
                    ch[j--] = c;
                    cnt[k] -= 2;
                }

            }
        }
        System.out.println(new String(ch));
    }
}
