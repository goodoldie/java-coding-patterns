import java.util.Scanner;

public class Palindrome {

    public static boolean isPalindrome(String str){
        //Empty String is not a palindrome
        if(str == null || str.isEmpty())
            return false;

        //Convert to lowercase for case-insensitivity
        str = str.toLowerCase();

        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            char startChar = str.charAt(start);
            char endChar = str.charAt(end);
            //Skip non-alphanumeric characters
            if(!Character.isLetterOrDigit(start)){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(end)){
                end--;
                continue;
            }
            if(startChar != endChar)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to be checked for palindrome");
        String input = scanner.nextLine();
        if(isPalindrome(input))
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is not a palindrome");
    }
}
