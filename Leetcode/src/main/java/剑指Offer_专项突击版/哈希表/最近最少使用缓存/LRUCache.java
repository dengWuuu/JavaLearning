package 剑指Offer_专项突击版.哈希表.最近最少使用缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wu
 * @date 2022年09月30日 19:01
 */
public class LRUCache {
    int size;
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            moveToHead(map.get(key));
            return map.get(key).value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            addHead(key, value);
            if (size >= capacity) {
                //删除尾巴
                removeLast();
            } else {
                size++;
            }
        } else {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeLast() {
        Node last = tail.prev.prev;
        map.remove(last.next.key);
        last.next = tail;
        tail.prev = last;
    }

    private void addHead(int key, int value) {
        Node node = new Node(key, value);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        map.put(key, node);
    }

    public void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}


class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node() {

    }

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
