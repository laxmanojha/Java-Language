import java.util.*;
public class QueueQuestions {
    public static Queue<Integer> generateBinaryNumbers(int num) {
        Queue<Integer> ans = new LinkedList<>();
        // StringBuilder sb = new StringBuilder("");
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=num;i++) {
            int number = i;
            while(number!=0) {
                stack.push(number%2);
                number/=2;
            }
            while(!stack.isEmpty()) {
                ans.add(stack.pop());
            }
            ans.add(-1);
        }
        return ans;
    }
    public static void main(String[] args) {

        QueueQuestions qq = new QueueQuestions();
        //Question 1 generate binary numbers
        Queue<Integer> ans = qq.generateBinaryNumbers(10);
        int size = ans.size();
        for(int i=0;i<size;i++) {
            int temp = ans.remove();
            if(temp != -1) {
                System.out.print(temp);
            }
            else if(!ans.isEmpty()) {
                System.out.print(" ");
            }
        }
    }
}