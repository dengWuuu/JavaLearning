package CF.灵茶试炼.TolikAndHisUncle;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年02月23日 22:30
 */
public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int m = io.nextInt();
        int l = 1;
        int r = m;
        while (l <= r) {
            int a = 1;
            int b = n;
            while (b >= 1) {
                io.println(a + " " + l);
                a++;
                if (l == r && a > b) break;
                io.println(b + " " + r);
                b--;
                if (l == r && a > b) break;
            }
            l++;
            r--;
        }
        io.flush();
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
