package 字节跳动题库.分发糖果;

/**
 * @author Wu
 * @date 2022年11月14日 19:30
 */
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        for(int i = 0; i < n; i++){
            if(i > 0 && ratings[i] > ratings[i - 1]){
                candy[i] = candy[i - 1] + 1;
            }else candy[i] = 1;
        }
        int ans = 0;
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]) candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            ans += candy[i];
        }
        ans += candy[n - 1];


        return ans;
    }
}