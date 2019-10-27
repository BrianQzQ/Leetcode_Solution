import java.sql.Time;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class MaxPoints_149 {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 65536}, {65536, 0}};
        MaxPoints_149 m = new MaxPoints_149();
        // long startTime= System.currentTimeMillis();
        m.maxPoints(points);
        // long endTime= System.currentTimeMillis();
        // long n=endTime-startTime;
        //  System.out.println(n);
    }

    public int maxPoints1(int[][] points) {
        int N = points.length;
        if (N < 3) return N;
        int MaxNum = 2;

        Map<Double, Integer> result = new HashMap<>();
        for (int i = 0; i < N; i++) {
            result.clear();
            int dup = 0;
            for (int j = i + 1; j < N; j++) {
                int delty = points[j][1] - points[i][1];
                int deltx = points[j][0] - points[i][0];
                if (deltx == 0 && delty == 0) {
                   /* double k = Double.MIN_VALUE;
                    if (result.containsKey(k))
                        result.put(k, result.get(k) + 1);
                    else
                        result.put(k, 2);

                    */
                    dup++;
                    continue;
                } else if (deltx == 0) {
                    double k = Double.MAX_VALUE;

                    result.put(k, result.getOrDefault(k, 1) + 1);

                } else {
                    int gcd = gcd(deltx, delty);
                    double k = (delty / gcd) * 1.0 / (deltx / gcd);
                    if (k == -0.0)
                        k = 0.0;
                    if (abs(delty - deltx) == 1 && gcd == 1) {
                        result.put(k, 2);
                        continue;
                    }
                    result.put(k, result.getOrDefault(k, 1) + 1);

                    //MaxNum=max(num+1,MaxNum);
                }
            }
            for (Iterator it = result.keySet().iterator(); it.hasNext(); ) {
                //Object t=it.next();
                int temp = result.get(it.next());

                MaxNum = max(MaxNum, temp + dup);
            }
            MaxNum = max(dup + 1, MaxNum);
        }

        return MaxNum;
    }

    public int maxPoints2(int[][] points) {
        int N = points.length;
        if (N < 3) return N;
        int MaxNum = 0;

        Map<Map<Integer, Integer>, Integer> result = new HashMap<>();
        for (int i = 0; i < N; i++) {
            result.clear();
            int dup = 1;
            for (int j = i + 1; j < N; j++) {

                int delty = points[j][1] - points[i][1];
                int deltx = points[j][0] - points[i][0];
                if (deltx == 0 && delty == 0) {
                   /* double k = Double.MIN_VALUE;
                    if (result.containsKey(k))
                        result.put(k, result.get(k) + 1);
                    else
                        result.put(k, 2);

                    */
                    dup++;
                    continue;
                }
                int d = gcd(deltx, delty);
                Map<Integer, Integer> m = new HashMap<>();
                m.put(deltx / d, delty / d);
                result.put(m, result.getOrDefault(m, 0) + 1);
            }
            for (Iterator it = result.keySet().iterator(); it.hasNext(); ) {
                //Object t=it.next();
                int temp = result.get(it.next());

                MaxNum = max(MaxNum, temp + dup);
            }
            MaxNum = max(dup, MaxNum);
        }

        return MaxNum;
    }

     public int maxPoints(int[][] points) {
        int N = points.length;
        if (N < 3) return N;
        int MaxNum = 2;
        int count;
        for (int i = 1; i < N; i++) {
            count = 0;
            long xm = points[i - 1][0];
            long ym = points[i - 1][1];
            long xn = points[i][0];
            long yn = points[i][1];
            if (xm == xn && ym == yn) {
                for (int j = 0; j < N; j++)
                    if (points[j][0] == xn && points[j][1] == yn)
                        count++;
            } else
                for (int j = 0; j < N; j++) {
                    if ((points[j][1] - yn) * (xm - xn) == (points[j][0] - xn) * (ym - yn))
                        count++;
                }

            MaxNum = max(MaxNum, count);
        }


        return MaxNum;


    }

    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

}
