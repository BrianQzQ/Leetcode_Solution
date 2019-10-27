import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public static void main(String[] args) {
        int[]nums={1,0,-1,0,-2,2};
        int target=0;
        FourSum_18 f=new FourSum_18();
        f.fourSum(nums,target);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(nums);
        int N=nums.length;
        for(int fix1=0;fix1<N-3;fix1++){
            if(fix1>0)
                if(nums[fix1]==nums[fix1-1])
                    continue;
            for(int fix2=fix1+1;fix2<N-2;fix2++){
                if(fix2>fix1+1)
                    if(nums[fix2]==nums[fix2-1])
                        continue;
                int target2 = target - nums[fix1]-nums[fix2];
                int l=fix2+1,r=N-1;
                while (l<r){
                    if(nums[l]+nums[r]==target2){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        temp.add(nums[fix1]);
                        temp.add(nums[fix2]);
                        result.add(temp);
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;r--;
                    }else if(nums[l]+nums[r]>target2){
                        r--;
                    }else {
                        l++;
                    }
                }
            }
        }

        return result;
    }
}
