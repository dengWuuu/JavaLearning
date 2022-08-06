package JUC.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wu
 * @date 2022年06月06日 19:11
 */
@Slf4j
public class TryLock {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            //trylock 可打断
            if (!lock.tryLock()) {
                log.debug("获取锁失败");
                return;
            }
            try {
                log.debug("获取锁...");
            } finally {
                lock.unlock();
            }
        }, "t1");
        lock.lock();
        log.debug("获取锁...");
        t1.start();
    }

}
