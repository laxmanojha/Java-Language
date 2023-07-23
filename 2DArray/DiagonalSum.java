public class DiagonalSum {
    public static void printMatrix(int matrix[][]) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void diagonalSumNXN(int matrix[][]) {
        int rowLength = matrix.length-1;
        int colLength = matrix[0].length-1;
        int sum = 0;
        for(int i=0;i<=rowLength;i++) {
            for(int j=0;j<=colLength;j++) {
                if(i==j) {
                    sum+=matrix[i][j];
                }
                if(i==colLength-j) {
                    sum+=matrix[i][j];
                }
            }
        }
        System.out.println("The diagonal sum NXN is: "+sum);
    }
    public static void diagonalSumNXM(int matrix[][]) {
        int rowLength = matrix.length-1;
        int colLength = matrix[0].length-1;
        int sum = 0;
        for(int i=0;i<=rowLength;i++) {
            for(int j=0;j<=colLength;j++) {
                if(i==j && i==colLength-j) {
                    sum+=matrix[i][j];
                    continue;
                }
                if(i==j) {
                    sum+=matrix[i][j];
                }
                if(i==colLength-j) {
                    sum+=matrix[i][j];
                }
            }
        }
        System.out.println("The diagonal sum of NXM is: "+sum);
    }
    public static void main(String[] args) {
        int matrixNXN[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int matrixNXM[][] = {{1,2,3,},{5,6,7,},{9,10,11,}};
        printMatrix(matrixNXN);
        diagonalSumNXN(matrixNXN);
        printMatrix(matrixNXM);
        diagonalSumNXM(matrixNXM);
    }
}
