package 模板.快读;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年03月29日 9:59
 */

public class Kattio extends PrintWriter {
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
