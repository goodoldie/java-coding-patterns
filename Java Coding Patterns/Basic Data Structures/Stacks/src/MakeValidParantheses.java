import java.util.Stack;

public class MakeValidParantheses {
    public static String removeInvalidParantheses(String string) throws IllegalArgumentException{
        if(string.isEmpty())
            throw new IllegalArgumentException("String cannot be empty");

        Stack<int[]> stack = new Stack<>();
        char[] charArray = string.toCharArray();

        for(int i = 0; i < string.length(); i++){
            char value = charArray[i];

            if( !stack.isEmpty() && stack.peek()[0] == '(' && value == ')')
                stack.pop();

            else if (value == '(' || value == ')')
                stack.push(new int[]{value, i});
        }

        while(!stack.isEmpty()){
            charArray[stack.pop()[1]] = ' ';
        }

        StringBuilder result = new StringBuilder();
        for (char c : charArray){
            if(c != ' ')
                result.append(c);
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String input = ")((qi)(kl)((y(yt))(r(q(g)s))(";
        try{
            System.out.println(" Valid String is : " + removeInvalidParantheses(input));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
