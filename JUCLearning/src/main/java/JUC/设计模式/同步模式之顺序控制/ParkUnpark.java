package JUC.设计模式.同步模式之顺序控制;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Wu
 * @date 2022年06月06日 19:57
 */
@Slf4j
public class ParkUnpark {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.debug("1");
        }, "t1");

        t1.start();

        new Thread(() -> {
            log.debug("2");
            LockSupport.unpark(t1);
        }, "t2").start();

    }
}
