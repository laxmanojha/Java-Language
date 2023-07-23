import java.util.Scanner;

public class Spiral {
    public static void printMatrix(int matrix[][]) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void spiralPrint(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        while(startRow<=endRow && startCol<=endCol) {
            //first row
            for(int j=startCol;j<=endCol;j++) {
                System.out.print(matrix[startRow][j]+" ");
            }
            startRow++;
            //end col
            for(int i=startRow;i<=endRow;i++) {
                System.out.print(matrix[i][endCol]+" ");
            }
            endCol--;
            //end row
            for(int j=endCol;j>=startCol;j--) {
                System.out.print(matrix[endRow][j]+" ");
            }
            endRow--;
            //start col
            for(int i=endRow;i>=startRow;i--) {
                System.out.print(matrix[i][startCol]+" ");
            }
            startCol++;
        }
    }
    public static void main(String[] args) {
        // int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // int matrix[][] = {{1,2,3,4},{4,5,6,7}};
        int matrix[][] = {{1,2},{3,4},{5,6},{7,8}};
        printMatrix(matrix);
        spiralPrint(matrix);
    }
}