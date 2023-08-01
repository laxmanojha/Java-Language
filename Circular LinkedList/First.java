public class First{
    public class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public void addToEmpty(int data) {
        Node newNode = new Node(data);
        last = newNode;
        last.next = newNode;
    }
    public void addFirst(int data) {
        if(last == null) {
            addToEmpty(data);
        }
        else {
            Node newNode = new Node(data);
            newNode.next = last.next;
            last.next = newNode;
        }
    }
    public void addLast(int data) {
        if(last == null) {
            addToEmpty(data);
        }
        else {
            Node newNode = new Node(data);
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }
    public void addToPosition(int pos, int data) {
        if(pos > lengthOfCL()+1) {
            System.out.println("Invalid input!");
        }
        else if(pos == 1) {
            addFirst(data);
        }
        else if(pos == lengthOfCL()) {
            Node temp = last.next;
            while(temp.next != last) {
                temp = temp.next;
            }
            Node newNode = new Node(data);
            newNode.next = last;
            temp.next = newNode;
        }
        else if(pos == lengthOfCL()+1) {
            addLast(data);
        }
        else {
            int count = 1;
            Node temp = last.next;
            while(count != pos -1) {
                temp = temp.next;
                count++;
            }
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    public int lengthOfCL() {
        if(last == null) {
            return 0;
        }
        Node temp = last;
        int count = 1;
        while(temp.next != last) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    public void print() {
        Node temp = last.next;
        while(temp != last) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    public void removeFirst() {
        if(last == null) {
            return;
        }
        else if(lengthOfCL() == 1) {
            last = null;
        }
        else {
            Node temp = last.next;
            last.next = temp.next;
            temp.next = null;
        }
    }
    public void removeLast() {
        if(last == null) {
            return;
        }
        else if(lengthOfCL() == 1) {
            last = null;
        }
        else {
            Node temp = last;
            while(temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last.next = null;
            last = temp;
        }
    }
    public void removeFromPosition(int pos) {
        if(last == null) {
            return;
        }
        else if(pos == 1) {
            removeFirst();
        }
        else if(pos == lengthOfCL()) {
            removeLast();
        }
        else {
            Node temp = last.next;
            int count = 1;
            while(count != pos-1) {
                temp = temp.next;
                count++;
            }
            Node delNode = temp.next;
            temp.next = delNode.next;
            delNode.next = null;
        }
    }
    public static Node last;
    public static void main(String[] args) {
        First CLL = new First();
        CLL.addFirst(10);
        CLL.addLast(20);
        CLL.addLast(30);
        CLL.addLast(40);
        CLL.addLast(50);
        CLL.print();
        CLL.addToPosition(6, 100);
        CLL.print();
        CLL.removeFromPosition(4);
        CLL.print();
    }
}