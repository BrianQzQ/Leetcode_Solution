import java.util.Arrays;

public class LIS_300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LIS_300 l = new LIS_300();
        l.lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        int res = 1;
        for (int i = 0; i < nums.length; i++)
            res = Math.max(res, memo[i]);
        return res;
    }
}
