package JUC.共享模型之管程.Synchronized;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu
 * @date 2022年06月03日 10:03
 */
@Slf4j
public class SynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increment();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.decrement();
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}", room.getCounter());
    }

}
