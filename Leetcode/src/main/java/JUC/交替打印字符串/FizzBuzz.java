package JUC.交替打印字符串;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    Semaphore s = new Semaphore(1);
    int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            s.acquire();
            if (i <= n && i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
                i++;
            }
            s.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {

            s.acquire();
            if (i <= n && i % 5 == 0 && i % 3 != 0) {
                printBuzz.run();
                i++;
            }
            s.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            s.acquire();
            if (i <= n && i % 5 == 0 && i % 3 == 0) {
                printFizzBuzz.run();
                i++;
            }
            s.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            s.acquire();
            if (i <= n && i % 5 != 0 && i % 3 != 0) {
                printNumber.accept(i);
                i++;
            }
            s.release();
        }

    }
}