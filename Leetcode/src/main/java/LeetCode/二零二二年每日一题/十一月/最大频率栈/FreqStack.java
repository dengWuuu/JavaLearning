package LeetCode.二零二二年每日一题.十一月.最大频率栈;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年11月30日 19:03
 */
public class FreqStack {
    Map<Integer, Integer> map = new HashMap<>();

    Map<Integer, List<Integer>> listMap = new HashMap<>();
    int max;

    public FreqStack() {
        max = 0;
    }

    public void push(int val) {
        int num = map.getOrDefault(val, 0);
        map.put(val, ++num);
        max = Math.max(max, num);
        List<Integer> list = listMap.getOrDefault(num, new ArrayList<>());
        list.add(val);
        listMap.put(num, list);
    }

    public int pop() {
        List<Integer> list = listMap.get(max);
        int ans = list.remove(list.size() - 1);
        map.put(ans, map.get(ans) - 1);
        if (list.size() == 0) max--;
        return ans;
    }
}
