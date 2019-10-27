import java.util.*;

public class RightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> q=new LinkedList<>();
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
            int r=temp.get(temp.size()-1);
            res.add(r);
        }
        return res;
    }


}
