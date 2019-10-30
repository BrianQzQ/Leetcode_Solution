package Hard;


import java.util.Collections;
import java.util.LinkedList;

public class Q_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<Integer>res=new LinkedList<>();
        for(int i=0;i<lists.length;i++){
            ListNode head=lists[i];
            while (head!=null){
                res.addLast(head.val);
                head=head.next;
            }
        }
        Collections.sort(res);
        ListNode r=new ListNode(0);
        ListNode p=r;
        while (!res.isEmpty()){
            p.next=new ListNode(res.pop());
            p=p.next;
        }
        return r.next;
    }
}
