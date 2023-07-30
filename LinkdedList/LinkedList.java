import java.util.Scanner;
public class LinkedList {
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
    // public static int lengthoflist;

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
    public static int lengthOfList() {
        Node temp = head;
        int count = 0;
        if(temp == null) {
            return count;
        }
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
        // return lengthoflist;
    }
    public static void addAtPosition(int data, int pos) {
        int length = lengthOfList();
        Node newNode = new Node(data);
        if(length == 0 || pos > length + 1 || pos < 0) {
            System.out.println("Enter valid position to add!");
            return;
        }
        else if(pos == 1) {
            addFirst(data);
        }
        else if(pos == length+1) {
            addLast(data);
        }
        else {
            int count = 1;
            Node prev = null;
            Node curr = head;
            while(count != pos) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            newNode.next = curr;
            prev.next = newNode;
        }
    }
    public static void removeAtPosition(int pos) {
        int length = lengthOfList();
        Node prev = null;
        if(length == 0 || pos > length || pos < 0) {
            System.out.println("Enter valid position to remove!");
            return;
        }
        else if(length == 1 && pos == 1) {
            head = null;
            tail = null;
        }
        else if(pos == 1) {
            prev = head;
            head = prev.next;
            prev.next = null;
        }
        else {
            int count = 1;
            prev = null;
            Node curr = head;
            while(count != pos) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            if(count == length) {
                prev.next = null;
                tail = prev;
                return;
            }
            prev.next = curr.next;
            curr.next = null;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size:");
        int size = sc.nextInt();
        int pos;
        for(int i=0;i<size;i++) {
            int data = sc.nextInt();
            addLast(data);
        }
        print();
        System.out.println("Length is: "+lengthOfList());


        // System.out.print("Enter position to add: ");
        // pos = sc.nextInt();
        // if(pos > lengthOfList()+1)
        // {
        //     addAtPosition(0, pos);
        // }
        // else{
        //     System.out.print("Enter Data: ");
        //     int data = sc.nextInt();
        //     addAtPosition(data, pos);
        //     print();
        //     System.out.println("Length is: "+lengthOfList());
        // }
        
        System.out.print("Enter position to remove: ");
        pos = sc.nextInt();
        removeAtPosition(pos);
        print();
        System.out.println("Length is: "+lengthOfList());


        // for(int i=1;i<=size;i++) {
        //     System.out.print("Enter data for position "+i+" :");
        //     int data = sc.nextInt();
        //     if(head == null) {
        //         addFirst(data);
        //         continue;
        //     }
        //     System.out.print("Add: First 'f' Last 'l':");
        //     String pos = sc.next();
        //     if(pos.equals("f"))
        //         addFirst(data);
        //     else 
        //         addLast(data);
        // }
        // print();
    }
}