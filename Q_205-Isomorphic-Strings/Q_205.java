import javax.lang.model.type.NullType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic_Strings_205 {
    public static void main(String[] args) {
        String s="abb",t="egg";
        Isomorphic_Strings_205 i=new Isomorphic_Strings_205();

        System.out.println(i.isIsomorphic2(s,t));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> record = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (record.containsKey(s.charAt(i)) && record.get(s.charAt(i)) != t.charAt(i))
                return false;
            else
                record.put(s.charAt(i), t.charAt(i));
        }
        Set<Character> set = new HashSet<>();
        for (char c : record.values())
            set.add(c);
        if (set.size() != record.size())
            return false;
        return true;
    }

    public boolean isIsomorphic2(String s, String t){
        if (s == null || s.isEmpty())
            return (t == null || t.isEmpty());

        if (s.length() != t.length())
            return false;
        int[]ss=new int[256];
        int[]st=new int[256];
        //System.out.println(ss[0]== 0);

        for(int i=0;i<s.length();i++){
            /*
            if(ss[s.charAt(i)]!=0&&ss[s.charAt(i)]!=t.charAt(i))
                return false;
            else if(st[t.charAt(i)]!=0&&st[t.charAt(i)]!=s.charAt(i))
                return false;
            else{
                ss[s.charAt(i)]=t.charAt(i);
                st[t.charAt(i)]=s.charAt(i);
            }
             */
            char ts=s.charAt(i),tt=t.charAt(i);
            if(ss[ts]==0&&st[tt]==0){
                ss[ts]=tt;
                st[tt]=ts;
            }
            else
                if(ss[ts]!=tt||st[tt]!=ts)
                    return false;
        }


        /*
        int n=s.length();
        for(int i=0;i<n;i++){
            char ts=s.charAt(i);
            char tt=t.charAt(i);
            if(ts==0&&tt==0){
                ss[ts]=tt;
                st[tt]=ts;
            }
            else{
                if (ss[ts] != tt || st[tt] != ts) {
                    return false;
                }
            }
        }

         */
        /*
        for(int i=0;i<n;i++){
            if(ss[s.charAt(i)]!=st[t.charAt(i)])
                return false;
            ss[s.charAt(i)]=i+1;
            st[t.charAt(i)]=i+1;
        }

         */
        return true;
    }
}
