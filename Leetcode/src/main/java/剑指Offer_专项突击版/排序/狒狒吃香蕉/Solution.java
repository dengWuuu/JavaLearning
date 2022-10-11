package 剑指Offer_专项突击版.排序.狒狒吃香蕉;

/**
 * @author Wu
 * @date 2022年10月11日 18:11
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile  - 1) / speed + 1;
            time += curTime;
        }
        return time;
    }
}