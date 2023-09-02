import java.util.*;


public class StackUsingTwoQueues {
    // static class queue {
    //     int[] arr = new int[10000];
    //     int first = 0;
    //     int last = 0;
    //     public boolean isEmpty() {
    //         return first == last;
    //     }
    //     public void add(int data) {
    //         arr[last] = data;
    //         last++;
    //     }
    //     public int remove() {
    //         if(isEmpty()) {
    //             return -1;
    //         }
    //         else {
    //             return arr[first++];
    //         }
    //     }
    //     public int peek() {
    //         if(isEmpty()) {
    //             return -1;
    //         }
    //         else {
    //             return arr[first];
    //         }
    //     }
    // }
    static class Stack {
        Queue<Integer>q1 = new LinkedList<>();
        Queue<Integer>q2 = new LinkedList<>();
        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }
        public void push(int data) {
            if(q1.isEmpty()) {
                q1.add(data);
                while(!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            }
            else {
                q2.add(data);
                while(!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
            }
        }
        public int pop() {
            if(q1.isEmpty() && q2.isEmpty()) {
                return -1;
            }
            else if(q1.isEmpty()) {
                return q2.remove();
            }
            else {
                return q1.remove();
            }
        }
        public int peek() {
            if(q1.isEmpty() && q2.isEmpty()) {
                return -1;
            }
            else if(q1.isEmpty()) {
                return q2.peek();
            }
            else {
                return q1.peek();
            }
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        System.out.println(st.isEmpty());
        System.out.println(st.peek());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.peek());
        while(!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}