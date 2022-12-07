package atcoder.灵茶试炼.C_Sequence;

import java.util.Arrays;
import java.util.Scanner;

//https://atcoder.jp/contests/abc059/tasks/arc072_a

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution();
    }
}

class Solution {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(Math.min(f(arr, 1), f(arr, -1)));
    }

    public long f(int[] arr, int head) {
        long res = 0;
        long prefix = 0;
        for (int i : arr) {
            prefix += i;
            if (prefix * head <= 0) {
                res += Math.abs(prefix - head);
                prefix = head;
            }
            head = -head;
        }
        return res;
    }
}
