package 剑指offer02.middle.复杂链表的复制;

/**
 * @author Wu
 * @date 2022年07月30日 11:07
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //1.构建新的链表
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        //2.构建random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //3.拆分链表
        cur = head.next;
        Node pre = head;
        Node ans = head.next;
        while (cur.next != null) {
//            pre.next = pre.next.next;
            cur.next = cur.next.next;
//            pre = pre.next;
            cur = cur.next;
        }
//        pre.next = null;
        return ans;
    }
}
