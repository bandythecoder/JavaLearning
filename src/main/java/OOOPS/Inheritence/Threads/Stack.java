package OOOPS.Inheritence.Threads;

public class Stack {
    private int[] array;
    private int top;
    private final int CAPACITY;

    Stack(int capacity)
    {
        array = new int[capacity];
        CAPACITY = capacity;
        top = 0;
    }

    public boolean push(int item) throws InterruptedException {
        if(top == CAPACITY) return false;
        Thread.sleep(1000);
        array[top++] = item;
        return true;
    }

    public int pop() {
        if (top == 0) return Integer.MIN_VALUE;
        var item = array[top--];
        return item;
    }

    public int size()
    {
        return top+1;
    }
}
