package LeetCode.周赛总.单周塞.周赛343.题1;

/**
 * @author Wu
 * @date 2023年4月30日 10:21
 */
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < player1.length; i++) {
            if ((i - 1 >= 0 && player1[i - 1] == 10) || (i - 2 >= 0 && player1[i - 2] == 10)) {
                cnt1 += player1[i] * 2;
            } else {
                cnt1 += player1[i];
            }
        }

        for (int i = 0; i < player2.length; i++) {
            if ((i - 1 >= 0 && player2[i - 1] == 10) || (i - 2 >= 0 && player2[i - 2] == 10)) {
                cnt2 += player2[i] * 2;
            } else {
                cnt2 += player2[i];
            }
        }

        if (cnt1 == cnt2) return 0;
        else if (cnt1 > cnt2) return 1;
        else return 2;
    }
}