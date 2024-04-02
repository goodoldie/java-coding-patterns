import java.util.ArrayList;

public class SpiralMatrix {

    public static ArrayList<Integer> spiralMatrix(int[][] matrix){
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int direction = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right){
            if (direction == 0){
                for(int i = left; i <= right; i++ )
                    result.add(matrix[top][i]);
                top++;
            }
            else if (direction == 1) {
                for (int i = top; i <= bottom; i++)
                    result.add(matrix[i][right]);
                right--;
            }
            else if (direction == 2) {
                for (int i = right; i >= left; i--)
                    result.add(matrix[bottom][i]);
                bottom--;
            }
            else if (direction == 3) {
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }

            direction = (direction + 1) % 4;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        ArrayList<Integer> spiralOrderTraversal = new ArrayList<>();
        spiralOrderTraversal = spiralMatrix(matrix);
        for(Integer i : spiralOrderTraversal)
            System.out.print(i + " ");
    }
}
