import java.util.Scanner;

public class Palindrome {
    public static Boolean checkPalindrome(String input) {
        int i=0;
        int j=input.length()-1;
        while(i<j) {
            if(input.charAt(i++) == input.charAt(j--)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to check palindrome: ");
        String input = sc.nextLine();
        System.out.println("String is Palindrome: "+checkPalindrome(input));
    }
}
