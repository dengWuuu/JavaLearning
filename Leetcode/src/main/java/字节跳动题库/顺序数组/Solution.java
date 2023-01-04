package 字节跳动题库.顺序数组;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Wu
 * @date 2023年01月03日 11:10
 */
public class Solution {
    //  1 2 5 6 7 2 1
    public static int[] getArr(int[] arr) {
        int l = 1;
        while (l < arr.length && arr[l] != arr[l - 1]) l++;
        if (l == arr.length) return arr;
        int r = l + 1;
        while (r < arr.length) {
            while (r < arr.length && arr[l - 1] == arr[r]) r++;
            if (r == arr.length) break;
            swap(arr, l, r);
            l++;
            r++;
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(Arrays.toString(getArr(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 6, 7})));
    }
}
