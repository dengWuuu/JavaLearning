package CF.灵茶试炼.EqualizingByDivision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Wu
 * @date 2023年02月15日 11:39
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(judge(arr, n, k));
    }

    public static int judge(int[] arr, int n, int k) {
        ArrayList<Integer>[] lists = new ArrayList[200001];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            int count = 0;
            while (cur > 0) {
                lists[cur].add(count);
                cur /= 2;
                count++;
            }
            lists[0].add(count);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 200001; i++) {
            if (lists[i].size() < k) continue;
            Collections.sort(lists[i]);
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += lists[i].get(j);
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}
