package JUC.线程入门.实现;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.FutureTask;

/**
 * @author Wu
 * @date 2022年06月02日 10:43
 */
@Slf4j(topic = "TestClass")
public class TestClass {

    @Test
    public void testThread() {
        Thread thread = new Thread(() -> log.debug("thread run"));
        thread.start();
        log.debug("thread start");
    }

    @Test
    public void testRunnable() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "MyRunnable");
        thread.setName("MyRunnableThread");
        thread.start();
    }

    @Test
    public void testCallable() {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask, "MyCallable");
        thread.setName("MyCallableThread");
        thread.start();
        try {
            log.debug("futureTask.get() = {}", futureTask.get());
        }
        catch (Exception e) {
            log.error("", e);
        }
    }

}
