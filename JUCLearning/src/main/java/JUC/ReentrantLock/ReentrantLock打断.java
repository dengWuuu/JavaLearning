package JUC.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @author Wu
 * @date 2022年06月06日 19:05
 */
@Slf4j
public class ReentrantLock打断 { ;
    private static final java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            try {
                log.debug("获取锁...");
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                log.debug("被打断");
                e.printStackTrace();
            }
        }, "t1");

        lock.lock();
        t1.start();
        sleep(1);
        t1.interrupt();

    }
}
