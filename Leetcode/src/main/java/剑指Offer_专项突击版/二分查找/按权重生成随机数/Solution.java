package 剑指Offer_专项突击版.二分查找.按权重生成随机数;

import java.util.Random;

/**
 * @author Wu
 * @date 2022年10月10日 19:12
 */
public class Solution {
    private int[] acc;
    private static final Random RND = new Random();

    public Solution(int[] w) {
        acc = w.clone();
        for (int i = 1; i < acc.length; ++i)
            acc[i] += acc[i - 1];
    }

    public int pickIndex() {
        int lo = 0, hi = acc.length - 1;
        int r = RND.nextInt(acc[hi]) + 1;  // 把[0, last)提升到[1, last]
        while (lo < hi) {  // 寻找首个值大于r的位置
            int mid = (lo + hi) / 2;
            if (acc[mid] >= r)  // 不一定是首个
                hi = mid;
            else  // 太小了，最快也得是下个位置符合要求
                lo = mid + 1;
        }
        return lo;
    }
}