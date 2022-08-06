package JUC.设计模式.两阶段中止模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wu
 * @date 2022年06月02日 22:33
 */
@Slf4j
public class Test {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();
        Thread.sleep(3000);
        tpt.stop();
    }
}

/**
 *
 */
@Slf4j(topic = "TwoPhaseTermination")
class TwoPhaseTermination {
    private Thread monitor; //监控线程

    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()) {
                    log.debug("处理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    currentThread.interrupt();
                }
            }
        });
        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }

}
