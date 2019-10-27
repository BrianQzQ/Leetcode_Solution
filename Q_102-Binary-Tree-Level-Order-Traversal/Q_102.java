import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int size=0;
        //List<Integer>temp=new ArrayList<>();
        while (!q.isEmpty()){
            List<Integer>temp=new ArrayList<>();
            size=q.size();
            for(int i=0;i<size;i++){
                TreeNode t=q.remove();
                temp.add(t.val);
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
            }
            res.add(temp);
        }
        return res;
    }
}
