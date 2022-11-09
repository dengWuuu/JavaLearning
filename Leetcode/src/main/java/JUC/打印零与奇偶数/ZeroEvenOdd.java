package JUC.打印零与奇偶数;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSema = new Semaphore(1);
    private Semaphore oddSema = new Semaphore(0);//奇数
    private Semaphore evenSema = new Semaphore(0);//偶数

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSema.acquire();
            printNumber.accept(0);
            if ((i & 1) == 1) {//奇数
                oddSema.release();
            } else {
                evenSema.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {//偶数 打印偶数 并释放zero的线程
                evenSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {//奇数，打印奇数，并释放zero的线程
                oddSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }
}