package LeetCode.热题100.最小栈;

/**
 * @author Wu
 * @date 2022年08月27日 20:07
 */
public class test {
    public static void main(String[] args) {
        MinStack min = new MinStack();
        min.push(512);
        min.push(-1024);
        min.push(-1024);
        min.push(512);
        min.pop();
        System.out.println(min.getMin());
        min.pop();
        System.out.println(min.getMin());
        min.pop();
        System.out.println(min.getMin());

    }
}
