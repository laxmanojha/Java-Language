import java.util.Scanner;

public class SearchInSortedMatrix {
    public static void printMatrix(int matrix[][]) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void searchInSortedMatrix(int matrix[][], int key) {
        int i = matrix.length-1;
        int j = 0;
        while(true) {
            if(matrix[i][j] == key) {
                System.out.println("Key found in matrix.");
                break;
            }
            else if(i < 0 || j > matrix.length-1) {
                
                System.out.println("Key not found in matrix.");
                break;
            }
            else if(matrix[i][j] < key) {
                j++;
            }
            else if(matrix[i][j] > key) {
                i--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);
        int key = sc.nextInt();
        searchInSortedMatrix(matrix,key);
    }
}
