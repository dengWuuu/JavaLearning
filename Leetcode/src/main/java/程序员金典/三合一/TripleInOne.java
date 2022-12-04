package 程序员金典.三合一;

public class TripleInOne {
    private final int STACK_SIZE;   //栈大小
    private int[] index;    //当前栈的栈顶指针
    private int[][] stack;  //栈

    public TripleInOne(int stackSize) {     //初始化操作
        this.STACK_SIZE = stackSize;
        this.index = new int[]{-1, -1, -1};
        this.stack = new int[3][STACK_SIZE];
    }

    public void push(int stackNum, int value) {
        if (index[stackNum] + 1 < STACK_SIZE) {     //判断当前栈是否已满
            stack[stackNum][++index[stackNum]] = value;     //向栈内添加元素
            //index[stackNum]++;      //栈顶指针上移一位
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {    //判断当前栈是否已空
            return -1;
        }
        //index[stackNum]--;      //将栈顶指针向下移一位
        return stack[stackNum][index[stackNum]--];    //返回抛出的元素
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {    //判断当前栈是否已空
            return -1;
        }
        return stack[stackNum][index[stackNum]];      //返回栈顶元素
    }

    public boolean isEmpty(int stackNum) {
        return index[stackNum] == -1;     //判断当前栈是否已空
    }
}