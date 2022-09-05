package 代码随想录.链表.设计链表;

import 代码随想录.链表.ListNode;

/**
 * @author Wu
 * @date 2022年09月05日 19:59
 */
public class MyLinkedList {
    ListNode head;
    int size = 0;

    public MyLinkedList() {

        head = new ListNode(-1, null);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = new ListNode(val, pred.next);
    }

    public void deleteAtIndex(int index) {
        if (size == 0) return;
        if (index >= size || index < 0) {
            return;
        }
        size--;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
