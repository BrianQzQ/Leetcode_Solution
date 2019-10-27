

import java.util.*;

import static java.lang.Math.max;

public class Sort_Characters_By_Frequency_451 {
    public static void main(String[] args) {
        String s = "tree";
        Sort_Characters_By_Frequency_451 w = new Sort_Characters_By_Frequency_451();
        System.out.println(w.frequencySort(s));
    }

    public String frequencySort(String s) {
        if (s.length() <= 2) return s;
        Map<Character, Integer> f = new HashMap<>();
        int Maxc = 0;
        String result = "";
        List<Character> t = new ArrayList<>();
        for (char c : s.toCharArray()) {
            f.put(c, f.getOrDefault(c, 0) + 1);
            Maxc = max(Maxc, f.get(c));
        }

        while (t.size() < f.size()) {
            int nextMax = 0;
            for (Character x : f.keySet()) {
                if (f.get(x) == Maxc) {
                    t.add(x);
                    for(int i=0;i<Maxc;i++)
                        result = result + String.valueOf(x);
                } else {
                    if (f.get(x) < Maxc)
                        nextMax = max(nextMax, f.get(x));
                }
            }
            Maxc = nextMax;
        }
        return result;
    }

    public String frequencySort2(String s){
        if (s.length() <= 2) return s;
        Map<Character, Integer> f = new HashMap<>();
        List<Pair<Integer,Character>>l=new ArrayList<>();
        for (char c : s.toCharArray()) {
            f.put(c, f.getOrDefault(c, 0) + 1);
        }




        return s;
    }
}
