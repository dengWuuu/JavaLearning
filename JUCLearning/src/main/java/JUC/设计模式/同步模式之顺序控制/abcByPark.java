package JUC.设计模式.同步模式之顺序控制;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j(topic = "c.Test31")
public class abcByPark {

    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) {
        Park_Unpark pu = new Park_Unpark(5);
        t1 = new Thread(() -> {
            pu.print("a", t2);
        });
        t2 = new Thread(() -> {
            pu.print("b", t3);
        });
        t3 = new Thread(() -> {
            pu.print("c", t1);
        });
        t1.start();
        t2.start();
        t3.start();

        LockSupport.unpark(t1);
    }
}

class Park_Unpark {
    public void print(String str, Thread next) {
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(next);
        }
    }

    private final int loopNumber;

    public Park_Unpark(int loopNumber) {
        this.loopNumber = loopNumber;
    }
}