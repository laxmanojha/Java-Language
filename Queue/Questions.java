import java.util.LinkedList;
import java.util.Queue;

public class Questions {
    public static String firstNonRepeatingOccurence(String input) {
        int[] freq = new int[26]; // a a b c c x b
        StringBuilder ans = new StringBuilder("");
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<input.length();i++) {
            boolean flag = true;
            freq[input.charAt(i)-97]++;
            queue.add(input.charAt(i));
            //while(!queue.isEmpty() && freq[queue.peek()-97] > 1){
            //     queue.pop();
            // }
            while(!queue.isEmpty()) {
                if(freq[queue.peek()-97] == 1) {
                    ans.append(queue.peek()); // a -1 b b b b x
                    flag = false;
                    break;
                }
                else {
                    queue.remove();
                }
            }
            if(flag) {
                ans.append(-1);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String input = "aabccxb";
        System.out.println(firstNonRepeatingOccurence(input));
    }
}