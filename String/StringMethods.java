import java.util.Scanner;

public class StringMethods {
    public static String subString(String input,int s,int e) {
        String ans ="";
        for(int i=s;i<e;i++) {
            ans+=input.charAt(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Substring is: "+subString(input, 0, 5) );
        System.out.println("Substring is: "+input.substring(0, 5) );
        
    }
}
