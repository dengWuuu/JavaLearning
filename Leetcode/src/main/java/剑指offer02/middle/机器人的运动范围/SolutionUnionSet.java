package 剑指offer02.middle.机器人的运动范围;

/**
 * @author Wu
 * @date 2022年07月24日 15:34
 */
public class SolutionUnionSet {
    private static int[] father;

    public void init(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public static int getValue(int m, int n) {
        int value = 0;
        while (m != 0) {
            value += m % 10;
            m /= 10;
        }
        while (n != 0) {
            value += n % 10;
            n /= 10;
        }
        return value;
    }

    public static int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return find(father[x]);
    }

    /**
     * 把y连接到x上面
     *
     * @param x x
     * @param y y
     */
    public static void union(int x, int y) {
        father[y] = find(x);
    }

    public int movingCount(int m, int n, int k) {
        init(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (getValue(i, j) > k) {
                    continue;
                }
                if (i > 0 && getValue(i - 1, j) <= k) {
                    union((i - 1) * n + j, i * n + j);
                }
                if (j > 0 && getValue(i, j - 1) <= k) {
                    union(i * n + j - 1, i * n + j);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (father[i * n + j] == father[0]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        father = new int[]{0, 1, 2};
        union(1, 2);
        union(0, 1);
        System.out.println(find(0));
    }
}
