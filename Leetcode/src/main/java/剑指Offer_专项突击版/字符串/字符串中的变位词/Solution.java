package 剑指Offer_专项突击版.字符串.字符串中的变位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月28日 11:37
 */
public class Solution {
    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arr1, arr2)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            arr2[s2.charAt(i) - 'a']++;
            arr2[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int j : arr) {
            if (j != 0) {
                diff++;
            }
        }
        if (diff == 0) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            int left = s2.charAt(i - s1.length()) - 'a', right = s2.charAt(i) - 'a';
            if (arr[left] == 0) {
                diff++;
            } else if (arr[left] == -1) diff--;
            arr[left]++;

            if (arr[right] == 1) diff--;
            else if (arr[right] == 0) diff++;
            arr[right]--;

            if (diff == 0) return true;
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion2("rokx", "otrxvfszxroxrzdsltg"));
    }
}
