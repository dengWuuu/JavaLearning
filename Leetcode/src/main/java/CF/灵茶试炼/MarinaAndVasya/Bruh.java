package CF.灵茶试炼.MarinaAndVasya;

import java.util.*;
import java.io.*;

public class Bruh {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        String alph = "qwertyuiopasdfghjklzxcvbnm";
        char[] end = new char[n];
        int same = n - t;
        int both = 0;
        String s = f.readLine();
        String s2 = f.readLine();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s2.charAt(i)) both++;
        }
        if (both >= same) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == s2.charAt(i) && same > 0) {
                    same--;
                    end[i] = s.charAt(i);
                } else {
                    for (int j = 0; j < 26; j++) {
                        if (alph.charAt(j) != s.charAt(i) && alph.charAt(j) != s2.charAt(i)) {
                            end[i] = alph.charAt(j);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == s2.charAt(i)) {
                    same--;
                    end[i] = s.charAt(i);
                }
            }
            int s1count = same;
            int s2count = same;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != s2.charAt(i)) {
                    if (s1count > 0) {
                        s1count--;
                        end[i] = s.charAt(i);
                    } else if (s2count > 0) {
                        s2count--;
                        end[i] = s2.charAt(i);
                    } else {
                        for (int j = 0; j < 26; j++) {
                            if (alph.charAt(j) != s.charAt(i) && alph.charAt(j) != s2.charAt(i)) {
                                end[i] = alph.charAt(j);
                            }
                        }
                    }
                }
            }
            if (s1count != 0 || s2count != 0) {
                out.println(-1);
                out.close();
                f.close();
                return;
            }
        }
        for (int i = 0; i < end.length; i++) {
            out.print(end[i]);
        }
        out.println();
        out.close();
        f.close();
    }

}