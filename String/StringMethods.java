import java.util.Scanner;

public class StringMethods {

    //interning method in strings where all the same data strings are directed to the data created in heap and the new key keyword creates the new data memory in the heap and assign it to the corresponding variable;

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
        // Scanner sc = new Scanner(System.in);
        String arr[] = {"mango", "banana", "apple"};
        String input = "Hello World";
        System.out.println("Substring is: "+subString(input, 0, 5) );
        System.out.println("Substring is: "+input.substring(0, 5) );
        System.out.println("Biggest lexicographically string: "+compareString(arr)[0]);
        System.out.println("Smallest lexicographically string: "+compareString(arr)[1]);

        StringBuilder sb = new StringBuilder("");
        for(char ch = 'a';ch<'z';ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
        // int a = 5;
        Integer b = 5;
        System.out.println(/*a.toString()+*/b.toString());
    }
}
