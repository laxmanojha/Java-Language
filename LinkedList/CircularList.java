import java.util.Scanner;

public class CircularList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static void print() {
        if(head == null) {
            System.out.println("LinkedList is empty!");
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println(temp.data);
        System.out.println("Head is at: "+head.data);
        System.out.println("Tail is at: "+tail.data);
    }

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public static void addLast(int data) {
        Node newNode = new Node(data);
        if(tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public static boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
    public static void removeLoop() {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        boolean flag = false;
        while(fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                flag = true;
                break;
            }
        }
        if(flag) {
            System.out.println("Loop Detected!");
            while(slow != fast) {
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;
            System.out.println("Loop removed, successfully!");
        }
        else {
            System.out.println("Loop not Detected!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size:");
        int size = sc.nextInt();
        for(int i=0;i<size;i++) {
            int data = sc.nextInt();
            addLast(data);
        }
        tail.next = head.next.next;
        System.out.println(detectLoop());
        // print();
        removeLoop();
        System.out.println(detectLoop());
        print();
    }
}