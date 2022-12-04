package 字节跳动题库.笔试题目;

import java.util.Scanner;
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder(str);
            for(int j = 2; j < sb.length(); j++){
                if(sb.charAt(j) == sb.charAt(j - 1) && sb.charAt(j - 2) == sb.charAt(j - 1)){
                    sb.deleteCharAt(j);
                    j--;
                    if(sb.length() < 3)break;
                }
            }

            for(int j = 3; j < sb.length(); j++){
                if(sb.charAt(j) == sb.charAt(j - 1) && sb.charAt(j - 2) == sb.charAt(j - 3)){
                    sb.deleteCharAt(j);
                    j--;
                    if(sb.length() < 4) break;
                }
            }
            System.out.println(sb);
        }
    }
}