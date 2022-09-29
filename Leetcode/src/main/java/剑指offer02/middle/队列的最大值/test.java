package 剑指offer02.middle.队列的最大值;

/**
 * @author Wu
 * @date 2022年08月05日 11:54
 */
public class test {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(46);
        maxQueue.push_back(848);
        maxQueue.push_back(525);

        maxQueue.pop_front();
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value());
    }
}
