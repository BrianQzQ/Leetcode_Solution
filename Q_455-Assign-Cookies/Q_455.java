import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Assign_cookies_455 {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        Assign_cookies_455 u = new Assign_cookies_455();
        int a = u.findContentChildren(g, s);
        System.out.println(a);
        /*for (int i : g)
            System.out.print(i + "   ");
         */

    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int si = s.length - 1, gi = g.length - 1;
        int res = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                gi--;
                si--;
            } else {
                gi--;
            }
        }
        return res;
    }


}



