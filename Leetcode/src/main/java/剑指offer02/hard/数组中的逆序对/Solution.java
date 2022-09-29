package 剑指offer02.hard.数组中的逆序对;

/**
 * @author Wu
 * @date 2022年08月02日 22:09
 */
public class Solution {
    static int[] num;
    static int[] tmp;

    public static int reversePairs(int[] nums) {
        num = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private static int mergeSort(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = (r - l) / 2 + l;
        int ans = mergeSort(l, m) + mergeSort(m + 1, r);
        int t = 0;
        //合并
        int i = l, j = m + 1;
        while (i <= m && j <= r) {
            if (num[i] <= num[j]) {
                tmp[t++] = num[i++];
            } else {
                tmp[t++] = num[j++];
                ans += m - i + 1;
            }
        }
        while (i <= m) {
            tmp[t++] = num[i++];
        }
        while (j <= r) {
            tmp[t++] = num[j++];
        }
        t = 0;
        while (l <= r) {
            num[l++] = tmp[t++];
        }
        return ans;
    }

    public static void main(String[] args) {
        reversePairs(new int[]{7,5,6,4});
    }
}
