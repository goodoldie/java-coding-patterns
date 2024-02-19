public class Palindrome {

    public static boolean isPalindrome(String str){
        str = str.toLowerCase();
        int start = 0, end = str.length() - 1;
        for(; start < end; start++, end--){
            if(str.charAt(start) != str.charAt(end))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String input1 = "abccba";
        String input2 = "Bob";
        String input3 = "Alice";
        String input4 = "AaabbB";
        System.out.println(input1 + " is a palindrome: " + isPalindrome(input1));
        System.out.println(input2 + " is a palindrome: " + isPalindrome(input2));
        System.out.println(input3 + " is a palindrome: " + isPalindrome(input3));
        System.out.println(input4 + " is a palindrome: " + isPalindrome(input4));
    }
}
