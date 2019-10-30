package Easy;

public class Q_680 {
    public static void main(String[] args) {
        String s = "lcuppucul";
        Q_680 m = new Q_680();
        System.out.println(m.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        boolean index = true;
        int ll = 0;
        int rr = 0;
        int count = 0;
        while (l < r) {
            char lc = s.charAt(l), rc = s.charAt(r);
            if (lc == rc) {
                l++;
                r--;
            } else if (lc != rc && count == 1) {
                index = false;
                break;
            } else if (s.charAt(l + 1) == rc && count == 0) {
                ll = l;
                rr = r;
                l++;
                count = 1;
            } else if (lc == s.charAt(r - 1) && count == 0) {
                r--;
                count = 1;
            } else {
                index = false;
                break;
            }
        }
        if (rr == 0 && index == false) return false;
        if (index == true) return true;
        count = 0;
        while (ll < rr) {
            char lc = s.charAt(ll), rc = s.charAt(rr);
            if (lc == rc) {
                ll++;
                rr--;
            } else if (lc != rc && count == 1) {
                return false;
            } else if (lc == s.charAt(rr - 1) && count == 0) {
                rr--;
                count = 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome3(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        int count = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return helper(l + 1, r, s) || helper(l, r - 1, s);
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    public boolean helper(int lindex, int rindex, String s) {
        if (s.length() < 2) {
            return true;
        }
        int i = lindex;
        int j = rindex;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
