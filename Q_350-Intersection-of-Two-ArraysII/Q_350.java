import java.util.*;

public class InterSect_350 {
    public static void main(String[] args) {
        InterSect_350 i=new InterSect_350();
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        i.intersect(nums1,nums2);
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        //
        ArrayList<Integer>l=new ArrayList<>();
        //Map<Integer,Integer>record1=new HashMap<>();
        TreeMap<Integer, Integer> record1 = new TreeMap<Integer, Integer>();
        for(int num:nums1) {
            if(record1.containsKey(num)){
                record1.put(num,record1.get(num)+1);
            }
            else
                record1.put(num,1);
        }
        for(int num:nums2) {
            if(record1.containsKey(num)&&record1.get(num)>=1){
                l.add(num);

                record1.put(num,record1.get(num)-1);
               // System.out.println(record1.size());
            }
        }
        int[] result=new int[l.size()];
        int i=0;
        /*
        for (Iterator it=l.iterator();it.hasNext();){
            result[i++]=it.next().hashCode();
        }*/
        for(Integer num:l){
            result[i++]=num;
        }
        return  result;
    }

    public int[] intersect2(int[]nums1,int[]nums2){
        if (nums1.length == 0) return nums1;
        if (nums2.length == 0) return nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,k=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }else{
                nums1[k]=nums1[i];
                k++;
                j++;
                i++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}

