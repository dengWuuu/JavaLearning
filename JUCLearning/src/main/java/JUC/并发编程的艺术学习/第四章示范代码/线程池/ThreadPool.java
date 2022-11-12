package JUC.并发编程的艺术学习.第四章示范代码.线程池;

public interface ThreadPool<Job extends Runnable> {
    // 执行一个Job，这个Job需要实现Runnable
    void execute(Job job);
}