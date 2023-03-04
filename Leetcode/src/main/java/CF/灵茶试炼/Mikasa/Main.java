package CF.灵茶试炼.Mikasa;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年03月02日 23:26
 */
public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int t = io.nextInt();

        for (int i = 0; i < t; i++) {
            long n = io.nextLong(), m = io.nextLong();
            long ans = 0L;
            for (long j = 30L; j >= 0; j--) {
                if (((m + 1L) & (1L << j)) != 0 && ((n & (1L << j)) == 0)) ans |= (1L << j);
                else if ((n & (1L << j)) != 0 && (((m + 1) & (1L << j)) == 0)) break;
            }
            io.println(ans);
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
