import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Order_In_94 {
    List<Integer> p = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> p = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.empty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp=stack.pop();
                p.add(temp.val);
                temp = temp.right;
            }
        }

        return p;
    }
}
