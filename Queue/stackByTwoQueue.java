// import java.util.LinkedList;

public class stackByTwoQueue {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("is empty: "+stack.isEmpty());
        stack.add(10);
        stack.add(20);
        stack.add(30);
        stack.add(40);
        stack.add(50);
        stack.add(60);
        while(!stack.isEmpty()) {
            System.out.println("top: "+stack.peek()+"\nremoved: "+stack.remove()+"\nis empty: "+stack.isEmpty());
        }
        System.out.println("is empty: "+stack.isEmpty());
    }
}

class Queue {
    class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public Node head;
    public Node tail;

    public boolean isEmpty() {
        return (head == null);
    }
    public void add(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public int remove() {
        if(head == null) {
            return -1;
        }
        int data = head.data;
        if(head == tail) {
            head = tail = null;
            return data;
        }
        head = head.next;
        return data;
    }
    public int peek() {
        if(head == null) 
            return -1;
        return head.data;
    }
}
class Stack {
    Queue q1 = new Queue();
    Queue q2 = new Queue();
    public boolean isEmpty() {
        return q1.isEmpty()&&q2.isEmpty();
    }
    public void add(int data) {
        if(!q1.isEmpty()) {
            q1.add(data);
        }
        else if(!q2.isEmpty()) {
            q2.add(data);
        }
        else {
            q1.add(data);
        }
    }
    public int remove() {
        if(isEmpty()) return -1;
        int data=0;
        if(!q1.isEmpty()) {
            while(!q1.isEmpty()) {
                data = q1.remove();
                if(!q1.isEmpty())
                    q2.add(data);
            }
           
        }
        else {
            while(!q2.isEmpty()) {
                data = q2.remove();
                if(!q2.isEmpty())
                    q1.add(data);
            }
        }
        return data;
    }
    public int peek() {
        if(isEmpty()) return -1;
        int data=0;
        if(!q1.isEmpty()) {
            while(!q1.isEmpty()) {
                data = q1.remove();
                q2.add(data);
            }
        }
        else {
            while(!q2.isEmpty()) {
                data = q2.remove();
                q1.add(data);
            }
        }
        return data;
    }
}