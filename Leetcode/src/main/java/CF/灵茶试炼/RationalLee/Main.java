package CF.灵茶试炼.RationalLee;

import java.io.*;
import java.util.*;

/**
 * @author Wu
 * @date 2023年04月17日 10:42
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve();
    }
}

class Solution {

    public void solve() {
        Kattio io = new Kattio();
        int T = io.nextInt();
        while (T-- > 0) {
            int n = io.nextInt(), k = io.nextInt();
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = io.nextInt();
            }
            Integer[] w = new Integer[k];
            for (int i = 0; i < k; i++) {
                w[i] = io.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(w);
            long ans = 0;
            int r = n - 1;
            //前k大的加入答案
            for (int i = 0; i < k; i++) {
                ans += a[r];
                if (w[i] == 1) ans += a[r];
                r--;
            }
            //统计剩下多少空间可以装小数（不会用到的）
            for (int i = k - 1, l = 0; i >= 0 && l <= r; i--) {
                if (w[i] == 1) break;
                ans += a[l];
                l += w[i] - 1;
            }

            io.println(ans);
            io.flush();

        }
    }

    public static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        // 标准 IO
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // 文件 IO
        public Kattio(String input, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(input));
        }

        // 在没有其他输入时返回 null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception ignored) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}