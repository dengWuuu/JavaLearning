package org.ThreadLocal;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalTest {
    private final List<String> messages = new ArrayList<>();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.add("一枝花算不算浪漫");
        System.out.println(holder.get().messages);
        Thread thread = new Thread(() -> {
            ThreadLocalTest.add("二枝花算不算浪漫");
            System.out.println(holder.get().messages);
        });
        thread.start();
        Thread.sleep(100);
        System.out.println(holder.get().messages);
    }
}
