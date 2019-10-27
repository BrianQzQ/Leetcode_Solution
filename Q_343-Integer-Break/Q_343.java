
import java.util.Arrays;


public class integerBreak_343 {
    public static void main(String[] args) {

    }

    int[] memo;

    private int breakInteger(int n) {
        if (n == 1)
            return 1;
        int res = -1;
        if (memo[n] != -1)
            return memo[n];
        for (int i = 1; i <= n - 1; i++)
            //i+(n-i)
            res = Math.max(Math.max(res, i * (n - i)), i * breakInteger(n - i));
        memo[n] = res;
        return res;
    }

    public int integerBreak2(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return breakInteger(n);
        //return 0;
    }

    public int integerBreak(int n) {
        if (n == 2) return 1;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            int res = -1;
            for (int j = 1; j <= i - 1; j++) {
                res = Math.max(Math.max(res, j * (i - j)), j * memo[i - j]);
            }
            memo[i] = res;
        }
        return memo[n];
    }
}
