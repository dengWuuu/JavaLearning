package 模板.线段树;

/**
 * @author Wu
 * @date 2023年02月19日 16:29
 */
public class Solution {
    public static class Node {
        Node left;
        Node right;
        int l;
        int r;
        boolean lazy;
        int totalSum;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public Node build(int[] nums, int l, int r) {
        if (l == r) {
            Node ans = new Node(l, r);
            ans.totalSum = nums[l];
            return ans;
        }
        int middle = l + (r - l) / 2;
        Node ans = new Node(l, r);
        ans.left = build(nums, l, middle);
        ans.right = build(nums, middle + 1, r);
        ans.totalSum = ans.left.totalSum + ans.right.totalSum;
        return ans;
    }

    private void pushDown(Node node) {
        if (node.lazy) {
            node.lazy = false;
            node.left.lazy = !node.left.lazy;
            node.right.lazy = !node.right.lazy;
            node.left.totalSum = node.left.r - node.left.l + 1 - node.left.totalSum;
            node.right.totalSum = node.right.r - node.right.l + 1 - node.right.totalSum;
        }
    }

    private void pushUp(Node node) {
        node.totalSum = node.left.totalSum + node.right.totalSum;
    }

    public void update(Node node, int l, int r) {
        int left = node.l;
        int right = node.r;
        if (left > r || right < l) return;
        if (left >= l && right <= r) {
            node.lazy = !node.lazy;
            node.totalSum = right - left + 1 - node.totalSum;
            return;
        }
        pushDown(node);
        update(node.left, l, r);
        update(node.right, l, r);
        pushUp(node);
    }
}
