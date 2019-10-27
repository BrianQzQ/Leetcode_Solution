package Easy;

public class Q_283 {
    public void moveZeroes(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                num++;
                continue;
            }
            nums[i - num] = nums[i];
        }
        for (int i = nums.length - 1; i > nums.length - 1 - num; i--) {
            nums[i] = 0;
        }
    }
}
