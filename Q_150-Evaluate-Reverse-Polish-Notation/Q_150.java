import java.util.Stack;

public class Reverse_Polish_Notation_150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            //if (Integer.valueOf(s) >= 1 && Integer.valueOf(s) <= 9
            if (s.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (s.equals("-")) {
                int a = 0;
                a += stack.pop();
                stack.push(stack.pop() - a);
            } else if (s.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (s.equals("/")) {
                int a = 0;
                a += stack.pop();
                stack.push(stack.pop() / a);
            } else
                stack.push(Integer.valueOf(s));

        }
        return stack.pop();
    }
}
