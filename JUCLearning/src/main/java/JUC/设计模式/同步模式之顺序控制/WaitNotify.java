package JUC.设计模式.同步模式之顺序控制;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu
 * @date 2022年06月06日 19:52
 */
@Slf4j
public class WaitNotify {
    static final Object lock = new Object();
    static boolean flag = false;  //表示t2是否执行完毕

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                while (!flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                log.debug("2");
                flag = true;
                lock.notify();
            }
        }, "t2").start();


    }
}
