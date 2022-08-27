package LeetCode.热题100.LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年08月27日 15:56
 */
public class LRUCache {
    private int size;
    private final int capacity;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Node head;
    private final Node tail;

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node node) {
        //让移动到头部的节点前后的节点关联起来
        node.next.prev = node.prev;
        node.prev.next = node.next;
        //移动到头部
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node addNode = new Node(key, value);
            cache.put(key, addNode);
            addHead(addNode);
            size++;
            if (capacity < size) {
                Node prev = tail.prev;
                cache.remove(prev.key);
                removeLast();
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addHead(Node addNode) {
        addNode.prev = head;
        addNode.next = head.next;
        head.next.prev = addNode;
        head.next = addNode;
    }

    private void removeLast() {
        if (size > 0) {
            Node last = tail.prev;
            last.prev.next = tail;
            tail.prev = last.prev;
            last.prev = null;
            last.next = null;
        }
    }
}