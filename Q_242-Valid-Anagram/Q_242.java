import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Valid_Anagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Integer> record=new HashMap<>();
        for(char c:s.toCharArray()){
            if(record.containsKey(c))
                record.put(c,record.get(c)+1);
            else
                record.put(c,1);
        }
        for(char c:t.toCharArray()){
            if(!record.containsKey(c)||record.get(c)<=0)
                return false;
            else
                record.put(c,record.get(c)-1);
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] countArrayS = new int[26];
        int[] countArrayT = new int[26];
        for(char c : s.toCharArray()){
            countArrayS[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            countArrayT[c - 'a']++;
        }

        for(int i = 0 ; i < 26; i++){
            if(countArrayS[i] != countArrayT[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i <26; i++) {
            if (table[i] > 0||table[i]<0) {
                return false;
            }
        }
        return true;
    }
}
