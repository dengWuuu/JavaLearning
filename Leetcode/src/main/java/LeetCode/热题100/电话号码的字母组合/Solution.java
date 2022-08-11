package LeetCode.热题100.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年08月09日 21:22
 */
public class Solution {
    List<String> ans = new ArrayList<>();
    Map<Character, String> hashmap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return ans;
        backtrack(new StringBuffer(), digits, 0);
        return ans;
    }
    public void backtrack(StringBuffer sb, String digits, int index) {
        if (index == digits.length()) ans.add(sb.toString());
        else {
            char c = digits.charAt(index);
            String letters = hashmap.get(c);
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                backtrack(sb, digits, index + 1);
                sb.deleteCharAt(index);
            }
        }
    }
}
