import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagramsfindAnagrams_438 {
    public static void main(String[] args) {
        findAnagramsfindAnagrams_438 f = new findAnagramsfindAnagrams_438();
        String s = "abab";
        String p = "ab";
        List<Integer> a = f.findAnagrams1(s, p);
        System.out.println(a);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int l = 0, r = 0;// minStart = 0, min_Len = Integer.MAX_VALUE,
        int counter = p.length();
        int map[] = new int[26];
        for (char c : p.toCharArray())
            map[c - 'a']++;
        while (r < s.length()) {
            final char c1 = s.charAt(r);
            if (map[c1 - 'a'] > 0) {
                counter--;
            }
            map[c1 - 'a']--;
            r++;
            while (counter == 0) {
                if (p.length() == r - l) {
                    list.add(l);
                }
                final char c2 = s.charAt(l);
                map[c2 - 'a']++;
                if (map[c2 - 'a'] > 0) {
                    counter++;
                }
                l++;
            }
        }
        return list;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;
        int l = 0;
        int r = -1;
        int c = 0;
        int[] mapP = new int[26];
        int[] mapS = new int[26];
        int N=p.length();
        int N2=s.length();
        for (char i : p.toCharArray())
            mapP[i - 'a']++;
        while (r < N2) {
            if (c < N) {
                mapS[s.charAt(++r) - 'a']++;
                c=c+1;
                continue;
            }
            System.out.println(mapS);
            if (Arrays.equals(mapP, mapS)) {
                list.add(l);
            }
            System.out.println(list);
            mapS[s.charAt(l++) - 'a']--;
            /*
            if (r+1 == s.length()) {
                mapS[s.charAt(r) - 'a']++;
                continue;
            }
            */
            if(r+1==s.length())
                break;
            mapS[s.charAt(++r) - 'a']++;
            System.out.println(list);
        }
        return list;

    }

}
