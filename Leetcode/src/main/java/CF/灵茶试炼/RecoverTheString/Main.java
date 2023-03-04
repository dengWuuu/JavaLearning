package CF.灵茶试炼.RecoverTheString;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年02月23日 22:57
 */
public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int c00 = io.nextInt(), c01 = io.nextInt(), c10 = io.nextInt(), c11 = io.nextInt();

        StringBuilder sb = new StringBuilder();
        int zero = getCnt(c00);
        int one = getCnt(c11);
        if (one == -1 || zero == -1) io.println("Impossible");





    }

    public static int getCnt(int num) {
        int cnt = (int) (Math.sqrt(num) + 1);
        for (int i = cnt; i >= 0; i--) {
            if (cnt * (cnt - 1) / 2 == num) return cnt;
        }
        return -1;
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
