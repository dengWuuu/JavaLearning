package LeetCode.热题100.不同的二叉搜索树II;

import LeetCode.热题100.二叉树的中序遍历.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年08月22日 16:32
 */
public class Solution {
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    public static List<TreeNode> helper(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSub = helper(start, i - 1);
            List<TreeNode> rightSub = helper(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftSub) {
                for (TreeNode right : rightSub) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    ans.add(currTree);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(5));
    }
}
