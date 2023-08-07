import java.util.*;

public class DequeIntro {
    static class StackByDeque {
        Deque<Integer>deque = new LinkedList<>();
        public boolean isEmpty() {
            return deque.isEmpty();
        }
        public void push(int data) {
            deque.addLast(data);
        }
        public int pop() {
            if(!deque.isEmpty())
                return deque.removeLast();
            else 
                return -1;
        }
        public int peek() {
            if(!deque.isEmpty())
                return deque.getLast();
            else 
                return -1;
        }
    }
    static class QueueByDeque {
        Deque<Integer>deque = new LinkedList<>();
        public boolean isEmpty() {
            return deque.isEmpty();
        }
        public void add(int data) {
            deque.addLast(data);
        }
        public int remove() {
            if(!deque.isEmpty())
                return deque.removeFirst();
            else 
                return -1;
        }
        public int peek() {
            if(!deque.isEmpty())
                return deque.getFirst();
            else 
                return -1;
        }
        public int size() {
            return deque.size();
        }
    }
    public static void main(String[] args) {

        // Queue implemendted using Deque
        QueueByDeque queue = new QueueByDeque();
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        queue.add(10);
        queue.add(20);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());

        // Stack implemendted using Deque
        /*StackByDeque stack = new StackByDeque();
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());*/


        /*Deque<Integer>deque = new LinkedList<>();
        deque.add(10);
        deque.addFirst(20);
        deque.addLast(30);
        System.out.println(deque.getFirst());
        deque.removeFirst();
        System.out.println(deque.getLast());
        System.out.println(deque);*/
    }
}