import java.util.Random;

public class RandomPickWeight {
    //to store the prefix sum
    private final int[] runningSum;
    private final Random randomNumber;

    public RandomPickWeight(int[] weights){
        if(weights.length == 0)
            throw new IllegalArgumentException("Array cannot be empty");

        this.runningSum = new int[weights.length];
        this.randomNumber = new Random();

        //Calculate prefix sum
        runningSum[0] = weights[0];
        for(int i = 1; i < weights.length; i++){
            if(weights[i] < 0)
                throw new IllegalArgumentException("Weights must be non-negative");

            runningSum[i] = runningSum[i-1] + weights[i];
        }
    }
    public int pickIndex(){
        int totalSum = runningSum[runningSum.length - 1];

        // +1 because we want to generate a target between [1...totalSum]
        int target = randomNumber.nextInt(totalSum) + 1;
        System.out.println("Target is " + target);
        int left = 0;
        int right = runningSum.length - 1;
        while(left < right){
            int middle = left + (right - left) / 2;
            if(target > runningSum[middle])
                left = middle + 1;
            else
                right = middle;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] weights = {10, 200, 30, 40};
        int[] weights2 = {1, 10, 23, 32, 41, 56, 62, 75, 87, 90};
        int[] weights3 = {10,10,10,10};
        int[] weights4 = {5,10,15,20,250,300};
        try{
            RandomPickWeight randomPickWeight = new RandomPickWeight(weights2);
            int pickedIndex = randomPickWeight.pickIndex();
            System.out.println("The randomly picked index biased on the weights is " + pickedIndex);
        } catch (IllegalArgumentException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
