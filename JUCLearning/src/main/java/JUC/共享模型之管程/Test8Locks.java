package JUC.共享模型之管程;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;


@Slf4j(topic = "c.Test8Locks")
public class Test8Locks {
    public static void main(String[] args) {
        Number n1 = new Number();
        Number n2 = new Number();
        new Thread(() -> {
            log.debug("begin");
            try {
                n1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            log.debug("begin");
            n2.b();
        }).start();
    }
}

@Slf4j(topic = "c.Number")
class Number{
    public synchronized void a() throws InterruptedException {
        sleep(1000);
        log.debug("1");
    }
    public synchronized void b() {
        log.debug("2");
    }
}
