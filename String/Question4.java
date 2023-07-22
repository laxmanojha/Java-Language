import java.util.Scanner;

public class Question4 {
    public static String changeCase(String input) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<input.length();i++)
        {
            if( (input.charAt(i)>='a' && input.charAt(i)<='z')&& (i==0 ||input.charAt(i-1) == ' ')) {
                sb.append((char)(input.charAt(i) - 32));
            }
            else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("After updation: "+changeCase(input));
    }
}
