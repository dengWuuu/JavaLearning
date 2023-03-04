package 携程真题.二三三数;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年03月03日 23:15
 */
//http://www.codefun2000.com/p/P1012
public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        for (int i = 0; i < t; i++) {
            String num = io.next();
            int cnt = 0;
            StringBuilder str = new StringBuilder("23300000000000");
            while (!isZero(num)) {
                if (num.compareTo(str.toString()) >= 1) {
                    num = sub(num, str.toString());
                    cnt++;
                } else {
                    str.deleteCharAt(str.length() - 1);
                }
            }
            if (isZero(num)) io.println(cnt);
            else io.println(-1);
        }
        io.flush();
        io.close();
    }

    public static String sub(String s1, String s2) {
        int lend = s1.length() - 1, rend = s2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while (lend >= 0 || rend >= 0) {
            int lNum = lend >= 0 ? Integer.parseInt(String.valueOf(s1.charAt(lend--))) : 0;
            int rNum = rend >= 0 ? Integer.parseInt(String.valueOf(s2.charAt(rend--))) : 0;
            if (lNum - j < rNum) {
                sb.append(lNum - rNum + 10 - j);
                j = 1;
            } else {
                sb.append(lNum - rNum - j);
                j = 0;
            }
        }
        sb.reverse();
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') i++;
        return sb.substring(i);
    }

    public static boolean isZero(String s) {
        return s.equals("");
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
