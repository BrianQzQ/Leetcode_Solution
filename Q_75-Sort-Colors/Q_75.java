package Medium;

public class Q_75 {
    public void sortColors(int[] nums) {
        int R=0,G=0,B=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                R++;
            else if(nums[i]==1)
                G++;
            else
                B++;
        }
        for(int i=0;i<nums.length;i++){
            if(R==0&&G==0){
                nums[i]=2;
                B--;
                continue;
            }
            else if(R==0){
                nums[i]=1;
                G--;
                continue;
            }
            else{
                nums[i]=0;
                R--;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int R=0,G=-1,B=nums.length;
        while(G+1<B){
            if(nums[G+1]==1){
                G++;
            }
            else if (nums[G+1]==2) {
                nums[G+1]=nums[B-1];
                nums[B-1]=2;
                B--;
            }
            else{
                nums[G+1]=1;
                nums[R]=0;
                G++;R++;
            }
        }
    }
}
