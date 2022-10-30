package LeetCode.周赛总.双周赛.双周赛90.差值数组不同的字符串;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年10月29日 22:30
 */
public class Solution {
    public String oddString(String[] words) {
        boolean flag = false;
        int idx = 0;

        int[] arr = new int[words[0].length() - 1];
        for (int i = 0; i < words[0].length() - 1; i++) {
            arr[i] = words[0].charAt(i + 1) - words[0].charAt(i);
        }
        for (int i = 1; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];

            for (int j = 0; j < str1.length() - 1; j++) {
                int num1 = str1.charAt(j + 1) - str1.charAt(j);
                int num2 = str2.charAt(j + 1) - str2.charAt(j);
                if (num2 == num1) continue;
                else {
                    flag = true;
                    idx = i + 1;
                    for (int k = 0; k < str1.length() - 1; k++) {
                        int x = words[i].charAt(k + 1) - words[i].charAt(k);
                        if (x != arr[k]) return words[i];
                    }
                }
            }


        }

        return !flag ? words[0] : words[idx];
    }

}