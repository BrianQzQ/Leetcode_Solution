import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Math.sqrt;

public class NumberOfBoomerangs_447 {
    public static void main(String[] args) {
        int[][]points={{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        NumberOfBoomerangs_447 n=new NumberOfBoomerangs_447();
        n.numberOfBoomerangs1(points);
    }
    public int numberOfBoomerangs1(int[][] points) {
        //Map<Map<Double,Double>,Integer>result=new HashMap<>();
        Map<Integer,Integer>r=new HashMap<>();
        int count =0;
        for(int[]pointi:points){
            r.clear();
            for(int[]pointj:points){
                if(pointi==pointj)
                    continue;
                int distance=(pointi[0]-pointj[0])*(pointi[0]-pointj[0])+(pointi[1]-pointj[1])*(pointi[1]-pointj[1]);
                if(r.containsKey(distance)) {
                    count +=r.get((distance))*2;
                    r.put(distance, r.get(distance) + 1);

                }
                else
                    r.put(distance,1);
            }
            /*
            for (Iterator it=r.keySet().iterator();it.hasNext();){
                int t=r.get(it.next());
                if(t==1){
                    continue;
                }else {
                    count+=t*(t-1);
                }
            }

             */
        }
        return count;
    }
}
