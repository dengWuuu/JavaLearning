package 剑指offer02.middle.剪绳子2;

/**
 * @author Wu
 * @date 2022年07月25日 13:37
 */
class Solution {
    public int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }
        long res = 1;
        while(n > 4){
            res  = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
