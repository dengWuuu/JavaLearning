package LeetCode.周赛总.单周塞.周赛322.回环句;

class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        if (s[0].charAt(0) != s[s.length - 1].charAt(s[s.length - 1].length() - 1)) return false;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].charAt(s[i].length() - 1) != s[i + 1].charAt(0)) return false;
        }

        return true;
    }
}