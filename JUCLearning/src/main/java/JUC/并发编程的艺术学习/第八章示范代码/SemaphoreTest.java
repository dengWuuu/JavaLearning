package JUC.并发编程的艺术学习.第八章示范代码;

import java.util.LinkedList;
import java.util.concurrent.*;

public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(() -> {
                try {
                    s.acquire();
                    System.out.println("save data");
                    s.release();
                } catch (InterruptedException e) {
                }
            });
        }
        threadPool.shutdown();
    }
}