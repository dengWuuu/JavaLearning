package 剑指offer02.easy.调整数组顺序使奇数位于偶数前面;


import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年07月28日 10:54
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 2, 3, 4})));

    }
}
