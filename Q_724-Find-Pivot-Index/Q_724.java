package Easy;

public class Q_724 {
    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,-1,-1,0};
        Q_724 q = new Q_724();
        q.pivotIndex(nums);
    }
    public int pivotIndex(int[] nums) {
        int sum=0;int l=0;int suml=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        while (l<nums.length){
            if(sum-suml-nums[l]==suml)
                return l;
            else {
                l++;
                suml+=nums[l];
            }
        }
        return -1;
    }
    public int pivotIndex2(int[] nums) {
        if(nums.length<=1)return -1;
        int l = 0, r = nums.length - 1;
        int suml = 0;
        int sumr = 0;
        int dis=nums[r]-nums[l];
        while (l<r) {
            dis=sumr-suml;
            if (sumr-(suml+nums[l]) <= dis) {
                suml += nums[l];
                l++;
            } else {
                sumr += nums[r];
                r--;
            }
        }
        if (suml == sumr)
            return l ;
        return -1;
    }

}
