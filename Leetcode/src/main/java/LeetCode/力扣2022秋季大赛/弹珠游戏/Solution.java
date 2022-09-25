package LeetCode.力扣2022秋季大赛.弹珠游戏;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月24日 15:29
 */
public class Solution {
    public int[][] ballGame(int num, String[] plate) {
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < plate.length - 1; i++) {
            if (plate[i].charAt(0) != '.') continue;
            if (dfs(num, plate, i, 0, i, -1)) {
                ans.add(new int[]{i, 0});
            }
        }
        for (int i = 1; i < plate.length - 1; i++) {
            if (plate[i].charAt(plate[0].length() - 1) != '.') continue;
            if (dfs(num, plate, i, plate[0].length() - 1, i, plate[0].length())) {
                ans.add(new int[]{i, plate[0].length() - 1});
            }
        }
        for (int j = 1; j < plate[0].length() - 1; j++) {
            if (plate[0].charAt(j) != '.') continue;
            if (dfs(num, plate, 0, j, -1, j)) {
                ans.add(new int[]{0, j});
            }
        }
        for (int j = 1; j < plate[0].length() - 1; j++) {
            if (plate[plate.length - 1].charAt(j) != '.') continue;
            if (dfs(num, plate, plate.length - 1, j, plate.length, j)) {
                ans.add(new int[]{plate.length - 1, j});
            }
        }
        return ans.toArray(new int[0][]);
    }

    public boolean dfs(int num, String[] plate, int i, int j, int preI, int preJ) {
        if (i < 0 || i >= plate.length || j < 0 || j >= plate[0].length()) return false;
        if (plate[i].charAt(j) == 'O' && num >= 0) return true;
        if (num == 0) return false;
        int shuiPing = j - preJ;
        int shuzhi = i - preI;
        if (plate[i].charAt(j) == 'W') {
            if (shuiPing < 0 && shuzhi == 0) {
                return dfs(num - 1, plate, i + 1, j, i, j);
            } else if (shuiPing == 0 && shuzhi < 0) {
                return dfs(num - 1, plate, i, j - 1, i, j);
            } else if (shuiPing > 0 && shuzhi == 0) {
                return dfs(num - 1, plate, i - 1, j, i, j);
            } else if (shuiPing == 0 && shuzhi > 0) {
                return dfs(num - 1, plate, i, j + 1, i, j);
            }

        } else if (plate[i].charAt(j) == 'E') {
            if (shuiPing < 0 && shuzhi == 0) {
                return dfs(num - 1, plate, i - 1, j, i, j);
            } else if (shuiPing == 0 && shuzhi < 0) {
                return dfs(num - 1, plate, i, j + 1, i, j);
            } else if (shuiPing > 0 && shuzhi == 0) {
                return dfs(num - 1, plate, i + 1, j, i, j);
            } else if (shuiPing == 0 && shuzhi > 0) {
                return dfs(num - 1, plate, i, j - 1, i, j);
            }
        } else {
            if (shuiPing < 0 && shuzhi == 0) {
                return dfs(num - 1, plate, i, j - 1, i, j);
            } else if (shuiPing == 0 && shuzhi < 0) {
                return dfs(num - 1, plate, i - 1, j, i, j);
            } else if (shuiPing > 0 && shuzhi == 0) {
                return dfs(num - 1, plate, i, j + 1, i, j);
            } else if (shuiPing == 0 && shuzhi > 0) {
                return dfs(num - 1, plate, i + 1, j, i, j);
            }
        }

        return false;
    }
}
//41\
//[[1,0],[3,0],[4,0],[6,0],[1,8],[3,8],[0,2],[0,3],[0,5],[0,6],[7,1],[7,4]]
//[[0,2],[0,3],[0,5],[0,6],[1,0],[1,8],[3,0],[3,8],[4,0],[6,0],[7,1],[7,4]]
//[[1,0],[1,8],[3,0],[3,8],[4,0],[4,8],[6,0],[7,1],[0,2],[7,2],[0,3],[7,3],[7,4],[0,5],[0,6]]

// "E...W..WW", 0
// ".E...O...", 1
// "...WO...W", 2
// "..OWW.O..", 3
// ".W.WO.W.E", 4
// "O..O.W...", 5
// ".OO...W..", 6
// "..EW.WEE.", 7