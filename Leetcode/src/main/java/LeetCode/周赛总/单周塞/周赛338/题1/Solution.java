package LeetCode.周赛总.单周塞.周赛338.题1;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) return k;
        else if (numOnes + numZeros >= k) return numOnes;
        else return numOnes - (k - numOnes - numZeros);
    }
}