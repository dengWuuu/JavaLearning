package 模板.树状数组;

/**
 * @author Wu
 * @date 2023年04月30日 21:34
 */
public class BIT {
    private final int[] tree;

    public BIT(int n) {
        tree = new int[n];
    }

    // 将下标 i 上的数加一
    public void inc(int i) {
        while (i < tree.length) {
            ++tree[i];
            i += i & -i;
        }
    }

    // 返回闭区间 [1, i] 的元素和
    public int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += tree[x];
            x &= x - 1;
        }
        return res;
    }

    // 返回闭区间 [left, right] 的元素和
    public int query(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}