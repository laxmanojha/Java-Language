public class DiagonalSum {
    public static void printMatrix(int matrix[][]) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void diagonalSum(int matrix[][]) {
        int rowLength = matrix.length-1;
        int colLength = matrix[0].length-1;
        int sum = 0;
        for(int i=0;i<=rowLength;i++) {
            for(int j=0;j<=colLength;j++) {
                if(i==j) {
                    sum+=matrix[i][j];
                }
                else if(i==colLength-j) {
                    sum+=matrix[i][j];
                }
            }
        }
        System.out.println("The diagonal sum "+matrix.length+"x"+matrix.length+" is: "+sum);
    }
    public static void optimizedDiagonalSum(int matrix[][]) {
        int sum = 0;
        // int k=matrix.length-1;
        for(int i=0;i<matrix.length;i++) {
            sum+=matrix[i][i];
            if(i != matrix.length-1-i)
                sum+=matrix[i][matrix.length-1-i];
            // if(i==k) {
            //     sumofSD+=matrix[i][i];
            //     k--;
            //     continue;
            // }
            // sumofPD+=matrix[i][i];
            // sumofSD+=matrix[i][k];
            // k--;
        }
        System.out.println("The Optimized diagonal sum "+matrix.length+"x"+matrix.length+" is: "+sum);
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int matrix2[][] = {{1,2,3,},{5,6,7,},{9,10,11,}};
        printMatrix(matrix);
        printMatrix(matrix2);
        diagonalSum(matrix);
        diagonalSum(matrix2);
        optimizedDiagonalSum(matrix);
        optimizedDiagonalSum(matrix2);
    }
}
