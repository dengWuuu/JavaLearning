package LeetCode.周赛总.单周塞.周赛323.题3;

import java.util.Arrays;

/**
 * @author Wu
 * @date 2022年12月11日 10:21
 */
public class Allocator {
    int n;
    int[] arr;

    public Allocator(int n) {
        this.n = n;
        arr = new int[n];
    }

    public int allocate(int size, int mID) {
        int s = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                s++;
            } else {
                s = 0;
                idx = i + 1;
            }
            if (s == size) break;
        }

        if (s < size) return -1;
        else {
            for (int i = idx; i < size + idx; i++) {
                arr[i] = mID;
            }
            System.out.println(Arrays.toString(arr));
            return idx;
        }

    }

    public int free(int mID) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == mID) {
                arr[i] = 0;
                res++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return res;
    }
}

/**
 * Your Main object will be instantiated and called as such:
 * Main obj = new Main(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */