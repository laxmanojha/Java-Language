import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;

public class practice {
    public void firstNonRepeatingLetterInStreamOfChars(String input) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
        for(int i=0;i<input.length();i++) {
            freq[input.charAt(i)-97]++;
            q.add(input.charAt(i));
            while(!q.isEmpty() && freq[q.peek()-97] != 1) {
                q.remove();
            }
            if(q.isEmpty()) {
                System.out.print(-1+" ");
            }
            else {
                System.out.print(q.peek()+" ");
            }
        }
    }
    public void interleaveTwoHalvesQueue(Queue<Integer>queue) {
        Queue<Integer>q1 = new LinkedList<>();
        // Queue<Integer>q2 = new LinkedList<>();
        int size = queue.size();
        for(int i=1;i<=size/2;i++) {
            if(i<=size/2) q1.add(queue.remove());
            // else queue.add(queue.remove());
        }
        while(!q1.isEmpty()) {
            queue.add(q1.remove());
            queue.add(queue.remove());
        }
    }
    // public void addAtFirst(Queue<Integer> queue,int data) {
    //     if(queue.isEmpty()) {
    //         queue.add(data);
    //     }
    //     int peek = queue.remove();
    //     addAtFirst(queue, data);
    //     queue.add(peek);
    // }
    public void queueReversalRecursive(Queue<Integer> queue) {
        if(queue.isEmpty()) {
            return;
        }
        int peek = queue.remove();
        queueReversalRecursive(queue);
        queue.add(peek);
    }
    public void queueReversalByStack(Queue<Integer>queue) {
        Stack<Integer> stack = new Stack<Integer>();
        while(!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        practice p = new practice();
        int size = sc.nextInt();
        Queue<Integer>queue = new LinkedList<>();
        for(int i=1;i<=size;i++) {
            queue.add(i);
            System.out.print(i+" ");
        }
        System.out.println();
        // p.queueReversalRecursive(queue);
        p.queueReversalByStack(queue);
        while(!queue.isEmpty()) {
            System.out.print(queue.remove()+" ");
        }


        //Interleave Two Halves of a Queue
        // p.interleaveTwoHalvesQueue(queue);
        // while(!queue.isEmpty()) {
        //     System.out.print(queue.remove()+" ");
        // }

        //Non Repeating letter in a stream of characters
        // String input = sc.nextLine();
        // sc.close();
        // p.firstNonRepeatingLetterInStreamOfChars(input);
    }
}