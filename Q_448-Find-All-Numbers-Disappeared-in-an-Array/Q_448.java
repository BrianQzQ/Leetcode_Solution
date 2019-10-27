package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q_448 {
    public static void main(String[] args) {
        int[]nums={4,3,2,7,8,2,3,1};
        Q_448 q=new Q_448();
        q.findDisappearedNumbers(nums);
    }
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer>l=new ArrayList<>();
        return l;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer>l=new ArrayList<>();
        if (nums.length==0)return l;
        int max= Arrays.stream(nums).max().getAsInt();
        max=Math.max(max,nums.length);
        for(int i=1;i<=max ;i++)
            l.add(i);
        for(int i:nums){
            if(l.get(i-1)==0)
                continue;
            else {
                l.remove(i-1);
                l.add(i-1,0);
            }
        }
        int i=0;
        while ( i<l.size()){
            if(l.get(i)!=0)
                i++;
            else
                l.remove(i);
        }
        return l;
    }
}
