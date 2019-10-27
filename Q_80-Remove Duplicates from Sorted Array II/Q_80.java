package Medium;

public class Q_80 {
    public int removeDuplicates(int[] nums) {
        int num=1,count=1;int pos=1;
        boolean dif=false;//false不等于
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                count=1;
                dif=false;
            }
            else{
                count++;
                if(count>2){
                    dif=true;
                }
            }

            if(dif==false){
                nums[pos]=nums[i];
                num++;
                pos++;
            }
        }
        return num;
    }
}
