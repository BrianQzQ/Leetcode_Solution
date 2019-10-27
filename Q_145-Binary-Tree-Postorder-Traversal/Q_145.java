import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root==null)return l;
        Stack<TreeNode> stack = new Stack<>();
        //TreeNode p = root;
        TreeNode head = root;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode t = stack.peek();
            if ((t.left == null && t.right == null) || t.left == head || t.right == head) {
                l.add(t.val);
                stack.pop();
                head = t;
            } else {
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return l;
    }
}
