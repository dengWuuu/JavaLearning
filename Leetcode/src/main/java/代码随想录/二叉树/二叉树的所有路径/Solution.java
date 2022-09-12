package 代码随想录.二叉树.二叉树的所有路径;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年09月10日 9:41
 */
public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;
        backTrack(root, new StringBuilder());
        return ans;
    }

    public void backTrack(TreeNode root, StringBuilder path) {
        path.append(root.val).append("->");
        if (root.left == null && root.right == null) {
            StringBuilder newPath = new StringBuilder(path);
            newPath.delete(newPath.length() - 2, newPath.length());
            ans.add(newPath.toString());
        }
        if (root.left != null) backTrack(root.left, path);
        if (root.right != null) backTrack(root.right, path);
        path.delete(path.length() - 2, path.length());
        int tmp = root.val;
        while (tmp != 0) {
            path.deleteCharAt(path.length() - 1);
            tmp /= 10;
        }
        if (root.val < 0) {
            path.deleteCharAt(path.length() - 1);
        }
    }
}