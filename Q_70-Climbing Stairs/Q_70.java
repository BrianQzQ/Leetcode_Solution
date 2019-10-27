import java.util.Arrays;

public class ClimbStairs_70 {

    public static void main(String[] args) {

    }

    int[] memo;

    public int climbStairs2(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return _cl(n);
    }

    public int _cl(int n) {
        if (n == 1||n==0)
            return 1;
        if (n == 2)
            return 2;
        if (memo[n] == -1)
            memo[n] =  _cl(n-1) + _cl(n-2);
        return memo[n];
    }

    public int climbStairs(int n){
        if (n == 1||n==0)
            return 1;
        if (n == 2)
            return 2;
        int[]memo=new int[n+1];
        memo[0]=1;memo[1]=1;memo[2]=2;
        for(int i=3;i<=n;i++)
            memo[i]=memo[i-1]+memo[i-2];
        return memo[n];
    }
}
