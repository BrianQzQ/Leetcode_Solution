package Easy;

public class Q_125 {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            char lc = s.charAt(l), rc = s.charAt(r);
            if ((lc<'0')||(lc < 'A'&&lc>'9')|| (lc > 'Z' && lc < 'a') || (lc > 'z') ) {
                l++;
                continue;
            } else if ((rc<'0')||(rc < 'A'&&rc>'9') || (rc > 'Z' && rc < 'a')|| (rc > 'z') ) {
                r--;
                continue;
            } else {
                if (__isPalindrome(lc, rc) == false) {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean __isPalindrome(char a, char b) {
        if((a>='0'&&a<='9')||(b>='0'&&b<='9')){
            return (a==b)?true:false;
        }
        if (a == b || a == b + 32||b==a+32)
            return true;
        return false;
    }

}
