public class byLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(queue.isEmpty());
        queue.add(10);
        System.out.println(queue.remove());
        queue.add(20);
        System.out.println(queue.peek());
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