package JUC.线程入门.常见方法;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

@Slf4j
public class ParkUnpark {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("start...");

            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("park...");
            LockSupport.park();
            log.debug("resume...");
        }, "t1");
        t1.start();

        sleep(1);
        log.debug("unpark...");
        LockSupport.unpark(t1);
    }
}
