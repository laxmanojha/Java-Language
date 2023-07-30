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
    public static int itrSearchKey(int key) {
        Node curr = head;
        int index = 0;
        while(curr != null) {
            if(curr.data == key)
                return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }
    public static int recSearchKey(Node curr, int index, int key) {
        if(curr == null)
           return -1;

        if(curr.data == key) return index;

        return recSearchKey(curr.next, index+1, key);

    }
    public static void reverseList() {
        Node prev = null;
        Node curr = tail = head;
        Node Next = null;
        while(curr != null) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        head = prev;
    }
    public static void checkPalindrome() {
        int length = lengthOfList();
        if(length == 1) {
            System.out.println("This is palindrome.");
            return;
        }
        int index = 0;
        Node head1,tail1,head2,tail2;
        head1 = tail1 = head;
        head2 = tail2 = null;
        while(index < (length/2)-1) {
            tail1 = tail1.next;
            index++;
        }
        if(length%2 == 0)
            head2 = tail1.next;
        else 
            head2 = tail1.next.next;
        tail1.next = null;
        head = head2;
        // print();
        // head = head1;
        // tail = tail1;
        // print();
        // head = head2;
        reverseList();
        head2 = head;
        tail2 = tail;
        head = head1;
        while(head2!=null) {
            if(head1.data != head2.data) {
                System.out.println("This is not palindrome!");
                return;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        System.out.println("This is palindrome.");
    }
    public static void main(String[] args) {

        // LinkedList ll = new LinkedList();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size:");
        int size = sc.nextInt();
        for(int i=0;i<size;i++) {
            int data = sc.nextInt();
            addLast(data);
        }
        print();
        checkPalindrome();
        // reverseList();
        // print();
        // System.out.println("Length is: "+lengthOfList());
        // int key = sc.nextInt();
        // // Node curr = head;
        // int index = 0;
        // System.out.println("Key found at: "+itrSearchKey(key));
        // System.out.println("Key found at: "+recSearchKey(head,index,key));
        // print();


        // int pos;
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
        
        // System.out.print("Enter position to remove: ");
        // pos = sc.nextInt();
        // removeAtPosition(pos);
        // print();
        // System.out.println("Length is: "+lengthOfList());


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