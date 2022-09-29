package 剑指offer02.easy.替换空格_easy;

/**
 * @author Wu
 * @date 2022年07月23日 20:44
 */
public class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (symbol == ' '){
                sb.append("%20");
            }else {
                sb.append(symbol);
            }
        }
        return sb.toString();
    }
}
