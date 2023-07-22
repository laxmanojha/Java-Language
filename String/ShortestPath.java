import java.util.Scanner;

public class ShortestPath {
    public static int shortestPath(String input) {
        int x = 0;
        int y = 0;
    
        for(int i=0;i<input.length();i++) {
            if(input.charAt(i) == 'E')  x++;
            else if(input.charAt(i) == 'W')  x--;
            else if(input.charAt(i) == 'N')  y++;
            else  y--;
        }
        int ans = (int)Math.sqrt((x*x)+(y*y));
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Shortest Path will be: "+ shortestPath(input.toUpperCase()));    
    }
}
