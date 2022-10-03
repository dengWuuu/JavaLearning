package JUC.并发编程的艺术学习.第五章示范代码.同步器;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Wu
 * @date 2022年10月01日 23:22
 */
@Slf4j
public class TwinsTest {
    @Test
    public void test() throws InterruptedException {
        TwinsLock twinsLock = new TwinsLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    twinsLock.lock();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        twinsLock.unlock();
                    }
                }
            }

        }
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println();
        }
    }
}


