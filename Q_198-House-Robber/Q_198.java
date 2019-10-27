import java.util.Arrays;

public class Rob_198 {
    public static void main(String[] args) {

    }

    //memo[index]表示考虑偷[index,n-1]能获得的最大收益
    int[] memo;

    public int rob2(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return _rob(nums, 0);
    }

    //考虑抢劫nums[index,n-1]的房子
    private int _rob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;
        if (memo[index] != -1)
            return memo[index];
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + _rob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }

    public int rob(int[] nums) {
        int n=nums.length;
        if (n==0)return 0;
        int[]memo=new int[n];
        Arrays.fill(memo,-1);
        //memo[n]=0;
        memo[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            for(int j=i;j<n;j++)
                memo[i]=Math.max(memo[i],nums[j]+(j+2<n?memo[j+2]:0));//偷j
        }
        return memo[0];
    }
    }
