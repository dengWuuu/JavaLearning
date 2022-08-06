package JUC.设计模式.同步模式之保护性暂停;

import JUC.设计模式.Downloader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;

/**
 * @author Wu
 * @date 2022年06月04日 23:18
 */
@Slf4j
public class Test {
    //线程1等待线程2的下载结果
    public static void main(String[] args) {
        GuardObject gd = new GuardObject();
        new Thread(() -> {
            List<String> response = (List<String>) gd.getResponse();
            log.debug("线程1获取到的response:{}", response.size());
        }, "t1").start();
        new Thread(() -> {
            log.debug("下载");
            try {
                List<String> download = Downloader.download();
                gd.complete(download);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }

}


class FutureTask<V> {
    private static final Map<Integer,GuardObject> map = new Hashtable<>();
    private static int id = 1;
    private static synchronized int generateId() {
        return id++;
    }

    public static GuardObject createGuardObject() {
        GuardObject go = new GuardObject(generateId());
        map.put(go.getId(),go);
        return go;
    }
    public static Set<Integer> getIds() {
        return map.keySet();
    }

    public static GuardObject getGuardObject(int id) {
        return map.remove(id);
    }
}

class GuardObject {
    //结果
    private Object response;
    private int id;

    public GuardObject(int id) {
        this.id = id;
    }

    public GuardObject() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//获取结束

    public Object getResponse() {
        synchronized (this) {
            while (response == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public Object getResponse(long timeout) {
        synchronized (this) {
            long start = System.currentTimeMillis();
            long passTime = 0;
            while (response == null) {
                long waitTime = timeout - passTime;
                if (waitTime <= 0) {
                    break;
                }

                try {
                    wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passTime = System.currentTimeMillis() - start;
            }
            return response;
        }
    }

    //产生结果
    public void complete(Object response) {
        synchronized (this) {
            this.response = response;
            this.notifyAll();
        }
    }

}
