import java.util.*;

/**
 * @author Wu
 * @date 2023年02月05日 10:31
 */
// 2 2 2 4
// 1 1 2 4
public class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Arrays.sort(basket1);
        Arrays.sort(basket2);
        int minCost = Math.min(basket1[0], basket2[0]);
        int n = basket1.length;
        long cost = 0;
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < basket1.length && j < basket2.length) {
            if (basket1[i] == basket2[j]) {
                i++;
                j++;
            } else {
                if (basket1[i] < basket2[j]) {
                    if (i + 1 == n || basket1[i] != basket1[i + 1]) {
                        // System.out.println(1);
                        return -1;
                    }
                    list.add(basket1[i]);
                    list.add(basket1[i]);
                    i += 2;
                } else {
                    if (j + 1 == n || basket1[j] != basket1[j + 1]) {
                        // System.out.println(2);
                        return -1;
                    }
                    list.add(basket2[j]);
                    list.add(basket2[j]);
                    j += 2;
                }
            }
        }
        if (i != n) {
            for (int k = i; k < n; k++) {
                list.add(basket1[k]);
            }
        } else if (j != n) {
            for (int k = j; k < n; k++) {
                list.add(basket2[k]);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (Objects.equals(list.get(l + 1), list.get(l)) && Objects.equals(list.get(r), list.get(r - 1))) {
                cost += Math.min(list.get(i),minCost);
                l += 2;
                r -= 2;
            } else return -1;
        }
        return cost;
    }
}