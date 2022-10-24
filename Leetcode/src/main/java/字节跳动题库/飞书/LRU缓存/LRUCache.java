package 字节跳动题库.飞书.LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年10月24日 19:20
 */
public class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;

        map = new HashMap<>();

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            //移动到队列头
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }

        Node node = new Node(key, value);
        if (size < capacity) {
            insertHead(node);
        } else {
            //删除尾巴
            tail.pre.pre.next = tail;
            Node deleteNode = tail.pre;
            tail.pre = tail.pre.pre;
            deleteNode.next = null;
            deleteNode.pre = null;
            map.remove(deleteNode.key);

            //插入头部
            insertHead(node);
        }
    }

    public void insertHead(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
        size++;
    }

    public void moveToHead(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;

        head.next.pre = node;
        node.next = head.next;

        node.pre = head;
        head.next = node;

    }
}


class Node {
    Node next;
    Node pre;
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key) {
        this.key = key;
    }
}
