public class BinarySearch {
    public static int binarySearch(int[] inputArray, int target){
        if(inputArray == null || inputArray.length == 0)
            throw new IllegalArgumentException("Array cannot be empty");

        int start = 0;
        int end = inputArray.length - 1;

        while(start <= end){
            //to avoid overflow of integer
            int middle = start + (end - start)/2;
            if(inputArray[middle] == target)
                return middle;
            else if(inputArray[middle] > target)
                end = middle - 1;
            else
                start = middle + 1;
        }
        throw new IllegalArgumentException("Target element not found in the array.");
    }
    public static void main(String[] args) {
        int[] inputArray = {11,22,33,44,55,66,77};
        int target = 33;
        try{
            int index = binarySearch(inputArray, target);
            System.out.println("The target element is preset at index " + index);
        } catch (IllegalArgumentException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
