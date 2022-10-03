package JUC.并发编程的艺术学习.第五章示范代码.Condition;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Wu
 * @date 2022年10月02日 17:15
 */
public class test {
    @Test
    public void main() throws InterruptedException {
        ConditionUseCase conditionUseCase = new ConditionUseCase();
        Thread thread = new Thread(() -> {
            try {
                conditionUseCase.conditionWait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "无敌的我");
        Thread thread2 = new Thread(() -> {
            try {
                conditionUseCase.conditionSignal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "无敌的我1");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.start();

    }
}
