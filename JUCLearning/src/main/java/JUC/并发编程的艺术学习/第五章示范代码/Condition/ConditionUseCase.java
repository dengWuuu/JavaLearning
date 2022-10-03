package JUC.并发编程的艺术学习.第五章示范代码.Condition;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wu
 * @date 2022年10月02日 17:10
 */
@Slf4j
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        log.info("wait 抢到了锁");
        try {
            log.info("wait释放了锁？");
            condition.await();
            log.info("被叫醒");
        } finally {
            lock.unlock();
            log.info("wait解锁");
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        log.info("signal抢到了锁");
        try {
            condition.signal();
            log.info("通知");
        } finally {
            lock.unlock();
            log.info("signal解锁");
        }
    }
}
