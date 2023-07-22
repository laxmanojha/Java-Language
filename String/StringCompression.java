import java.util.Scanner;

public class StringCompression {
    public static String stringCompression(String input) {
        StringBuilder ans = new StringBuilder("");
        int j = 0;
        ans.append(input.charAt(0));
        for(int i=1;i<input.length();i++) {
            if(input.charAt(i) == input.charAt(i-1)) {
                j = i;
                int count = 1;
                while(j<input.length()) {
                    if(input.charAt(j) == input.charAt(j-1)) {
                        count++;
                        j++;
                    }
                    else {
                        break;
                    }
                }
                i=j-1;
                ans.append(count);
            }
            else {
                ans.append(input.charAt(i));
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Compressed string is: "+stringCompression(input));
        // input+=a;
        // System.out.println(input);
    }
}
