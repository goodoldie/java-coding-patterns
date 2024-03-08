public class CircularArrayLoop {
    //A Loop should have at least 2 nodes
    public static boolean hasCircularArrayLoop(int[] inputArray){
        int size = inputArray.length;

        for(int i = 0; i < size; i++){
            int slow = i, fast = i;
            boolean forward = inputArray[i] > 0;

            while (true){
                slow = nextStep(slow, inputArray[slow], size);
                if(isNotCycle(inputArray, forward, slow))
                    break;

                fast = nextStep(fast, inputArray[fast], size);
                if (isNotCycle(inputArray, forward, fast))
                    break;

                fast = nextStep(fast, inputArray[fast], size);
                if (isNotCycle(inputArray, forward, fast))
                    break;

                if (slow == fast)
                    return true;
            }
        }
        return false;
    }
    //Function to calculate the next step from an array index
    private static int nextStep(int pointer, int value, int size){
        int result = (pointer + value) % size;
        if(result < 0)
            result += size;
        return result;
    }
    // A function to detect a cycle doesn't exist
    private static boolean isNotCycle(int[] inputArray, boolean prevDirection, int pointer) {
        boolean currDirection = inputArray[pointer] >= 0;

        return prevDirection != currDirection || Math.abs(inputArray[pointer] % inputArray.length) == 0;
    }
    public static void main(String[] args) {
        int[] inputArray1 = {-2, -3, 1, -3, 2};
        int[] inputArray2 = {5,4,-2,-1,3};
        int[] inputArray3 = {1,2,-3,3,4,7,1};
        if(hasCircularArrayLoop(inputArray1))
            System.out.println("The given array has a circular loop");
        else
            System.out.println("There is no circular loop present in the array");
    }
}
