import java.util.Scanner;

public class First {
    public static void printMatrix(int matrix[][]) {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static Boolean searchKey(int matrix[][], int key) {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(matrix[i][j] == key) {
                    System.out.println("key found at: matrix["+i+"]["+j+"]");
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter Key:");
        int key = sc.nextInt();
        printMatrix(matrix);
        System.out.println("Key found: "+searchKey(matrix, key));
    }
}