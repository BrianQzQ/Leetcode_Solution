package Easy;

public class Q_443 {
    public static void main(String[] args) {
        char[] chars = {'a', 'b','c'};
        Q_443 s = new Q_443();
        System.out.println(s.compress(chars));
    }

    public int compress(char[] chars) {
        if (chars.length <= 1) return chars.length;
        int l = 0;
        int count = 1;
        char a = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != a) {
                if (count == 1) {
                    chars[l++] = a;
                    a = chars[i];
                    count = 1;
                } else {
                    chars[l++]=a;
                    for (char c : String.valueOf(count).toCharArray())
                        chars[l++] = c;
                    a = chars[i];
                    count=1;
                }
            }
            else {
                count++;
            }
        }
            if (count == 1) {
                chars[l++] = a;
            } else {
                chars[l++]=a;
                for (char c : String.valueOf(count).toCharArray())
                    chars[l++] = c;
            }

        return l-1;
    }
}
