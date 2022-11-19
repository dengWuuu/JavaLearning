package 腾讯题库.设计循环队列;

/**
 * @author Wu
 * @date 2022年11月17日 9:24
 */
public class MyCircularQueue {
    int capacity;
    int head;
    int tail;
    int[] arr;

    public MyCircularQueue(int k) {
        this.capacity = k;
        head = 0;
        tail = 0;
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        arr[tail % capacity] = value;
        tail++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head++;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[head % capacity];
    }

    public int Rear() {
        return isEmpty() ? -1 : arr[(tail - 1) % capacity];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail - head == capacity;
    }
}