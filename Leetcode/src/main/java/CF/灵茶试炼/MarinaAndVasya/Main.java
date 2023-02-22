package CF.灵茶试炼.MarinaAndVasya;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年02月22日 19:13
 */
public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt(), t = io.nextInt();
        String s1 = io.next();
        String s2 = io.next();
        String alph = "qwertyuiopasdfghjklzxcvbnm";
        char[] ans = new char[n];
        int cnt = 0;
        int same = n - t;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) cnt++;
        }
        if (cnt >= same) {
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) == s2.charAt(i) && same > 0) {
                    same--;
                    ans[i] = s1.charAt(i);
                } else {
                    for (int j = 0; j < 26; j++) {
                        if (alph.charAt(j) != s1.charAt(i) && alph.charAt(j) != s2.charAt(i)) {
                            ans[i] = alph.charAt(j);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    same--;
                    ans[i] = s1.charAt(i);
                }
            }
            int s1count = same;
            int s2count = same;
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (s1count > 0) {
                        s1count--;
                        ans[i] = s1.charAt(i);
                    } else if (s2count > 0) {
                        s2count--;
                        ans[i] = s2.charAt(i);
                    } else {
                        for (int j = 0; j < 26; j++) {
                            if (alph.charAt(j) != s1.charAt(i) && alph.charAt(j) != s2.charAt(i)) {
                                ans[i] = alph.charAt(j);
                            }
                        }
                    }
                }
            }
            if (s1count != 0 || s2count != 0) {
                io.println(-1);
                io.flush();
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            io.print(ans[i]);
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
