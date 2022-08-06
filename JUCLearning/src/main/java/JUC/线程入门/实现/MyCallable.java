package JUC.线程入门.实现;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author Wu
 * @date 2022年06月02日 13:30
 */
@Slf4j(topic = "MyCallable")
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        log.debug("callable");
        return "CallableRunning";
    }
}
