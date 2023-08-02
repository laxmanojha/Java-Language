import java.util.*;

public class Questions {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.empty()) {
            s.push(data);
            return ;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static String reverseStringUsingStack(String str) {
        StringBuilder sb = new StringBuilder("");
        Stack<Character>s = new Stack<>();
        int i=0;
        while(i!=str.length()) {
            s.push(str.charAt(i));
            i++;
        }
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }
    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void printStack(Stack<Integer>s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        System.out.println(top);
        printStack(s);
        s.push(top);
    }
    public static void stockSpanProblem(int[] stock, int[] span) {
        Stack<Integer>s = new Stack<>();

        span[0] = 1;
        s.push(0);
        for(int i=1;i<stock.length;i++)
        {
            int currPrice = stock[i];
            while(!s.isEmpty()&&currPrice>=stock[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            }
            else {
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        Stack<Integer>s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        int stock[] = {100,80,60,70,60,85,100};
        int span[] = new int[stock.length];
        stockSpanProblem(stock,span);
        for(int i=0;i<span.length;i++) {
            System.out.print(span[i]+" ");
        }

        /*QUESTION 3
        printStack(s);
        reverseStack(s);
        printStack(s);*/

        /*QUESTION 2
        String str = "abcedfghi";
        System.out.println(str);
        System.out.println(reverseStringUsingStack(str));*/

        
        /*QUESTION 1
        pushAtBottom(s,4);
        while(!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }*/
    }
}