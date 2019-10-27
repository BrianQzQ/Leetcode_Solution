//https://leetcode.com/problems/two-sum/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Q_1 {
    public static void main(String[] args) {
        int[]nums = {2, 5, 5, 11};
        int target = 10;
        Q_1 q=new Q_1();
        q.twoSum2(nums,target);
    }
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
        return res;
    }
    public int[] twoSum2(int[] nums, int target) {
        int[]nums2=nums.clone();
        int[] res = new int[2];
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l<r){
            if(nums[l]+nums[r]==target){
                boolean a=false;
                for(int i=0;i<nums.length;i++){
                    if(nums2[i]==nums[l]&&a==false){
                        res[0]=i;
                        a=true;
                    }
                    else if(nums2[i]==nums[r])
                        res[1]=i;
                    else
                        continue;
                }
                return res;
            }
            else if(nums[l]+nums[r]<target){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
