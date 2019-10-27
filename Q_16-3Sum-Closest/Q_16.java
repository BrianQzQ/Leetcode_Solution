import java.util.Arrays;

import static java.lang.Math.abs;

public class ThreeSumClosest_16 {
    public static void main(String[] args) {
        int[]nums={0,1,2};
        int taget=3;
        ThreeSumClosest_16 t=new ThreeSumClosest_16();
        t.threeSumClosest(nums,taget);

    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int clo=nums[0]+nums[1]+nums[2];
        int dif=abs( clo-target);
        int N=nums.length;
        for(int i=0;i<N-2;i++){
            int l=i+1,r=N-1;
            while (l<r){
                int nsum=nums[i]+nums[r]+nums[l];
                int ndif=abs(nsum-target);

                if(ndif==0)
                    return nsum;


                if(ndif<dif){
                    dif=ndif;
                    clo=nsum;
                }
                if(nsum<target)l++;
                else r--;
            }
        }
        return clo;
    }
}
