package leedcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidateStack {

    private Queue<Integer> pushedLikedList = new LinkedList<>();
    private Queue<Integer> poppedLinkedList = new LinkedList<>();
    private Stack<Integer> stack = new Stack<>();

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        //即将入栈的队列
        for(int i=0;i<=pushed.length-1;i++){
            pushedLikedList.offer(pushed[i]);
        }

        //待检查的队列
        for (int i=0;i<=popped.length-1;i++){
            poppedLinkedList.offer(popped[i]);
        }

        while (!pushedLikedList.isEmpty()){
            stack.push(pushedLikedList.poll());
            while(!stack.empty() && stack.peek()==poppedLinkedList.peek()){
                stack.pop();
                poppedLinkedList.poll();
            }
        }

        if (poppedLinkedList.isEmpty())
            return true;
        else
            return false;

    }
}

class test{
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        int [] b = {3,2,5,4,1};
        boolean b1 = new ValidateStack().validateStackSequences(a, b);
        System.out.println(b1);
    }
}
