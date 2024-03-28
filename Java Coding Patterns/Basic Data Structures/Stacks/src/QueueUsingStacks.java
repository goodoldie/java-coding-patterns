import java.util.Stack;

public class QueueUsingStacks {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public QueueUsingStacks(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int data){

        while ( !stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        stack1.push(data);

        while ( !stack2.isEmpty())
            stack1.push(stack2.pop());
    }
    public int popQueue(){
        return stack1.pop();
    }
    public int peekQueue(){
        return stack1.peek();
    }
    public boolean isQueueEmpty(){
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println("Front of the queue : " + queue.peekQueue());
        System.out.println("Data removed from front of the queue : " + queue.popQueue());
        System.out.println("Front of the queue : " + queue.peekQueue());
    }
}
