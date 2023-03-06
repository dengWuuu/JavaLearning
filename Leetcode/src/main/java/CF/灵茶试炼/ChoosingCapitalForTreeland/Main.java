package CF.灵茶试炼.ChoosingCapitalForTreeland;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}

class Solution {
    Set<String> set = new HashSet<>();
    int cnt1 = 0;
    int res = 0;
    List<List<Integer>> g = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt() + 1;
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 2; i++) {
            int x = io.nextInt(), y = io.nextInt();
            g.get(x).add(y);
            g.get(y).add(x);
            set.add(x + "_" + y);
        }
        dfs(1, -1);
        res = cnt1;

        //换根dp
        reRoot(1, -1, cnt1);
        io.println(res);    //输出最小值

        //排序答案 输出
        Collections.sort(path);
        for (Integer integer : path) {
            io.print(integer + " ");
        }
        io.flush();
        io.close();

    }

    public void dfs(int x, int fa) {
        for (int y : g.get(x)) {
            if (y != fa) {
                if (!set.contains(x + "_" + y)) cnt1++;
                dfs(y, x);
            }
        }
    }

    public void reRoot(int x, int fa, int cnt) {
        if (cnt < res) {
            path = new ArrayList<>();
            path.add(x);
            res = cnt;
        } else if (cnt == res) {
            path.add(x);
        }
        for (int y : g.get(x)) {
            if (y != fa) {
                if (set.contains(x + "_" + y)) {
                    cnt++;
                    reRoot(y, x, cnt);
                    cnt--;
                }
                if (set.contains(y + "_" + x)) {
                    cnt--;
                    reRoot(y, x, cnt);
                    cnt++;
                }

            }
        }

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
