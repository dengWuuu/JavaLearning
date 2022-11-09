package JUC.哲学家进餐;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    Semaphore eatLimit = new Semaphore(4);
    Lock[] locks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < locks.length; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat, Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 4) % 5;

        eatLimit.acquire();
        locks[left].lock();
        locks[right].lock();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks[left].unlock();
        locks[right].unlock();

        eatLimit.release();

    }
}