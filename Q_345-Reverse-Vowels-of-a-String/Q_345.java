package Easy;

public class Q_345 {
    public String reverseVowels(String s) {
        if(s.length()<=1)return s;
        String ls="";String rs="";String S="";
        int l=0;int r=s.length()-1;
        String vowels="aeiouAEIOU";

        while (l<r){
            String lc=s.substring(l,l+1),rc=s.substring(r,r+1);
            if(!vowels.contains(lc)&&!vowels.contains(rc)){
                ls+=s.charAt(l);
                l++;
                rs=s.charAt(r)+rs;
                r--;
                lc="";rc="";
            }
            else if(!vowels.contains(lc)){
                ls+=s.charAt(l);
                l++;
                lc="";
            }
            else if(!vowels.contains(rc)){
                rs=s.charAt(r)+rs;
                r--;
                rc="";
            }
            else{
                ls+=s.charAt(r);
                rs=s.charAt(l)+rs;
                l++;r--;
            }

        }

        S=ls+rs;
        return S;
    }
}
