package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class Q_31 {
    public static void main(String[] args) {
        int[]nums={6,5,7,2,1};
        Q_31 main=new Q_31();
        main.nextPermutation(nums);

    }
    public void nextPermutation(int[] nums) {
        if (nums.length<=1)return;
        //int temp=0;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                //find the closest bigger
                for(int j=nums.length-1;j>=i;j--){
                    if(nums[j]>nums[i-1]){
                        /*
                        temp=nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=temp;

                         */
                        swap(nums,i-1,j);
                        Arrays.sort(nums,i,nums.length);
                        return;
                    }
                }
            }
        }
        //reverse
        int l=0;int r=nums.length-1;
        while (l<r){
            /**temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
             */
            swap(nums,l,r);
            l++;r--;
        }
    }
    private void swap(int[]nums,int i ,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
