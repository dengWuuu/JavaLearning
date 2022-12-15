package LeetCode.周赛总.双周赛.双周赛89.有效时间的数目;

/**
 * @author Wu
 * @date 2022年10月15日 22:30
 */
public class Solution {
    public static int countTime(String time) {
        char[] chars = time.toCharArray();
        int x = 0;
        for (char aChar : chars) {
            if (aChar == '?') x++;
        }
        if (x == 4) return 1440;

        String[] split = time.split(":");
        String s = split[0];
        char a = s.charAt(0);
        char b = s.charAt(1);
        int hours;
        if (a != '?' && b != '?') hours = 1;
        else if (a == '?' && b == '?') hours = 24;
        else if (a == '?') {
            if (b < '4') hours = 3;
            else hours = 2;
        } else {
            if (a == '2') hours = 4;
            else hours = 10;
        }


        String s1 = split[1];
        char c = s1.charAt(0);
        char d = s1.charAt(1);
        int min;
        if (c != '?' && d != '?') min = 1;
        else if (c == '?' && d == '?') min = 60;
        else if (c == '6') min = 1;
        else if (c == '?' && d == '0') min = 6;
        else if (c == '?') min = 6;
        else min = 10;

        return min * hours;
    }

    public static void main(String[] args) {
        System.out.println(countTime("?9:?0"));
    }
}