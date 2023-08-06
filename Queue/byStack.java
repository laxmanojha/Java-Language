import java.util.Stack;

public class byStack {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(10);
        System.out.println(queue.remove());
        queue.add(20);
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
    }
}

class Queue {
    Stack<Integer>s = new Stack<>();

    public void pushAtBottom(Stack<Integer>s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public boolean isEmpty() {
        return s.isEmpty();
    }
    public void add(int data) {
        pushAtBottom(s, data);
    }
    public int remove() {
        if(s.isEmpty()) return -1;
        return s.pop();
    }
    public int peek() {
        if(s.isEmpty()) return -1;
        return s.peek();
    }
}