package LeetCode.周赛总.单周塞.周赛343.题4;

/**
 * @author Wu
 * @date 2023年4月30日 10:21
 */
class Solution {

    public String smallestBeautifulString(String s, int k) {
        char[] arr = s.toCharArray();
        int max = 'a' + k;
        int n = s.length();
        arr[n - 1]++;          //末尾+1
        int i = n - 1;
        while (i >= 0 && i < n)
            if (arr[i] == max) {
                if (i == 0) return "";
                arr[i] = 'a';
                i--;
                arr[i]++;
            } else if (i > 0 && arr[i] == arr[i - 1] || i > 1 && arr[i] == arr[i - 2]) {
                arr[i]++;
            } else {
                i++;
            }
        return String.valueOf(arr);
    }
}