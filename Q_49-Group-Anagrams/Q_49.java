import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams_49 g = new GroupAnagrams_49();
        g.groupAnagrams2(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<int[], List<String>> m = new HashMap<>();

        for (String d : strs) {
            int[] frequency = new int[26];
            for (char c : d.toCharArray()) {
                frequency[c - 'a']++;
            }
            boolean a = false;
            for (Iterator it = m.keySet().iterator(); it.hasNext(); ) {
                Object s = it.next();
                if (Arrays.equals((int[]) s, frequency)) {
                    List<String> n = m.get(s);
                    n.add(d);
                    m.put((int[]) s, n);
                    a = true;
                    break;
                }
                //int[]temp=m.keySet();
            }
            if (a == false) {
                List<String> n = new ArrayList<>();
                n.add(d);
                m.put(frequency, n);
            }
        }
        for (Iterator it = m.keySet().iterator(); it.hasNext(); ) {
            result.add(m.get(it.next()));
        }

        return result;

    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();

        for (String d : strs) {
            char[] c=d.toCharArray();
            Arrays.sort(c);
            String temp= new String(c);
            if(!m.containsKey(temp)){
                m.put(temp,new ArrayList<>());
            }
            m.get(temp).add(d);

        }
        result.addAll(m.values());

        return result;

    }
}

