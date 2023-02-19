package 模板.筛子;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu
 * @date 2023年02月19日 8:52
 */
public class 筛法 {
    public void 埃氏筛法() {
        int n = 10000; //10000以下的质数
        boolean[] zhishu = new boolean[n + 1];
        Arrays.fill(zhishu, true);
        zhishu[0] = false;
        zhishu[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (zhishu[i]) {
                for (int j = i * i; j <= n; j += i) {
                    zhishu[j] = false;
                }
            }
        }
    }

    public void 欧拉筛() {
        int MX = (int) 1e6;
        int[] primes = new int[78500];
        var np = new boolean[MX + 1];
        var pi = 0;
        for (var i = 2; i <= MX; ++i) {
            if (!np[i]) primes[pi++] = i;
            for (var j = 0; j < pi; ++j) {
                var p = primes[j];
                if (i * p > MX) break;
                np[i * p] = true;
                if (i % p == 0) break;
            }
        }
        primes[pi++] = MX + 1;
        primes[pi++] = MX + 1; // 保证下面下标不会越界

    }
}
