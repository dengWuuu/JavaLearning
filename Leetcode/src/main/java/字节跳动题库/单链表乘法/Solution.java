package 字节跳动题库.单链表乘法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2022年12月15日 13:48
 */
public class Solution {
    //31 * 19
    //650 * 191
    public static void main(String[] args) {

        Node head1 = new Node(6, new Node(5, new Node(0, null)));
        Node head2 = new Node(1, new Node(9, new Node(1, null)));

        multiply(head1, head2);
    }

    public static void multiply(Node head1, Node head2) {
        Node l = reverse(head1), r = reverse(head2);

        List<Node> list = new ArrayList<>();
        int base = 0;
        while (l != null) {
            //构造零
            Node dummy = new Node(-1, null);
            Node cur = dummy;
            int num = base;
            while (num-- > 0) {
                cur.next = new Node(0, null);
                cur = cur.next;
            }
            //构造乘法
            Node curR = r;
            int j = 0;
            while (curR != null) {
                int sum = l.val * curR.val + j;
                j = sum / 10;
                cur.next = new Node(sum % 10, null);
                cur = cur.next;
                curR = curR.next;
            }
            if (j > 0) cur.next = new Node(j, null);
            list.add(dummy.next);
            l = l.next;
            base++;
        }
        Node head = new Node(0, null);
        head = sumList(head, list);
        print(reverse(head));
    }

    public static Node sumList(Node head, List<Node> list) {
        for (Node node : list) {
            head = sumTwo(head, node);
        }
        return head;
    }

    public static Node sumTwo(Node head1, Node head2) {
        Node l = head1, r = head2, dummy = new Node(-1, null), cur = dummy;
        int j = 0;
        while (l != null || r != null) {
            int left = l == null ? 0 : l.val;
            int right = r == null ? 0 : r.val;
            int sum = left + right + j;
            if (sum >= 10) {
                j = 1;
                sum -= 10;
            } else j = 0;

            cur.next = new Node(sum, null);
            cur = cur.next;
            if (l != null) l = l.next;
            if (r != null) r = r.next;
        }
        if (j > 0) cur.next = new Node(1, null);
        return dummy.next;
    }

    public static Node reverse(Node head) {
        Node cur = head, pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
    }
}

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

