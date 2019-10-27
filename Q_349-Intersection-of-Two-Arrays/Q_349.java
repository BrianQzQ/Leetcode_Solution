import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intersection_349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>();
        Set<Integer>resultSet=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            record.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(record.contains(nums2[i])){
                resultSet.add(nums2[i]);
               // record.remove(nums2[i]);
            }
        }
        int[]result=new int[resultSet.size()];
        int i=0;
        for(Iterator it=resultSet.iterator();it.hasNext();){
            result[i++]=it.next().hashCode();
        }
        return  result;
    }
}
