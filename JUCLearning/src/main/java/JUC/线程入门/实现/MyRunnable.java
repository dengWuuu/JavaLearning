package JUC.线程入门.实现;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu
 * @date 2022年06月02日 10:48
 */
@Slf4j(topic = "MyRunnable")
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        log.debug("run");
    }
}
