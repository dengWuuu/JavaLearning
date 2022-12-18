package 高级数据结构板子.树状数组;

/**
 * @author Wu
 * @date 2022年12月17日 22:17
 */
public class FenwickTree {
    int[] t1;
    int[] t2;
    int n;

    public FenwickTree(int n) {
        t1 = new int[n];
        t2 = new int[n];
        this.n = n;
    }

    int lowbit(int x) {
        return x & (-x);
    }

    void add(int k, int v) {
        int v1 = k * v;
        while (k <= n) {
            t1[k] += v;
            t2[k] += v1;
            k += lowbit(k);
        }
    }

    int getSum(int[] t, int k) {
        int ret = 0;
        while (k > 0) {
            ret += t[k];
            k -= lowbit(k);
        }
        return ret;
    }

}
