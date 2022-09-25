package LeetCode.力扣2022秋季大赛.二叉树灯饰;

/**
 * @author Wu
 * @date 2022年09月24日 16:26
 */
public class Solution {
    int ans = 0;

    public int closeLampInTree(TreeNode root) {
        recur(root, 0);
        return ans;
    }

    public int recur(TreeNode root, int prevVal) {
        if (root == null) return -1;
        if (root.left == null && root.right == null && root.val == 1) return 1;
        else if (root.left == null && root.right == null && root.val == 0) return 0;
        int left = recur(root.left, root.val);
        int right = recur(root.right, root.val);

        if (prevVal == 0) {
            if (left == 0 && right == 0) {
                if (root.val == 1) {
                    ans += 1;
                    System.out.println(1);
                    return 0;
                } else if (root.val == 0) {
                    return 0;
                }
            } else if (left == 1 && right == 1) {
                if (root.val == 1) {
                    ans += 1;
                    System.out.println(2);
                    return 0;
                } else if (root.val == 0) {
                    System.out.println(3);
                    ans += 2;
                    return 0;
                }
            } else if ((left == 0 && right != -1) || (left != -1 && right == 0)) {
                if (root.val == 1) {
                    System.out.println(4);
                    ans += 1;
                    return 1;
                } else {
                    System.out.println(5);
                    ans += 1;
                    return 0;
                }
            } else if ((left == 1 && right == -1) || (right == 1 && left == -1)) {
                if (root.val == 1) {
                    return 1;
                }else {
                    System.out.println(6);
                    ans += 1;
                    return 0;
                }
            } else if ((left == 0 && right == -1) || (left == -1 && right == 0)) {
                if (root.val == 1) {
                    ans += 1;
                    System.out.println(7);
                }
                return 0;
            }

        } else {
            if (left == 0 && right == 0) {
                if (root.val == 1) {
                    return 1;
                } else if (root.val == 0) {
                    return 0;
                }
            } else if (left == 1 && right == 1) {
                if (root.val == 1) {
                    return 1;
                } else if (root.val == 0) {
                    System.out.println(8);
                    ans += 1;
                    return 1;
                }
            } else if ((left == 0 && right != -1) || (left != -1 && right == 0)) {
                if (root.val == 1) {
                    System.out.println(9);
                    ans += 1;
                    return 1;
                } else {
                    System.out.println(10);
                    ans += 1;
                    return 0;
                }
            } else if ((left == 1 && right == -1) || (right == 1 && left == -1)) {
                if (root.val == 1) {
                    return 1;
                } else {
                    System.out.println(11);
                    ans += 1;
                    return 1;
                }
            } else if ((left == 0 && right == -1) || (left == -1 && right == 0)) {
                return root.val;
            }
        }
        return root.val;

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}