package advanced;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue = new LinkedList<Integer>();

    public MyStack(){

    }

    public void push(int x){
        int size = queue.size();
        queue.offer(x); //先把 x 放入 queue
        for(int i = 0; i < size; ++i){
            queue.offer(queue.poll());
        }
    }

    public int pop(){
        int val = queue.poll();
        return val;
    }

    public int top(){
        int val = queue.peek();
        return val;
    }

    public boolean empty(){
        return queue.isEmpty();
    }

    public static void test(){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("top -> " + myStack.top());
        System.out.println("pop -> " + myStack.pop());
        System.out.println("empty -> " + myStack.empty());
        //top -> 2
        //pop -> 2
        //empty -> false
    }

    public static void main(String[] args) {
        test();
    }
}
