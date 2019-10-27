package Medium;

import java.util.Arrays;

public class Q_3 {
    public int lengthOfLongestSubstring(String s) {
        int[] frequency = new int[256];
        Arrays.fill(frequency, 0);
        int l = 0, r = -1;
        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && frequency[s.charAt(r + 1)] == 0)
                frequency[s.charAt(++r)]++;
            else
                frequency[s.charAt(l++)]--;
            res = Math.max(r - l + 1, res);
            if (r > s.length())
                break;
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        int[] frequency = new int[256];
        Arrays.fill(frequency, 0);
        int l = 0, r = 0;
        int res = 0;
        char[] p = s.toCharArray();
        while (r < p.length) {
            if (frequency[p[r]] == 0)
                frequency[p[r++]]++;
            else
                frequency[p[l++]]--;
            res = Math.max(r - l, res);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            for (int j = i; j < s.length(); j++) {
                if (temp.contains(s.subSequence(j, j + 1))) {
                    break;
                }
                temp += s.subSequence(j, j + 1);
            }
            if (temp.length() > max) {
                max = temp.length();
            }
        }
        return max;
    }
}
