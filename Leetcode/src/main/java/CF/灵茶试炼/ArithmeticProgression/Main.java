package CF.灵茶试炼.ArithmeticProgression;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年03月29日 9:58
 */
//https://codeforces.com/problemset/problem/382/C
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve();
    }
}

class Solution {
    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.nextInt();
        }

        Arrays.sort(arr);
        if (n == 1) {
            System.out.println(-1);
            io.flush();
            io.close();
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int diff;
        for (int i = 1; i < n; i++) {
            diff = arr[i] - arr[i - 1];
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        if (map.size() == 1) {
            int d = arr[1] - arr[0];
            if (n == 2 && d != 0 && d % 2 == 0) {
                io.println(3);
                io.println((arr[0] - d) + " " + (arr[0] + d / 2) + " " + (arr[1] + d));
            } else {
                if (d == 0) {
                    io.println(1);
                    io.println(arr[0]);
                } else {
                    io.println(2);
                    io.println((arr[0] - d) + " " + (arr[n - 1] + d));
                }
            }
        } else if (map.size() == 2) {
            Integer q1 = null, q2 = null;
            for (int dif : map.keySet()) {
                if (q1 == null) q1 = dif;
                else q2 = dif;
            }
            int d1 = Math.max(q1, q2);
            int d2 = Math.min(q1, q2);
            if (d1 == d2 * 2 && map.get(d1) == 1) {
                io.println(1);
                for (int i = 1; i < n; i++) {
                    if (arr[i] - arr[i - 1] == d1) {
                        io.println(arr[i - 1] + d2);
                    }
                }
            } else {
                io.println(0);
            }
        } else {
            io.println(0);
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
