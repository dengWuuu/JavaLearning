package JUC.设计有限阻塞队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
    Queue<Integer> queue = new LinkedList<>();
    Semaphore full;
    Semaphore empty;
    ReentrantLock lock = new ReentrantLock(true);

    public BoundedBlockingQueue(int capacity) {
        full = new Semaphore(capacity);
        empty = new Semaphore(0);
    }

    public void enqueue(int element) throws InterruptedException {
        try {
            lock.lock();
            full.acquire();
            queue.add(element);
            empty.release();
        } finally {
            lock.unlock();
        }

    }

    public int dequeue() throws InterruptedException {
        empty.acquire();
        int x;
        x = queue.poll();
        full.release();
        return x;
    }

    public int size() {
        return queue.size();
    }
}
