package leedcode;

import java.util.List;
import java.util.Stack;

/**
 * 查看Stack类源码可知，该类本身就有push()、empty()、peek()、pop()方法
 */
public class MyQueue {


    private Stack<Integer> date_stack = new Stack();
    private Stack<Integer> temp_stack = new Stack();

    /** Initialize your data structure here. */
    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        while(!date_stack.empty()) {
            temp_stack.push(date_stack.peek());
            date_stack.pop();
        }

        temp_stack.push(x);

        while(!temp_stack.empty()) {
            date_stack.push(temp_stack.peek());
            temp_stack.pop();
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(date_stack.empty())
            return 0;
        return date_stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(date_stack.empty())
            return 0;
        return date_stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return date_stack.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        while (!myQueue.empty()) {
            System.out.println(myQueue.peek());
            myQueue.pop();
        }
    }
}
