import java.util.Stack;

public class practice {
    public static void main(String[] args) {
        int stocks[] = {100, 80,60,70,60,85,100};
        int span[] = new int[stocks.length];
        for(int i=0;i<span.length;i++) {
            System.out.print(span[i]+" ");
        }
        System.out.println();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;
        for(int i=1;i<stocks.length;i++) {
            while(!st.isEmpty() && stocks[st.peek()]<= stocks[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                span[i] = i+1;
            }
            else {
                span[i] = i-st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<span.length;i++) {
            System.out.print(span[i]+" ");
        }
    }
}