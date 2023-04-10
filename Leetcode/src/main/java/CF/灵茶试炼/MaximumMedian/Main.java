package CF.灵茶试炼.MaximumMedian;

import java.io.*;
import java.util.*;

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
        long k = io.nextLong();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = io.nextInt();
        }
        Arrays.sort(arr);

        long l = -1, r = (long) (2e9 + 100);
        while (l + 1 < r) {
            long mid = (r + l) / 2;
            if (check(arr, k, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        io.println(l);
        io.flush();
        io.close();
    }

    //1 2 3 4 5 6
    public boolean check(int[] arr, long k, long num) {
        int n = arr.length;
        int mid = n / 2;
        for (int i = mid; i < n; i++) {
            if (arr[i] < num) k -= num - arr[i];
        }

        return k >= 0;
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
