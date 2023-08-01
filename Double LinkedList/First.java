public class First {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null && tail == null) {
            head = tail = newNode;
        }
        else {
            while(head.prev != null) {
                head = head.prev;
            }
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null && tail == null) {
            head = tail = newNode;
        }
        else {
            while(tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void addAtPosition(int data, int pos) {
        if(pos == 1 || pos == 0) {
            addFirst(data);
        }
        else if(pos == lengthofDLL()+1 || pos == lengthofDLL()) {
            addLast(data);
        }
        else {
            int count = 1;
            Node curr = head;
            while(count != pos) {
                curr = curr.next;
                count++;
            }
            Node newNode = new Node(data);
            newNode.prev = curr.prev;
            newNode.next = curr;
            curr.prev.next = newNode;
            curr.prev = newNode;
        }
    }   
    public int lengthofDLL() {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    public void print() {
        Node temp = head;
        while(temp.next != null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println(temp.data);
        System.out.println("Head: "+head.data);
        System.out.println("Tail: "+tail.data);
    }
    public void printReverse() {
        Node temp = tail;
        while(temp.prev != null) {
            System.out.print(temp.data+"<->");
            temp = temp.prev;
        }
        System.out.println(temp.data);
    }
    public void removeFirst() {
        if(head == null) {
            System.out.println("This is empty!");
        }
        else if(head.next == null) {
            head = null;
            tail = null;
        }
        else {
            Node temp = head.next;
            temp.prev = null;
            head.next = null;
            head = temp;
        }
    }
    public void removeLast() {
        if(tail == null) {
            System.out.println("This is empty!");
        }
        else if(tail.prev == null) {
            head = null;
            tail = null;
        }
        else {
            Node temp = tail.prev;
            temp.next = null;
            tail.prev = null;
            tail = temp;
        }
    }
    public void removeAtPosition(int pos) {
        if(pos < 0 || pos > lengthofDLL()) {
            System.out.println("Invalid position!");
        }
        else if(pos == 1) {
            removeFirst();
        }
        else if(pos == lengthofDLL()) {
            removeLast();
        }
        else {
            Node pre = null;
            Node curr = head;
            Node nex = null;
            int count = 0;
            while(count != pos-1) {
                curr = curr.next;
                count++;
            }
            pre = curr.prev;
            nex = curr.next;
            pre.next = nex;
            nex.prev = pre;
            curr.next = null;
            curr.prev = null;
        }
    }
    public void reverse() {
        Node pre = null;
        Node nex = null;
        Node curr = head;
        tail = head;
        while(curr != null) {
            nex = curr.next;
            curr.next = pre;
            curr.prev = nex;
            pre = curr;
            curr = nex;
        }
        head = pre;
    }

    public static void main(String[] args) {
        First DLL = new First();
        DLL.addFirst(1);
        DLL.addLast(2);
        DLL.addLast(3);
        DLL.addLast(4);
        DLL.addLast(5);
        DLL.addLast(6);
        DLL.print();
        DLL.addAtPosition(-3, 3);
        DLL.print();
        // DLL.reverse();
        // DLL.print();
        // DLL.removeAtPosition(5);
        // DLL.print();
        // DLL.printReverse();
        // DLL.removeFirst();
        // DLL.print();
        // DLL.printReverse();
        // DLL.removeLast();
        // DLL.print();
        // DLL.printReverse();
    }
}