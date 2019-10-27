public class Is_Subsequence_392 {
    public static void main(String[] args) {
        String s="abc";
        String t="ahbgdc";
        Is_Subsequence_392 i=new Is_Subsequence_392();
        i.isSubsequence(s,t);
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        if(s=="")return false;
        int si = 0, ti = 0;
        int SN=s.length(),TN=t.length();
        while (ti < TN&&si<SN) {
            if((TN-ti)<(SN-si))return false;
            if (t.charAt(ti)== s.charAt(si)) {
                ti++;
                si++;
            } else
                ti++;
        }

        return si==SN;
    }
}
