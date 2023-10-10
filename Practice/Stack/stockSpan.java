import java.util.*;
public class stockSpan {

    void printArray(int[] span) {
        for(int i=0;i<span.length;i++) {
            System.out.print(span[i]+" ");
        }
        System.out.println();
    }
    void usingArray(int[]arr) {
        int span[] = new int[arr.length];
        span[0] = 1;
        for(int i=1;i<arr.length;i++) {
            int count = 1;
            for(int j=i-1;j>=0;j--) {
                if(arr[i]>=arr[j]) {
                    count++;
                }
                else {
                    break;
                }
            }
            span[i] = count;
        }
        printArray(span);
    }
    void usingStack(int[] arr) {
        int span[] = new int[arr.length];
        Stack<Integer>st = new Stack<>();
        st.push(0);
        span[0] = 1;
        for(int i=1;i<arr.length;i++) {
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                span[i] = i+1;
            } else {
                span[i] = i-st.peek();
            }
            st.push(i);
        }
        printArray(span);
    }
    public static void main(String[] args) {
        stockSpan sp = new stockSpan();
        int arr[] = {100,80,60,70,60,85,100};
        sp.printArray(arr);
        sp.usingArray(arr);
        sp.usingStack(arr);



        // String num = "35";
        // System.out.println(num+35);
        // System.out.println(35+Integer.valueOf(num));
        // // int a = Integer.parseInt(num);\
        // System.out.println(35+Integer.parseInt(num));

        
        // StringBuilder sb = new StringBuilder("");
        // // sb.append("vc");
        // // sb.reverse();
        // String st = "a;ldskjf";
        // char[] ch = st.toCharArray();
        // sb.append(ch).toString();
        // System.out.println(sb);
    }
}