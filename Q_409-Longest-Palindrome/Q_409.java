package Easy;

import static java.lang.Math.abs;

public class Q_409 {
    public String longestPalindrome(String s) {
        if(s==""||s.length()==1)return s;
        int[][] a=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<i+1;j++){
//                if(i==j){
//                    a[i][j]=1;
//                }
                if(s.charAt(i)==s.charAt(j)){
                    a[i][j]=1;
                }
                else {
                    a[i][j]=0;
                }
            }
        }

        int len=s.length()-1;
        int [] te = new int[2*len-2];
        for(int temp=2*len;temp>=0;temp--){
            boolean t=false;
            for(int j=0;j<temp-j;j++){
                int i= temp-j;
                if(a[i][j]!=1){
                    t=false;
                    break;
                }
                else {
                    t=true;
                }

            }
            if(t==true){
                te[temp]=1;
                break;
            }
        }
        //int pos=len+1;
        int min=len+1;
        for(int i =0; i<te.length;i++){
            if(te[i]==0&&abs(len-i)<min){
                min=i;
            }
        }
        String l="";
        // l=s.substring()
        //  for()
        return "l";
    }
}
