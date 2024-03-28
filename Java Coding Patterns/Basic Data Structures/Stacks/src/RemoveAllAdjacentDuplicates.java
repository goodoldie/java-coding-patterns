import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    public static String removeAdjacentDuplicates(String string) throws NullPointerException{
        if (string.isEmpty())
            throw new NullPointerException("String cannot be empty");

        Stack<Character> stack = new Stack<>();
        for (char c : string.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "abbddaccaaabcd";
        try{
            String result = removeAdjacentDuplicates(input);
            System.out.println(result);
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }

    }
}
