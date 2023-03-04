package 字节跳动笔试真题.二叉树染色;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年03月03日 22:52
 */
public class Main {
    ArrayList<Integer>[] g;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}

class Solution {
    ArrayList<Integer>[] g;
    int[] ans;

    public void dfs(int i) {

    }

    public void solve() {
        Kattio io = new Kattio();

        int n = io.nextInt();
        g = new ArrayList[n + 1];
        ans = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = io.nextInt();
            int v = io.nextInt();
            int max = Math.max(u, v);
            int min = Math.min(u, v);

            g[u].add(v);
            g[v].add(u);
        }
        dfs(1);


        for (int i = 1; i <= n; i++) {
            if (ans[i] == 1) io.print("B");
            else io.print("R");
        }
        io.flush();
        io.close();
    }

    public static class Kattio extends PrintWriter {
        private BufferedReader r;
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
        public Kattio(String intput, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(intput));
        }

        // 在没有其他输入时返回 null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
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
