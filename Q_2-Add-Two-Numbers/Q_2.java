package Medium;

public class Q_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       /*
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }
*/
        ListNode p = new ListNode(0);
        ListNode q = p;

        boolean a = false;
        while (l1 != null || l2 != null) {
            int temp = 0, tem = 0, in = 0;
            if (a == true) {
                tem = 1;
                a = false;
            }
            if (l1 == null) {
                in = l2.val + tem;
                temp = (in) % 10;
                if (in >= 10) {
                    a = true;
                }
                l2 = l2.next;
            }
            else if (l2 == null) {
                in = l1.val + tem;
                temp = (in) % 10;
                if (in >= 10) {
                    a = true;
                }
                l1 = l1.next;
            }
            else {
                in = l1.val + l2.val + tem;
                temp = (in) % 10;
                if (in >= 10) {
                    a = true;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            //  ListNode t=new ListNode(temp);
            q.next = new ListNode(temp);
            q = q.next;

        }
        if (a == true) {
            q.next = new ListNode(1);

        }

//        for(int i=0;i<max(x1.length(),x2.length());i++){
//            int temp=0,tem=0;
//            if(a==true){
//                tem=1;
//                a=false;
//            }
//            if(i>=x1.length()){
//                temp=(Integer.valueOf(String.valueOf(x2.charAt(i))) +tem)%10;
//                if((Integer.valueOf(String.valueOf(x2.charAt(i))) +tem)/10==1){
//                    a=true;
//                }
//            }
//            if(i>=x2.length()){
//                temp=(Integer.valueOf(String.valueOf(x1.charAt(i))) +tem)%10;
//                if((Integer.valueOf(String.valueOf(x1.charAt(i))) +tem)/10==1){
//                    a=true;
//                }
//            }
//            else{temp=(Integer.valueOf(String.valueOf(x1.charAt(i)))+Integer.valueOf(String.valueOf(x2.charAt(i))) +tem)%10;
//            if((Integer.valueOf(String.valueOf(x1.charAt(i)))+Integer.valueOf(String.valueOf(x2.charAt(i))) +tem)/10==1){
//                a=true;
//            }}
//            q.next=new ListNode(temp);
//            q=q.next;
//            //ne=String.valueOf(temp)+ne;
//            if(i==max(x1.length(),x2.length())-1&&a==true){
//               // ne="1"+ne;
//                q.next=new ListNode(1);
//            }
//
//        }


        return p.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p = null;
        String s1 = "";
        String s2 = "";
        while (l1 != null) {
            s1 += l1.val;
            l1 = l1.next;
        }
        return p;
    }
}
