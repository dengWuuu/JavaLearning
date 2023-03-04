package 携程真题.k好数组;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Wu
 * @date 2023年03月03日 20:44
 */
public class Main {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt(), k = io.nextInt(), x = io.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer>[] lists = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            arr[i] = io.nextInt();
            lists[i % k].add(arr[i]);
        }

        int ans = Integer.MIN_VALUE;
        int[] maxNum = new int[k];

        for (int i = 0; i < k; i++) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            ArrayList<Integer> list = lists[i];
            for (int j = 0; j < lists[i].size(); j++) {
                max = Math.max(max, list.get(j));
                sum += list.get(j);
            }
            maxNum[i] = max;
            x -= list.size() * max - sum;
        }
        if (x < 0) {
            io.println(-1);
        } else {
            for (int i = 0; i < k; i++) {
                ans = Math.max(ans, x / lists[i].size() + maxNum[i]);
            }
            io.println(ans);
        }
        io.flush();
        io.close();
        return;
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
