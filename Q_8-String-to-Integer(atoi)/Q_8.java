package Medium;

public class Q_8 {
    public int myAtoi(String str) {
        int j = 0;
        String l = "";
        String t = "0123456789";
        char x = ' ';
        boolean a = false;
        // str=str.strip();
        // System.out.println(str.subSequence(1,2));
        for (int i = 0; i < str.length(); i++) {
            //System.out.println(str.charAt(i));
            x = str.charAt(i);
            if (x == ' ' && a == false) {
                continue;
            }
            if (x == '+' && a == false) {
                a = true;
                continue;
            }
            if (x == '-' && a == false) {
                l += "-";
                a = true;
                continue;
            }
            if (!t.contains(str.subSequence(i, i + 1))) {
                break;
            }

            if (t.contains(str.subSequence(i, i + 1))) {
                a = true;
                l += x;
            }


        }
        try {
            j = Integer.parseInt(l);
        } catch (NumberFormatException e) {
            try {
                if (Double.valueOf(l) < -2147483648) {
                    j = -2147483648;
                } else if (Double.valueOf(l) > 2147483647) {
                    j = 2147483647;
                }
            } catch (NumberFormatException ex) {
                j = 0;
            }
        }

        return j;
    }
}
