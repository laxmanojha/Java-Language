public class StackByLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    static class Stack {
        public boolean isEmpty() {
            return head == null;
        }
        public void push(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
            }
            else {
                newNode.next = head;
                head = newNode;
            }
        }
        public int pop() {
            if(isEmpty()) return -1;
            Node temp = head;
            int data = temp.data;
            head = head.next;
            temp.next = null;
            return data;
        }
        public int peek() {
            if(isEmpty()) return -1;
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        System.out.println(head);
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        System.out.println(s.isEmpty());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(head);
    }
}