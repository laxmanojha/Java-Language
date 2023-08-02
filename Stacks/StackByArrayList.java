import java.util.ArrayList;

public class StackByArrayList {
    static class Stack {
        static ArrayList<Integer>list = new ArrayList<>();
        public boolean isEmpty() {
            return list.size() == 0;
        }
        public void push(int data) {
            list.add(data);
        }
        public int pop() {
            if(list.isEmpty()) return -1;
            return list.remove(list.size()-1);
        }
        public int peek() {
            if(list.isEmpty()) return -1;
            return list.get(list.size()-1);
        }
    }
    public static void main(String[]args) {
        Stack s = new Stack();
        System.out.println(Stack.list);
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        System.out.println(s.isEmpty());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.list);
    }
}