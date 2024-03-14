public class SearchInRotatedSortedArray {
    public static int searchRotatedSortedArray(int[] rotatedSortedArray, int target) throws IllegalArgumentException{
        if(rotatedSortedArray.length == 0)
            throw new IllegalArgumentException("Array must not be null or empty.");

        int left = 0;
        int right = rotatedSortedArray.length - 1;

        while(left <= right){
            int middle = left + (right - left) / 2;

            if(rotatedSortedArray[middle] == target)
                return middle;
            //Check if left half of the array is sorted
            if(rotatedSortedArray[left] <= rotatedSortedArray[middle]){
                if(rotatedSortedArray[left] <= target && rotatedSortedArray[middle] > target)
                    right = middle - 1;
                else
                    left = middle + 1;
            }
            else{
                if(rotatedSortedArray[right] >= target && rotatedSortedArray[middle] < target)
                    left = middle + 1;
                else
                    right = middle - 1;
            }
        }
        throw new IllegalArgumentException("Target element not found in the array.");
    }
    public static void main(String[] args) {
        int[] rotatedSortedArray = {8,9,10,1,2,3,4,5,6,7};
        int target = 6;
        try{
            System.out.println("Element " + target + " found at index " + searchRotatedSortedArray(rotatedSortedArray, target));
        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }

    }
}
