package 字节青训营训练题目.Day1;

import java.util.*;

/**
 * @author Wu
 * @date 2022年12月30日 11:38
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        String str = scanner.nextLine();
        int[] set = new int[10];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                set[str.charAt(i) - '0']++;
            }
        }
        main.backTrack(str, 0, 0, new StringBuilder());
        System.out.println(main.ans);
    }
}


class Main {
    List<String> ans = new ArrayList<>();

    public void backTrack(String s, int idx, int pointNum, StringBuilder stringBuilder) {
        if (pointNum == 4 && idx == s.length()) {
            ans.add(stringBuilder.substring(0, stringBuilder.length() - 1));
            return;
        }
        if (pointNum == 4 && idx < s.length()) return;
        for (int j = idx; j < s.length() && j - idx <= 2
                && Integer.parseInt(s.substring(idx, j + 1)) <= 255
                && Integer.parseInt(s.substring(idx, j + 1)) >= 0;
             j++) {
            if (j > idx && s.charAt(idx) == '0') return;
            stringBuilder.append(s, idx, j + 1);
            if (pointNum < 4) {
                pointNum++;
                stringBuilder.append('.');
            }
            backTrack(s, j + 1, pointNum, stringBuilder);
            pointNum--;
            stringBuilder.delete(idx + pointNum, stringBuilder.length());
        }
    }
}
