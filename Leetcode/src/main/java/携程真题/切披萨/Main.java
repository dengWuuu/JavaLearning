package 携程真题.切披萨;

import java.util.Scanner;

//https://www.nowcoder.com/discuss/399672516925554688?sourceSSR=search
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float n = (float) sc.nextInt();
        int k = sc.nextInt();
        float l = n / ((k / 2) == 0 ? 1 : (k / 2 + 1));
        float w = n / (((k - k / 2) == 0) ? 1 : ((k - k / 2) + 1));
        System.out.println((float) Math.round(l * w * 100) / 100);
    }

}
