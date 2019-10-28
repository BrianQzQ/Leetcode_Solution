package Medium;

public class Q_238 {
    public static void main(String[] args) {
        int[]nums={0,5,0};
        Q_238 q=new Q_238();
        q.productExceptSelf(nums);
    }
    public int[] productExceptSelf(int[] nums) {
        int pro0=1;int zeros=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeros++;
            }
            else {
                pro0*=nums[i];
                //pro1*=nums[i];
            }
        }
        int[]res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(zeros>1){res[i]=0;}
            else if(zeros==1&&nums[i]==0){res[i]=pro0;}
            else if(zeros==1&&nums[i]!=0){res[i]=0;}
            else res[i]=pro0/nums[i];
        }
        return res;
    }
    public int[] productExceptSelf2(int[] nums) {
        int pro1=1,pro0=1;int zeros=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                pro1=0;
                zeros++;
            }
            else {
                pro0*=nums[i];
                pro1*=nums[i];
            }
        }
        int[]res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0&&zeros>1){res[i]=0;}
            else if(nums[i]==0&&zeros==1){res[i]=pro0;}
            else res[i]=pro1/nums[i];
        }
        return res;
    }
}
