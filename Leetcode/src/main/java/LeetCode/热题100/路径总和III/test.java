package LeetCode.热题100.路径总和III;

/**
 * @author Wu
 * @date 2022年09月01日 9:58
 */
public class test {
    public static void main(String[] args) {
        /**
         *
         KMPAlgorithm solution = new KMPAlgorithm();
         TreeNode root = new TreeNode(1000000000);
         TreeNode left = new TreeNode(1000000000);
         root.left = left;
         TreeNode ll = new TreeNode(294967296);
         left.left = ll;
         ll.left = new TreeNode(1000000000);
         ll.left.left = new TreeNode(1000000000);
         ll.left.left.left = new TreeNode(1000000000);
         System.out.println(solution.pathSum(root, 0));
         */
        Solution2 solution2 = new Solution2();
        TreeNode node = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;

        System.out.println(solution2.pathSum(node, 8));
    }
}
