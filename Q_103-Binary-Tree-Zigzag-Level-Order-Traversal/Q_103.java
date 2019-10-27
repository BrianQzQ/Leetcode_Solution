import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        int count=0;
        //List<Integer>temp=new ArrayList<>();
        while (!q.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.remove();
                temp.add(t.val);
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
            }
            if(count%2==1)
                Collections.reverse(temp);
            res.add(temp);
            count++;
        }
        return res;
    }
}
