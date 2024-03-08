import java.util.Scanner;

public class HappyNumbers {
    private static int sumOfSquaredDigits(int num){
        int squareSum = 0;
        while(num != 0){
            int digit = num % 10;
            squareSum += (int) Math.pow(digit, 2);
            num /= 10;
        }
        return squareSum;
    }
    public static boolean isHappyNum(int num){
        if(num < 0)
            throw new IllegalArgumentException("Input must be a positive integer");
        int slowPointer = num;
        int fastPointer = sumOfSquaredDigits(num);

        while(fastPointer != 1 && fastPointer != slowPointer){
            slowPointer = sumOfSquaredDigits(slowPointer);
            fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
        }
        return fastPointer == 1 ;
    }
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number");
            int num = scanner.nextInt();
            if(isHappyNum(num))
                System.out.println(num + " is a Happy number");
            else
                System.out.println(num + " is not a Happy number");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
