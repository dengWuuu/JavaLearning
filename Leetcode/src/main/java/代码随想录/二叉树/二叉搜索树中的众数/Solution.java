package 代码随想录.二叉树.二叉搜索树中的众数;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月11日 13:27
 */
public class Solution {
    List<Integer> ans = new ArrayList<>();
    int maxCount = 0, count = 0;
    int pre = -10000;

    public int[] findMode(TreeNode root) {
        recur(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void recur(TreeNode root) {
        if (root == null) return;
        recur(root.left);

        if (pre == -10000) {
            count = 1;
        } else if (pre == root.val) {
            count++;
        } else {
            count = 1;
        }

        pre = root.val;

        if (count == maxCount) {
            ans.add(root.val);
        }
        if (count > maxCount) {
            ans.clear();
            ans.add(root.val);
            maxCount = count;
        }
        recur(root.right);
    }
}
