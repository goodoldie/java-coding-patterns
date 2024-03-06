import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<Integer> threeSum(int[] numArray, int targetSum) {
        List<Integer> triplet = new ArrayList<>();
        try {
            if (numArray == null || numArray.length < 3)
                throw new IllegalArgumentException("Array should have at least 3 elements.");

            Arrays.sort(numArray);

            for (int i = 0; i < numArray.length - 2; i++) {
                int left = i + 1;
                int right = numArray.length - 1;

                while (left < right) {
                    int currentSum = numArray[i] + numArray[left] + numArray[right];

                    if (currentSum == targetSum) {
                        triplet.addAll(Arrays.asList(numArray[i], numArray[left], numArray[right]));
                        return triplet;
                    } else if (currentSum < targetSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return triplet;
        } catch (Exception e) {
            System.err.println("Error during processing: " + e.getMessage());
            return triplet; // Returning an empty list on exception
        }
    }

    public static void main(String[] args) {
        int[] numArray = {1, 4, 45, 6, 10, 8};
        int targetSum = 22;

        try {
            List<Integer> triplet = threeSum(numArray, targetSum);

            if (triplet.isEmpty()) {
                System.out.println("Given target triplet does not exist");
            } else {
                System.out.println("Triplet exists: " + triplet);
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
