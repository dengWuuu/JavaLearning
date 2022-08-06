package JUC.线程入门.常见方法;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @author Wu
 * @date 2022年06月02日 21:24
 */
@Slf4j
public class Join {
    public static int r;

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    private static void test() throws InterruptedException {
        log.debug("开始");
        Thread t = new Thread(() -> {
            log.debug("t1 start");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("t1 end");
            r = 10;
        });
        t.setName("t1");
        t.start();
        t.join();
        log.debug("结果为：{}",r);
        log.debug("结束");
    }
}
