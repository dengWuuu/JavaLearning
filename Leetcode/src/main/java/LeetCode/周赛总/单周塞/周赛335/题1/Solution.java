package LeetCode.周赛总.单周塞.周赛335.题1;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int passThePillow(int n, int time) {
        int cnt = 1;
        boolean flag = false;
        while (time-- > 0) {
            if (!flag) {
                cnt++;
                if (cnt == n) {
                    flag = true;
                }
            }else {
                cnt--;
                if (cnt == 1){
                    flag = false;
                }
            }
        }
        return cnt;
    }
}