package JUC.线程池;

import JUC.线程入门.实现.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Wu
 * @date 2022年09月24日 19:58
 */
public class Learn {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MyRunnable myRunnable = new MyRunnable();
        executorService.execute(myRunnable);
        executorService.shutdown();

    }
}
