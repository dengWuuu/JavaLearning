package LeetCode.热题100.整数转罗马数字;

/**
 * @author Wu
 * @date 2022年08月09日 16:36
 */
public class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                sb.append(symbol);
            }
            if (num == 0) break;
        }
        return sb.toString();
    }
}