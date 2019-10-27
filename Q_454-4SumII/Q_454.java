import java.util.HashMap;
import java.util.Map;

public class FourSum2_454 {
    public static void main(String[] args) {

    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new HashMap<>();
        int N=A.length;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int sum=C[i]+D[j];
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum)+1);
                }
                else
                    map.put(sum,1);
            }
        }
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int target=0-A[i]-B[j];
                if(map.containsKey(target)){
                    count+=map.get(target);
                }
            }
        }
        return count;
    }
}
