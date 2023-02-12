package JUC.CompletableFuture异步编排;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Wu
 * @date 2022年09月24日 20:59
 */
public class Learn {
    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 创建异步任务
         */
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("异步编排1");
        }, executorService);
        //supply有返回值
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排2");
            return 10;
        }, executorService);
        //通过get获取结果
        System.out.println(future2.get());

        //whenComplete  ----->   完成后回调函数
        //exceptionally ----> 异常出现后的处理
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排3");
            int i = 10 / 0;
            return 10;
        }, executorService).whenComplete((t, u) -> {
            System.out.println("异步任务完成了,结果是:" + t + "异常是:" + u);
        }).exceptionally(throwable -> {
            //感知异常 返回默认值
            return 10;
        });
        System.out.println(future3.get() + "---------3----------------------");

        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排4");
            int i = 10 / 0;
            return 10;
        }, executorService).handle((res, thr) -> {
            if (res != null) {
                return res;
            }
            return 0;
        });
        System.out.println("4" + future4.get()); //异常打印不出10

        //4线程串行化
        CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排5");
            int i = 10 / 2;
            return i;
        }, executorService).thenRunAsync(() -> {
            System.out.println("异步编排5的任务二开始执行了");
        });

        CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排6");
            int i = 10 / 2;
            return i;
        }, executorService).thenAccept(System.out::println);

        CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排7");
            int i = 10 / 2;
            return i;
        }, executorService).thenApply((r) -> {
            System.out.println("返回值：" + r);
            return 0;
        });
        CompletableFuture<Integer> future8 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排8-任务二线程");
            int i = 10 / 2;
            return i;
        }, executorService);

        CompletableFuture<Integer> future9 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排8-任务1线程");
            int i = 10 / 2;
            return i;
        }, executorService);

        future9.runAfterBothAsync(future8, () -> {
            System.out.println("任务3线程");
        }, executorService);

        future9.thenAcceptBothAsync(future8, (x, y) -> {
            System.out.println("x:" + x + "y:" + y);
        }, executorService);

        CompletableFuture<String> stringCompletableFuture = future9.thenCombineAsync(future8, (x, y) -> x + "------" + y + "-> hello", executorService);
        System.out.println(stringCompletableFuture.get());


        CompletableFuture<Integer> future11 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排9-任务2线程");
            int i = 10 / 2;
            return i;
        }, executorService);

        CompletableFuture<Integer> future10 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步编排9-任务1线程");
            int i = 10 / 2;
            return i;
        }, executorService);

        future10.runAfterEitherAsync(future11, () -> {
            System.out.println("两个完成了一个");
        }, executorService);

        future10.acceptEitherAsync(future11, (res) -> {
            System.out.println("两个完成了一个");
            System.out.println(res);
        }, executorService);

        CompletableFuture<Integer> 两个完成了一个 = future10.applyToEitherAsync(future11, (res) -> {
            System.out.println("两个完成了一个");
            System.out.println(res);
            return 1;
        }, executorService);
        System.out.println(两个完成了一个.get());
    }
}
