import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class Word_Pattern_290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        Word_Pattern_290 w = new Word_Pattern_290();
        boolean a = w.wordPattern(pattern, str);
        System.out.println(a);
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> record = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if ((record.containsKey(pattern.charAt(i))) && (!record.get(pattern.charAt(i)).equals(words[i]))) {
                return false;
            } else
                record.put(pattern.charAt(i), words[i]);
        }
        //System.out.println(record.values());
        Set<String> s = new HashSet<>();
        for (String t : record.values()) {
            s.add(t);
        }
        if (s.size() != record.size())
            return false;

        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        //Map<Character, String> record = new HashMap<>();
        Map record = new HashMap();
        for (int i = 0; i < pattern.length(); i++)
            if (record.put(pattern.charAt(i), i) != record.put(words[i], i))
                return false;
        return true;
    }
}
