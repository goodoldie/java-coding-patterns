public class RotateImage {
    public static void rotateMatrix(int[][] matrix){
        int n = matrix.length;
        //transpose the matrix
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Now reverse the rows
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        printMatrix(matrix);
    }
    private static void printMatrix(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateMatrix(matrix);

    }
}
