import java.util.Arrays;

public class canPartition_416 {
    public static void main(String[] args) {
        int[]nums={1,5,11,5};
        canPartition_416 c=new canPartition_416();
        boolean a=c.canPartition2(nums);
        System.out.println(a);
    }

    int[][] memo;

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        memo = new int[nums.length][sum / 2+1];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(memo[i], -1);
        return tryPartition(nums, nums.length - 1, sum / 2);

    }

    public boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) return true;
        if (sum < 0 || index < 0) return false;
        if (memo[index][sum-1] != -1)
            return memo[index][sum-1] == 1;
        memo[index][sum-1] = (tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index]) ? 1 : 0);
        return memo[index][sum-1] == 1;
    }

    public boolean canPartition(int[]nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int N=nums.length,C=sum/2;
        boolean[]memo= new boolean[C + 1];
        Arrays.fill(memo,false);
        for(int i=0;i<=C;i++){
            memo[i]=(nums[0]==i);
        }
        for(int i=1;i<N;i++){
            for(int j=C;j>=nums[i];j--){
                memo[j]=memo[j]||memo[j-nums[i]];
            }
        }
        return memo[C];
    }


}
