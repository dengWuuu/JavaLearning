package CF.灵茶试炼.PointsAndPowersOfTwo;

import java.io.*;
import java.util.*;

/**
 * @author Wu
 * @date 2023年03月30日 10:34
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}

class Solution {
    public void solve() {
        Kattio io = new Kattio();
        int n = io.nextInt();
        Set<Integer> set = new HashSet<>();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = io.nextInt();
            set.add(a[i]);
        }
        Arrays.sort(a);
        int p = 1;
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for (int i = 0; i <= 31; i++) {
            for (int j = 0; j < n - 1; j++) {
                if ((long) a[j] + p > Integer.MAX_VALUE) break;
                if (set.contains(a[j] + p)) {
                    ans = 2;
                    if (ans > list.size()) {
                        list.clear();
                        list.add(a[j]);
                        list.add(a[j] + p);
                    }
                    if ((long) a[j] + (long) 2 * p > Integer.MAX_VALUE) break;
                    if (j + 2 < n && set.contains(a[j] + p * 2)) {
                        ans = 3;
                        list.clear();
                        list.add(a[j]);
                        list.add(a[j] + p);
                        list.add(a[j] + p * 2);
                        break;
                    }

                }
            }
            if (ans == 3) break;
            p *= 2;
        }
        io.println(list.size());
        for (int num : list) {
            io.print(num + " ");
        }
        io.flush();
        io.close();
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