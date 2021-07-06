package leedcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> data_queue = new LinkedList();
    private Queue<Integer> temp_queue = new LinkedList();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        temp_queue.offer(x);

        while (!data_queue.isEmpty())
            temp_queue.offer(data_queue.poll());

        while (!temp_queue.isEmpty())
            data_queue.offer(temp_queue.poll());
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(data_queue.isEmpty())
            return 0;
        return data_queue.poll();
    }

    /** Get the top element. */
    public int top() {
        if(data_queue.isEmpty())
            return 0;
        return data_queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data_queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
