import java.util.*;

public class DequeIntro {
   
    public static void main(String[] args) {



        Deque<Integer>deque = new LinkedList<>();
        deque.add(10);
        deque.addFirst(20);
        deque.addLast(30);
        System.out.println(deque.getFirst());
        deque.removeFirst();
        System.out.println(deque.getLast());
        System.out.println(deque);
    }
}