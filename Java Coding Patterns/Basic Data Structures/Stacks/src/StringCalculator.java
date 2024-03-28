import java.util.Stack;

public class StringCalculator {

    public static int calculator(String expression) throws IllegalArgumentException{

        if (expression.isEmpty())
            throw new IllegalArgumentException("Expression to evaluate cannot be empty");

        int signValue = 1;
        int number = 0;
        int result = 0;
        int secondValue = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < expression.length(); i ++){

            char c = expression.charAt(i);

            if(Character.isDigit(c))
                number = number * 10 + Character.getNumericValue(c);

            else if (c == '+' || c == '-'){

                if (c == '-')
                    signValue = -1;
                else
                    signValue = 1;
                result = number * signValue;
                number = 0;
            }
            else if ( c == '('){

                stack.push(result);
                stack.push(signValue);
                result = 0;
                signValue = 1;
            }
            else if ( c == ')' ) {

                result += signValue * number;
                int popSignValue = stack.pop();
                result *= popSignValue;

                secondValue = stack.pop();
                result += secondValue;
                number = 0;
            }
        }
        return result + number * signValue;
    }
    public static void main(String[] args) {
        String input1 = "(31 + 7) - (5 - 2)";
        String input2 = "(12 - 9 + 4) + (7 - 5)";
        try{
            System.out.println("Result 1 : " + calculator(input1));
            System.out.println("Result 2 : " + calculator(input2));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
