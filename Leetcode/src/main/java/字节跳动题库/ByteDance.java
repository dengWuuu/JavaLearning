package 字节跳动题库;

import java.util.Arrays;

public class ByteDance {
    public static void main(String[] args) {
        int num = 2000;
        int numns [] = new int[]{1,2,4,9};
        System.out.println(getMax(num, numns));
    }
    public static int max = Integer.MIN_VALUE;
    public static int len ;
    public static int targetNum;
    public static int [] nums;
    public static int getMax(int target, int [] array){
        Arrays.sort(array);
        int length = (target + "").length();
        targetNum = target;
        len = length;
        nums = array;
        dfs(0,0);
        return max;
    }

    private static void dfs(int cur, int curLen) {
        max = Math.max(max,cur);
        if(curLen == len) return;
        for(int i = 0; i < nums.length;i++){
            int tem  = cur *10 + nums[i];
            if(tem >= targetNum){
                continue;
            }
            cur = cur * 10 + nums[i];
            curLen+=1;
            dfs(cur,curLen);
            cur /= 10;
            curLen -= 1;

        }
    }
}
