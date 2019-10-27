import java.util.Stack;

public class Simplify_Path_71 {
    public static void main(String[] args) {
        String path = "/abc/...";
        Simplify_Path_71 s = new Simplify_Path_71();
        System.out.println(s.simplifyPath(path));
    }

    public String simplifyPath1(String path) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        for (char c : path.toCharArray()) {
            if (c != '/')
                temp += String.valueOf(c);
            if (c == '/') {
                if (temp.length() == 0)
                    continue;
                else if (temp.equals("..")) {
                    if (!stack.empty())
                        stack.pop();
                } else if (temp.equals(".")){}

                else
                    stack.push(temp);
                temp = "";
            }
        }
        if (temp.equals ("..") ) {
            if (!stack.empty())
                stack.pop();
            temp = "";
        }
        if(temp.equals("."))
            temp="";
        if (temp != "") stack.push(temp);
        if (stack.empty())
            return "/";
        String t = "";
        while (!stack.empty()) {
            t = "/" + stack.pop() + t;
        }
        //System.out.println(t);
        return t;
    }

    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String l : s) {
            if (l.equals(".")||l.equals(""))
                continue;
            if (l.equals("..")) {
                if (!stack.empty())
                    stack.pop();
            } else
                stack.push(l);
        }
        if (stack.empty())
            return "/";
        String t = "";
        while (!stack.empty()) {
            t = "/" + stack.pop() + t;
        }
        //System.out.println(t);
        return t;
    }
}
