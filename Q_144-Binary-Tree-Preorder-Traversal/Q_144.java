import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Pre_order_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>p=new ArrayList<>();
        if(root==null)return p;
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp=stack.pop();
            if(temp.right!=null)
                stack.push(temp.right);
            p.add(temp.val);
            if(temp.left!=null)
                stack.push(temp.left);
        }
        return p;
    }
}
