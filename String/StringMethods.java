import java.util.Scanner;

public class StringMethods {
    public static String subString(String input,int s,int e) {
        String ans ="";
        for(int i=s;i<e;i++) {
            ans+=input.charAt(i);
        }
        return ans;
    }
    public static String[] compareString(String arr[]) {
        String ansBig = arr[0];
        String ansSmall = arr[0];
        for(int i=0;i<arr.length;i++) {
            if(ansBig.compareTo(arr[i])<0) {
                ansBig = arr[i];
            }
            if(ansSmall.compareTo(arr[i])>0) {
                ansSmall = arr[i];
            }
        }
        String ans[] = new String[2];
        ans[0] = ansBig;
        ans[1] = ansSmall;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr[] = {"mango", "banana", "apple"};
        String input = sc.nextLine();
        System.out.println("Substring is: "+subString(input, 0, 5) );
        System.out.println("Substring is: "+input.substring(0, 5) );
        System.out.println("Biggest lexicographically string: "+compareString(arr)[0]);
        System.out.println("Smallest lexicographically string: "+compareString(arr)[1]);
    }
}
