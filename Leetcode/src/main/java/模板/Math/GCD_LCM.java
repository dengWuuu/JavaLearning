package 模板.Math;

/**
 * @author Wu
 * @date 2023年04月30日 23:58
 */
public class GCD_LCM {

    static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
