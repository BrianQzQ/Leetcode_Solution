package Medium;

public class Q_86 {
    public static void main(String[] args) {

    }
    public ListNode partition(ListNode head, int x) {
        ListNode ll=null,lr=null,rl=null,rr=null;
        while (head!=null){
            ListNode node=head;
            head=head.next;
            if(node.val<x){
                if(ll==null){
                    if(rl==null){
                        node.next=null;
                        ll=node;
                        lr=node;
                    }
                    else{
                        node.next=rl;
                        ll=node;
                        lr=node;
                    }
                }
                else {
                    node.next=rl;
                    lr.next=node;
                    lr=node;
                }
            }
            else{
                if(rl==null){
                    if(lr==null){
                        node.next=null;
                        rl=node;
                        rr=node;
                    }
                    else {
                        lr.next=node;
                        node.next=null;
                        rl=node;
                        rr=node;
                    }
                }
                else {
                    rr.next=node;
                    node.next=null;
                    rr=node;
                }
            }
        }


        return ll==null?rl:ll;
    }

}
