package JUC.设计模式.生产者消费者模式;

import java.util.LinkedList;

/**
 * 消息队列类,java线程之间通信的类
 *
 * @author Wu
 * @date 2022年06月05日 20:11
 */
public class MessageQueue {
    //消息队列集合
    private final LinkedList<Message> list = new LinkedList<>();
    //容量
    private int capacity;


    /**
     * 存入消息
     */
    public void put(Message message) {
        synchronized (list) {
            while (list.size() == capacity) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            list.notifyAll();
        }
    }


    public Message take() {
        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //从队列头获取消息返回
            Message message = list.removeFirst();
            list.notifyAll();
            return message;
        }
    }
}


final class Message {
    private int id;
    private Object value;

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
