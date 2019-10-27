import java.util.LinkedList;
import java.util.List;

public class RemoveNthFromEnd_19 {
    public static void main(String[] args) {
        /*
        List l=new LinkedList();
         l.add(1);
        l.add(2);
         */
        ListNode head=new ListNode(1);
        ListNode h2=new ListNode(2);
        head.next=h2;
        int n=2;
        RemoveNthFromEnd_19 r=new RemoveNthFromEnd_19();
        r.removeNthFromEnd2(head,n);
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode p = head, q = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        if (count == 1 && n == 1)
            return null;


        //System.out.println(count);
        int k = count - n ;
        int N = 0;
        while (N < k - 1) {
            q = q.next;
            N++;
        }
        //System.out.println(q.val);
        //ListNode temp=q;
        q.next = q.next.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode p=head,q=head;
        for(int i=0;i<n;i++){
            p=p.next;
        }
        if(p==null)
            return head.next;
        while (p.next!=null){
            p=p.next;
            q=q.next;
        }
        q.next=q.next.next;
        return head;
    }
}
