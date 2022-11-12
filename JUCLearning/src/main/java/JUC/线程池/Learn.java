package JUC.线程池;

import JUC.线程入门.实现.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Wu
 * @date 2022年09月24日 19:58
 */
public class Learn {
    Semaphore s = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MyRunnable myRunnable = new MyRunnable();
        executorService.execute(myRunnable);
        executorService.shutdown();

    }
}
