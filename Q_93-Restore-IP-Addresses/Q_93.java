package Medium;

import java.util.LinkedList;
import java.util.List;

public class Q_93 {

    static LinkedList<String> res=new LinkedList<>();
    String[]temp=new String[4];
    public List<String> restoreIpAddresses(String s) {
        findIP(s,4,0);
        return res;
    }
    private void findIP(String s,int k,int index){
        if(k==0&&index==s.length()){
            //r[3]=s.substring(index);
            //if(temp[0].length()+temp[1].length()+temp[2].length()+temp[3].length()==s.length())
                store();
            return;
        }
        if(k==0){
            return;
        }

        for(int i=1;i<=3;i++){
            if(index+i>s.length())continue;
            if(isValid(s.substring(index,index+i))){
                temp[4-k]=s.substring(index,index+i);
                findIP(s,k-1,index+i);
            }
            else
                return;
        }
    }
    private boolean isValid(String s){
        if(s.equals("") || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0'))
            return false;
        int res = Integer.valueOf(s);
        if(res <= 255 && res >= 0)
            return true;
        return false;
    }
    private void store(){
        String s="";
        s=temp[0]+"."+temp[1]+"."+temp[2]+"."+temp[3];
        res.addLast(s);
    }
    public static void main(String[] args) {
        Q_93 main=new Q_93();
        String s="25525511135";
        main.restoreIpAddresses(s);
        for(int i=0;i<res.size();i++)
            System.out.println(res.get(i));
    }
}
