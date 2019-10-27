import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        //String s1="{[(",s2=")}]";
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (map.get(c) == null)
                stack.push(c);
            if (map.get(c) != null) {
                if (stack.empty()) return false;
                if (map.get(c) != stack.pop())
                    return false;
            }
        }
        if (!stack.empty())
            return false;
        return true;
    }
}
